package client.forms;

import client.App;
import client.Client;
import common.Request;
import common.Response;
import common.ResponseCode;
import common.User;
import net.miginfocom.swing.MigLayout;
import resources.LocaleBundle;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Login extends JPanel {
    private Client client;
    private JPanel loginPanel;
    private JLabel name;
    private JLabel loginName;
    private JTextField loginField;
    private JLabel passwordName;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton backButton;
    public Login(Client client) {
        initComponents();
        this.client = client;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.mainFrame.setContentPane(App.startMenu.getStartMenuPanel());
                App.mainFrame.validate();
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    User user = new User(loginField.getText(), String.valueOf(passwordField.getPassword()), null);
                    client.send(new Request("login","",user));
                    Response response=client.receive();
                    if (response.getResponseCode().equals(ResponseCode.OK)) {
                        client.setUser(user);
                        App.mainFrame.setContentPane(App.mainMenu.getMainMenuPanel());
                        App.mainFrame.validate();
                        App.mainMenu.setUser(user);



                    }else {
                        //JOptionPane.showMessageDialog(null, response.localize());
                    }

                } catch (IOException ex) {
                    //вывести на экран, что возникла ошибка при отправке запроса на сервер
                } catch (ClassNotFoundException ex) {
                    //вывести на экран, что возникла ошибка при получении ответа от сервера
                }

            }
        });

    }
    public void localize() {
        backButton.setText(LocaleBundle.getCurrentBundle().getString("back_button"));
        loginButton.setText(LocaleBundle.getCurrentBundle().getString("login_button"));
        passwordName.setText(LocaleBundle.getCurrentBundle().getString("login_passwordName"));
        loginName.setText(LocaleBundle.getCurrentBundle().getString("login_loginName"));
        name.setText(LocaleBundle.getCurrentBundle().getString("login_name"));
    }
    private void initComponents(){
        loginPanel = new JPanel();
        name = new JLabel();                                      //Вход в бд
        loginName = new JLabel();                                 //логин
        loginField = new JTextField();                            //поле ввода логина
        passwordName = new JLabel();                              //пароль
        passwordField = new JPasswordField();                     //поле ввода пароля
        loginButton = new JButton();                              //кнопка войти
        backButton = new JButton();                               //кнопка назад
        //======== loginPanel ========
        loginPanel.setBackground(new Color(225, 183, 144));
        loginPanel.setLayout(new MigLayout(
                "insets 0,hidemode 3",
                // columns
                "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[grow,fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]",
                // rows
                "[80,grow,fill]" +
                        "[25,fill]" +
                        "[35,fill]" +
                        "[25,fill]" +
                        "[35,fill]" +
                        "[40]" +
                        "[40]" +
                        "[110,grow,fill]"));

        //---- name ----
        name.setText("Вход");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("Arial Black", Font.BOLD, 40));
        name.setBackground(new Color(255, 102, 102));
        name.setForeground(new Color(40, 61, 82));
        loginPanel.add(name, "cell 4 0,align center center,grow 0 0");

        //---- loginName ----
        loginName.setText("Логин:");
        loginName.setHorizontalAlignment(SwingConstants.CENTER);
        loginName.setForeground(Color.black);
        loginName.setFont(new Font("Arial", Font.BOLD, 16));
        loginPanel.add(loginName, "cell 4 1");

        //---- loginField ----
        loginField.setBackground(Color.white);
        loginPanel.add(loginField, "cell 4 2,alignx center,growx 0,width 100:200:250");

        //---- passwordName ----
        passwordName.setText("Пароль:");
        passwordName.setHorizontalAlignment(SwingConstants.CENTER);
        passwordName.setForeground(Color.black);
        passwordName.setFont(new Font("Arial", Font.BOLD, 16));
        loginPanel.add(passwordName, "cell 4 3");

        //---- passwordField ----
        passwordField.setBackground(Color.white);
        loginPanel.add(passwordField, "cell 4 4,alignx center,growx 0,width 100:200:250");

        //---- loginButton ----
        loginButton.setText("Войти");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 20));
        loginButton.setBorder(new EtchedBorder());
        loginButton.setBackground(new Color(40, 61, 82));
        loginButton.setForeground(Color.white);
        loginPanel.add(loginButton, "cell 4 5,align center center,grow 0 0,width 100:150:250,height 30:35:45");

        //---- backButton ----
        backButton.setText("Назад");
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.setBorder(new EtchedBorder());
        backButton.setBackground(new Color(40, 61, 82));
        backButton.setForeground(Color.white);
        loginPanel.add(backButton, "cell 4 6,align center center,grow 0 0,width 100:150:250,height 30:35:45");

    }
    public JPanel getLoginPanel() {
        return loginPanel;
    }
}
