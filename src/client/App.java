package client;

import client.forms.StartMenu;
import com.ibm.dtfj.corereaders.Register;

import javax.swing.*;

public class App {
    public static final JFrame mainFrame = new JFrame("Flat");
    public static StartMenu startMenu;
    public static Login login;
    public static Register register;
    public static void main(String[] args) {
        Client client = new Client("localhost", 20002);
        login = new Login(client);
        register = new Register(client);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 400);
        startMenu = new StartMenu(client);
        mainFrame.setContentPane(startMenu.getStartMenuPanel());
        mainFrame.setVisible(true);


    }
}
