package client.forms;

import client.Client;
import common.User;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class MainMenu extends JPanel {
    private JPanel mainMenuPanel;
    private Client client;
    private User user;
    private JLabel name;
    private JButton signOutButton;

    public void setUser(User user){
        this.user=user;
    }
    public MainMenu(Client client) {
        initComponents();
        this.client = client;
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        mainMenuPanel = new JPanel();
        name = new JLabel();
        signOutButton=new JButton();
        mainMenuPanel.setBackground(new Color(225, 183, 144));
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
        name.setFont(new Font("Arial Black", Font.BOLD, 40));
        name.setBackground(new Color(255, 102, 102));
        name.setForeground(new Color(40, 61, 82));
        mainMenuPanel.add(name, "cell 2 0 4 1,align center center,grow 0 0");
        //---- signOutButton ----
        signOutButton.setText("\u0412\u044b\u0439\u0442\u0438");
        signOutButton.setBackground(Color.white);
        signOutButton.setForeground(new Color(40, 61, 82));
        signOutButton.setFont(new Font("Arial", Font.BOLD, 12));
        signOutButton.setBorder(new EtchedBorder());
        mainMenuPanel.add(signOutButton, "cell 6 0,align center center,grow 0 0,width 80:80:110,height 30:30:50");


    }
    public JPanel getMainMenuPanel(){
        return mainMenuPanel;
    }
}
