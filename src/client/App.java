package client;

import client.forms.*;

import javax.swing.*;

public class App {
    public static final JFrame mainFrame = new JFrame("Flat");
    public static StartMenu startMenu;
    public static Login login;
    public static MainMenu mainMenu;
    public static client.forms.Register register;
    public static Insert insert;
    public static Update update;
    public static ReplaceIfGreater replaceg;

    public static void main(String[] args) {
        Client client = new Client("localhost", 8088);
        login = new Login(client);
        register = new Register(client);
        insert=new Insert(client);
        update=new Update(client);
        replaceg=new ReplaceIfGreater(client);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1200, 800);
        startMenu = new StartMenu(client);
        mainMenu=new MainMenu(client);
        mainFrame.setContentPane(startMenu.getStartMenuPanel());

        mainFrame.setVisible(true);


    }
}
