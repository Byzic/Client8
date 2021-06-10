package client;

import client.utility.AuthManager;
import client.utility.Console;
import common.Request;
import common.Response;
import common.ResponseCode;
import common.User;
import exceptions.ConnectionException;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private String host;
    private int port;
    private User user;
    private DatagramSocket socket;
    private SocketAddress address;
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    public Client(String host, int port){
        this.host = host;
        this.port = port;
        try {
            Scanner scanner = new Scanner(System.in);
            socket = new DatagramSocket();
            address = new InetSocketAddress(this.host, this.port);
        } catch (IOException exception) {
            System.out.println("Произошла ошибка при работе с сервером!");
            exception.printStackTrace();
            System.exit(0);
        }
    }
    public Response receive() throws IOException, ClassNotFoundException {
        byte[] getBuffer = new byte[socket.getReceiveBufferSize()];
        DatagramPacket getPacket = new DatagramPacket(getBuffer, getBuffer.length);
        socket.receive(getPacket);
        return deserialize(getPacket);
    }

    private Response deserialize(DatagramPacket getPacket) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(getPacket.getData());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Response response = (Response) objectInputStream.readObject();
        byteArrayInputStream.close();
        objectInputStream.close();
        return response;
    }

    public void send(Request request) throws IOException {
        byte[] sendBuffer = serialize(request);
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address);
        socket.send(sendPacket);
    }

    private byte[] serialize(Request request) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(request);
        byte[] buffer = byteArrayOutputStream.toByteArray();
        objectOutputStream.flush();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        objectOutputStream.close();
        return buffer;
    }
    /*

    public void run()  {
        try {
            boolean processingStatus = true;
            while (processingStatus) {
                try {
                    connectToServer();
                    processAuthentication();//аутентификация пользователя
                    processingStatus = requestToServer();

                } catch (ConnectionException e) {

                    if (reconnectionAttempts >= maxReconnectionAttempts) {
                        System.err.println("Превышено количество попыток подключения");
                        break;
                    }
                    try {
                        Thread.sleep(4000);
                        System.out.printf("Пытаюсь переподключиться (попытка %d).\n", reconnectionAttempts + 1);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
                reconnectionAttempts++;
            }
            if (channel != null) channel.close();
            System.out.println("Работа клиента успешно завершена.");
        }catch(IllegalArgumentException e){
            System.err.println("Клиент не может быть запущен");
        }catch (IOException e){
            System.err.println("Произошла ошибка при попытке завершить соединение с сервером");
        }


    }
    private void processAuthentication() throws ConnectionException {
        Request requestToServer = null;
        Response serverResponse = null;
        do {
            try {
                requestToServer = authManager.handle();//формиркем запрос на сервер с зависимости от того, есть пароль и логин у клиента
                if (requestToServer.isEmpty()) continue;
                serverWriter.writeObject(requestToServer);
                System.out.println("Запрос отправился");
                serverResponse = (Response) serverReader.readObject();
                System.out.println(serverResponse.getResponseBody());
            } catch (InvalidClassException | NotSerializableException exception) {
                System.err.println("Произошла ошибка при отправке данных на сервер!");
            } catch (ClassNotFoundException exception) {
                System.err.println("Произошла ошибка при чтении полученных данных!");
            } catch (IOException exception) {
                System.err.println("Соединение с сервером разорвано!");
                reconnectionAttempts++;
                connectToServer();

            }
        } while (serverResponse == null || !serverResponse.getResponseCode().equals(ResponseCode.OK));
        user = requestToServer.getUser();
    }





    private void connectToServer() throws ConnectionException{
        try {
            if (reconnectionAttempts >= 1) System.out.println("Повторное соединение с сервером...");
            SocketAddress socket = new InetSocketAddress(hostName, port);
            channel = SocketChannel.open(socket);

            System.out.println("\u001B[37m"+"\u001B[32m"+"Соединение с сервером установлено"+"\u001B[32m"+"\u001B[37m");
            reconnectionAttempts = 0;
            System.out.println("Ожидание разрешения на обмен данными...");




            serverWriter = new ObjectOutputStream(channel.socket().getOutputStream());
            serverReader = new ObjectInputStream(channel.socket().getInputStream());
            System.out.println("Разрешение на обмен данными получено.");


        }catch (IllegalArgumentException e){
            System.err.println("Неверное значение порта");
            throw new IllegalArgumentException();
        }catch (IOException exception) {
            System.err.println("Произошла ошибка при соединении с сервером!");
            throw new ConnectionException(); //для проверки количества попыток подключения
        }


    }
    private boolean requestToServer() throws ConnectionException {
        Request requestToServer = null;//запрос на сервер, в зависимости от команды содержит название команды, аргумент(если есть),элемент коллекции(если есть)
        Response serverResponse = null;
        do {
            try {
                //туть запускаем консоль
                requestToServer = (serverResponse != null ? console.workMode(serverResponse,user) :
                        console.workMode(null,user));
                if (!rlist.isEmpty()){
                    System.out.println(rlist.get(rlist.size()-1).getResponseBody());
                    rlist.remove(rlist.size()-1);

                }

                if (requestToServer.isEmpty()) continue;
                //туть отправляем на сервер
                long start = System.nanoTime();
                serverWriter.writeObject(requestToServer);
                //туть получаем ответ от сервера
                serverResponse = (Response) serverReader.readObject();
                long finish= System.nanoTime();
                long time=(finish-start)/ 1000000000;
                if (time>=1){
                    rlist.add(serverResponse);

                }
                else{System.out.println(serverResponse.getResponseBody());}
                console.setList(rlist);
            } catch (InvalidClassException | NotSerializableException exception) {
                System.err.println("Произошла ошибка при отправке данных на сервер!");
            } catch (ClassNotFoundException exception) {
                System.err.println("Произошла ошибка при чтении полученных данных!");
            } catch (IOException exception) {
                System.err.println("Соединение с сервером разорвано!");
                //try {
                    reconnectionAttempts++;
                    connectToServer();
                //} catch (ConnectionErrorException | NotInDeclaredLimitsException reconnectionException) {
                    //if (requestToServer.getCommandName().equals("exit"))
                       // System.out.println("Команда не будет зарегистрирована на сервере.");
                    //else System.out.println("Попробуйте повторить команду позднее.");
                //}
            }

        } while (!(requestToServer.getCommandName().equals("exit") && requestToServer.getArgument().isEmpty()));
        return false;
    }*/
}




