package client.utility;

import client.Client;
import common.Request;
import common.Response;
import common.ResponseCode;
import common.User;
import common.data.Flat;
import exceptions.EmptyArgumentException;
import exceptions.IncorrectInputInScriptException;
import exceptions.IncorrectValueException;
import exceptions.ScriptRecursionException;
import resources.LocaleBundle;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Класс, который управляет вводом команд
 */
public class Console {

    private Scanner scanner;
    Creator creator;
    public ArrayList<Response> rlist=new ArrayList<>();
    private Stack<File> scriptFileNames = new Stack<File>();
    private Stack<Scanner> scannerStack = new Stack<>();
    private AuthManager authManager;
    private File file;
    private JTextPane textPane;
    private Client client;
    public Console(Scanner scanner, File file, JTextPane textPane, Client client){
        this.scanner=scanner;
        this.file=file;
        this.textPane=textPane;
        this.client=client;
        scriptFileNames.push(file);
        textPane.setText(textPane.getText() +"Выполняю скрипт '" + file.getName() + "'...");


    }
    public Console(Scanner scanner, Creator creator,AuthManager authManager){
        this.scanner=scanner;
        this.creator=creator;
        this.authManager=authManager;


    }

    /**
     *Метод, который отвечает за ввод пользовательских команд
     */
    public void setList(ArrayList list){
        this.rlist=list;
    }

    public void start(){
        Request requestToServer = null;
        Response serverResponse = null;
        do {
            try{
                Request request=(serverResponse != null ? workMode(serverResponse,client.getUser()) :
                        workMode(null, client.getUser()));

                if (request == null) {
                    textPane.setText(textPane.getText() + LocaleBundle.getCurrentBundle().getString("scriptOptionPaneError1"));
                }else{
                    client.send(request);
                    Response response=client.receive();
                    textPane.setText(textPane.getText() +response.getResponseBody());
                }
            } catch (IOException ioException) {
                //JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("ioPaneError"));
            } catch (ClassNotFoundException exception) {
                //
            }

        }while(!(scannerStack.isEmpty()&& !scanner.hasNext()));

    }


    public Request workMode(Response serverResponse, User user){
        ResponseCode serverResponseCode=null;
        String serverResponseBody=null;
        if (serverResponse!=null){
            serverResponseBody=serverResponse.getResponseBody();}
        if (serverResponse!=null){
            serverResponseCode=serverResponse.getResponseCode();}
        String userInput="";
        String[] userCommand = {"", ""};
        TypeOfCommand typeOfCommand;
        try {
            do {
                try {
                    while (!scannerStack.isEmpty() && !scanner.hasNextLine()) {
                        scanner.close();
                        scanner = scannerStack.pop();
                        textPane.setText(textPane.getText()+"Возвращаюсь из скрипта '" + scriptFileNames.pop().getName() + "'!");
                    }


                    if (serverResponseCode == ResponseCode.SERVER_EXIT || serverResponseCode == ResponseCode.ERROR) {
                        throw new IncorrectInputInScriptException();
                    }
                    if (scanner.hasNext()) {

                        userInput = scanner.nextLine();

                        textPane.setText(textPane.getText() +"\n");
                        textPane.setText(textPane.getText() + userInput + "\n");
                        textPane.setText(textPane.getText() +"\n");


                        userCommand = (userInput.trim() + " ").split(" ", 2);
                        userCommand[0] = userCommand[0].toLowerCase();
                        userCommand[1] = userCommand[1].trim();
                    }


                } catch (NoSuchElementException | IllegalStateException exception) {
                        textPane.setText(textPane.getText() + "Произошла ошибка при вводе команды!\n");
                        userCommand = new String[]{"", ""};
                }
                typeOfCommand = checkCommand(userCommand[0], userCommand[1]);


            } while (typeOfCommand == TypeOfCommand.ERROR && scannerStack.isEmpty() || userCommand[0].isEmpty());
            try {
                switch (typeOfCommand) {
                    case OBJECT:
                        creator.setScanner(scanner);
                        Flat flat = creator.create(Integer.parseInt(userCommand[1]),user);
                        return new Request(userCommand[0], userCommand[1],flat,user);
                    case SCRIPT:
                        File scriptFile = new File(userCommand[1]);
                        //System.out.println(scriptFileNames);
                        if (!scriptFile.exists()) throw new FileNotFoundException();
                        if (!scriptFileNames.isEmpty() && scriptFileNames.search(scriptFile) != -1) {
                            throw new ScriptRecursionException();
                        }
                        scannerStack.push(scanner);
                        scriptFileNames.push(scriptFile);
                        scanner = new Scanner(scriptFile);
                        System.out.println("Выполняю скрипт '" + scriptFile.getName() + "'...");
                        break;
                }
            } catch (NumberFormatException e){

            }
            catch (FileNotFoundException exception) {
                textPane.setText(textPane.getText() +"Файл со скриптом не найден!");
            } catch (ScriptRecursionException e) {
                textPane.setText(textPane.getText() +"Скрипты не могут вызываться рекурсивно!");
                throw new IncorrectInputInScriptException();
            }
            }catch(IncorrectInputInScriptException e){
            textPane.setText(textPane.getText() + "Выполнение скрипта прервано!\n");
            while (!scannerStack.isEmpty()) {
                scanner.close();
                scanner = scannerStack.pop();
            }
        }
        return new Request(userCommand[0], userCommand[1],user);




    }
    private TypeOfCommand checkCommand(String command, String argument) {
        try {
            switch (command) {
                case "":
                    return TypeOfCommand.ERROR;
                case "help":
                case "show":
                case "info":
                case "clear":
                case "exit":

                    if (!argument.isEmpty()) throw new IncorrectValueException();
                    return TypeOfCommand.OK;

                case "replace_if_lower":
                case "insert":
                case "replace_if_greater":
                case "update":
                    if (argument.isEmpty()) throw new EmptyArgumentException();
                    return TypeOfCommand.OBJECT;
                case "remove_key":
                case "remove_lower_key":
                case "remove_all_by_number_of_rooms":
                case "count_greater_than_furnish":
                case "filter_starts_with_name":
                    if (argument.isEmpty()) throw new EmptyArgumentException();
                    return TypeOfCommand.OK;
                case "execute_script":
                    if (argument.isEmpty()) throw new EmptyArgumentException();
                    return TypeOfCommand.SCRIPT;
                default:
                    System.out.println("Команда '" + command + "' не найдена. Наберите 'help' для справки.");
                    return TypeOfCommand.ERROR;
            }
        } catch (IncorrectValueException e) {
            //if (!scannerStack.isEmpty()) System.err.println("У данной команды нет аргумента!");

        }
        catch (EmptyArgumentException e) {
            //if (!scannerStack.isEmpty()) System.err.println("У данной команды должен быть аргумент");

        }
        return TypeOfCommand.OK;
    }
}












