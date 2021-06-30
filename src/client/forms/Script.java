package client.forms;

import client.App;
import client.Client;
import client.utility.Console;
import common.Request;
import common.Response;
import net.miginfocom.swing.MigLayout;
import resources.LocaleBundle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Script extends JPanel {
    private Client client;
    private JPanel scriptPanel;
    private JLabel name;
    private JButton backButton;
    private JButton chooseFileButton;
    private JScrollPane scrollPane1;
    private JTextPane textPane;
    public Script(Client client){
        initComponents();
        this.client = client;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.mainFrame.setContentPane(App.mainMenu.getMainMenuPanel());
                App.mainFrame.validate();
            }
        });

        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnVal = fileChooser.showOpenDialog(scriptPanel);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getAbsolutePath();
                    try{
                        File file=new File(path);
                        Console console=new Console(new Scanner(file),file,textPane,client);

                        console.start();
                        /*Request request=console.workMode(null, client.getUser());
                        if (request == null) {
                            textPane.setText(textPane.getText() + LocaleBundle.getCurrentBundle().getString("scriptOptionPaneError1"));
                        }else{
                            client.send(request);
                            Response response=client.receive();
                            textPane.setText(textPane.getText() + response.getResponseBody());


                        }*/



                    } catch (FileNotFoundException fileNotFoundException) {
                        JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("scriptOptionPaneError2"));
                    } catch (IOException ioException) {
                        JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("ioPaneError"));
                    }
                }
            }
        });

    }
    public void localize() {
        backButton.setText(LocaleBundle.getCurrentBundle().getString("back_button"));
        chooseFileButton.setText(LocaleBundle.getCurrentBundle().getString("choose_button"));


    }
    private void initComponents(){
        scriptPanel = new JPanel();
        name = new JLabel();
        backButton = new JButton();
        chooseFileButton = new JButton();
        scrollPane1 = new JScrollPane();
        textPane = new JTextPane();

        scriptPanel.setBackground(new Color(148, 204, 227));
        scriptPanel.setLayout(new MigLayout(
                "insets 0,hidemode 3,align center center",
                // columns
                "[grow,fill]" +
                        "[110,grow,fill]" +
                        "[110,grow,fill]" +
                        "[110,grow,fill]" +
                        "[110,grow,fill]" +
                        "[110,grow,fill]" +
                        "[110,grow,fill]" +
                        "[grow,fill]",
                // rows
                "[80,grow,fill]" +
                        "[35,grow,fill]" +
                        "[25,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]" +
                        "[25,grow,fill]" +
                        "[25,grow,fill]" +
                        "[25,grow,fill]"));
        //---- name ----
        name.setText("Execute script");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setForeground(new Color(40, 61, 82));
        name.setFont(new Font("Arial",Font.PLAIN, 50));
        scriptPanel.add(name, "cell 2 0 4 1,align center center,grow 0 0");

        //---- backButton ----
        backButton.setText("\u041d\u0430\u0437\u0430\u0434");
        backButton.setBackground(Color.white);
        backButton.setForeground(new Color(161, 35, 106));
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        scriptPanel.add(backButton, "cell 6 8,align center center,grow 0 0,width 80:80:110,height 30:30:50");

        //---- chooseFileButton ----
        chooseFileButton.setText("\u0412\u044b\u0431\u0440\u0430\u0442\u044c \u0444\u0430\u0439\u043b");
        chooseFileButton.setFont(new Font("Arial", Font.PLAIN, 25));
        chooseFileButton.setBackground(new Color(196, 116, 161));
        chooseFileButton.setForeground(new Color(40, 61, 82));
        chooseFileButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        scriptPanel.add(chooseFileButton, "cell 3 1 2 1,aligny center,grow 100 0,height 30:35:55");

        //======== scrollPane1 ========
        {

            //---- textPane ----
            textPane.setBackground(Color.white);
            textPane.setFont(new Font("Arial", Font.BOLD, 16));
            scrollPane1.setViewportView(textPane);
        }
        scriptPanel.add(scrollPane1, "cell 2 3 4 6");
    }


    public JPanel getScriptPanel(){
        return scriptPanel;
    }
}
