package client.forms;

import client.App;
import client.Client;
import common.Request;
import common.Response;
import common.ResponseCode;
import common.User;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class MainMenu extends JPanel {
    private JPanel mainMenuPanel;
    private Client client;
    private User user;
    private JLabel name;
    private JButton exitButton;
    private JButton helpButton;
    private JButton infoButton;
    private JButton insertButton;


    public void setUser(User user){
        this.user=user;
    }
    public MainMenu(Client client) {
        initComponents();
        this.client = client;
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    client.send(new Request("exit", "", user));
                    System.out.println("hghgh");
                    Response response = client.receive();
                    System.out.println(response.getResponseCode());
                    if (response.getResponseCode().equals(ResponseCode.OK)) {
                        App.mainFrame.setContentPane(App.startMenu.getStartMenuPanel());
                        App.mainFrame.validate();
                    }
                } catch (IOException ex) {

                } catch (ClassNotFoundException ex) {

                }

            }
        });
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.mainFrame.setContentPane(App.insert.getInsertPanel());
                App.mainFrame.validate();
            }
        });
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    client.send(new Request("info", "", user));
                    Response response = client.receive();
                    JOptionPane.showMessageDialog(null, response.getResponseBody());

                }catch (IOException ex) {

                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    client.send(new Request("help", "", user));
                    Response response = client.receive();
                    JOptionPane.showMessageDialog(null, response.getResponseBody());
                } catch (IOException ex) {

                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

            }
        });

    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        mainMenuPanel = new JPanel();
        name = new JLabel();
        exitButton=new JButton();
        helpButton=new JButton();
        infoButton=new JButton();
        insertButton=new JButton();
        mainMenuPanel.setBackground(new Color(148, 204, 227));
        mainMenuPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
                EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER,javax.swing
                .border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),
                java.awt.Color.red),mainMenuPanel. getBorder()));mainMenuPanel. addPropertyChangeListener(new java.beans.PropertyChangeListener()
        {@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.getPropertyName()))
            throw new RuntimeException();}});
        mainMenuPanel.setLayout(new MigLayout(
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
                        "[25,fill]" +
                        "[35,fill]" +
                        "[25,fill]" +
                        "[35,fill]" +
                        "[25,fill]" +
                        "[35,fill]" +
                        "[25,fill]" +
                        "[35,fill]" +
                        "[35,grow,fill]"));
        //---- name ----
        name.setText("Flat");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("Arial",Font.BOLD, 50));
        name.setBackground(new Color(255, 102, 102));
        name.setForeground(Color.WHITE);
        mainMenuPanel.add(name, "cell 2 0 4 1,align center center,grow 0 0");
        //---- exitButton ----
        exitButton.setText("Exit");
        exitButton.setBackground(Color.WHITE);
        exitButton.setForeground(new Color(66,161,235));
        exitButton.setFont(new Font("Arial", Font.PLAIN, 20));
        exitButton.setBorder(new RoundedBorder(10,new Color(66,161,235)));
        mainMenuPanel.add(exitButton, "cell 6 8,align center center,grow 0 0,width 80:80:110,height 30:30:50");

        //-----insertButton-----
        insertButton.setText("insert");
        insertButton.setForeground(new Color(40, 61, 82));
        insertButton.setFont(new Font("Arial", Font.PLAIN, 20));
        insertButton.setBackground(new Color(196, 116, 161));
        insertButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        mainMenuPanel.add(insertButton, "cell 3 2");
        //-----infoButton-----
        infoButton.setText("info");
        infoButton.setForeground(new Color(40, 61, 82));
        infoButton.setFont(new Font("Arial", Font.PLAIN, 20));
        infoButton.setBackground(new Color(196, 116, 161));
        infoButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        mainMenuPanel.add(infoButton, "cell 4 8");
        //---- helpButton ----
        helpButton.setText("help");
        helpButton.setForeground(new Color(40, 61, 82));
        helpButton.setFont(new Font("Arial", Font.PLAIN, 20));
        helpButton.setBackground(new Color(196, 116, 161));
        helpButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        mainMenuPanel.add(helpButton, "cell 5 8");

    }
    public JPanel getMainMenuPanel(){
        return mainMenuPanel;
    }
}
