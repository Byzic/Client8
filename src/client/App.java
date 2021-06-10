package client;

import client.forms.Login;
import client.forms.MainMenu;
import client.forms.Register;
import client.forms.StartMenu;

import javax.swing.*;

public class App {
    public static final JFrame mainFrame = new JFrame("Flat");
    public static StartMenu startMenu;
    public static Login login;
    public static MainMenu mainMenu;
    public static client.forms.Register register;
    public static void main(String[] args) {System.out.println("jjjj");
        Client client = new Client("localhost", 20002);
        login = new Login(client);
        register = new Register(client);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1000, 700);
        startMenu = new StartMenu(client);
        mainMenu=new MainMenu(client);
        mainFrame.setContentPane(startMenu.getStartMenuPanel());

        mainFrame.setVisible(true);


    }
}
