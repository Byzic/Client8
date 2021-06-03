package client.forms;

import client.Client;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class Register extends JPanel {
    private JPanel registerPanel;
    private JLabel name;
    private JLabel loginName;
    private JTextField loginField;
    private JLabel passwordName;
    private JPasswordField passwordField;
    private JLabel confirmPassword;
    private JPasswordField passwordField2;
    private JButton registerButton;
    private JButton backButton;
    private Client client;
}
    public Register(Client client) {
        initComponents();
        this.client = client;
    }
    private void initComponents(){
        registerPanel = new JPanel();
        name = new JLabel();
        loginName = new JLabel();
        loginField = new JTextField();
        passwordName = new JLabel();
        passwordField = new JPasswordField();
        confirmPassword = new JLabel();
        passwordField2 = new JPasswordField();
        registerButton = new JButton();
        backButton = new JButton();

        //======== registerPanel ========
        registerPanel.setBackground(new Color(225, 183, 144));
        registerPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
                swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border
                . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog"
                ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,registerPanel. getBorder
                ( )) ); registerPanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
                                                                                                                                                            .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException
                ( ); }} );
        registerPanel.setLayout(new MigLayout(
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
                        "[25,fill]" +
                        "[35,fill]" +
                        "[40]" +
                        "[40]" +
                        "[50,grow,fill]"));

        //---- name ----
        name.setText("\u0420\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u044f");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("Arial Black", Font.BOLD, 40));
        name.setBackground(new Color(255, 102, 102));
        name.setForeground(new Color(40, 61, 82));
        registerPanel.add(name, "cell 4 0,align center center,grow 0 0");

        //---- loginName ----
        loginName.setText("\u041b\u043e\u0433\u0438\u043d");
        loginName.setHorizontalAlignment(SwingConstants.CENTER);
        loginName.setForeground(Color.black);
        loginName.setFont(new Font("Arial", Font.BOLD, 16));
        registerPanel.add(loginName, "cell 4 1");

        //---- loginField ----
        loginField.setBackground(Color.white);
        registerPanel.add(loginField, "cell 4 2,alignx center,growx 0,width 100:200:250");

        //---- passwordName ----
        passwordName.setText("\u041f\u0430\u0440\u043e\u043b\u044c");
        passwordName.setHorizontalAlignment(SwingConstants.CENTER);
        passwordName.setForeground(Color.black);
        passwordName.setFont(new Font("Arial", Font.BOLD, 16));
        registerPanel.add(passwordName, "cell 4 3");

        //---- passwordField ----
        passwordField.setBackground(Color.white);
        registerPanel.add(passwordField, "cell 4 4,alignx center,growx 0,width 100:200:250");

        //---- confirmPassword ----
        confirmPassword.setText("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u0438\u0435 \u043f\u0430\u0440\u043e\u043b\u044f");
        confirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
        confirmPassword.setForeground(Color.black);
        confirmPassword.setFont(new Font("Arial", Font.BOLD, 16));
        registerPanel.add(confirmPassword, "cell 4 5");

        //---- passwordField2 ----
        passwordField2.setBackground(Color.white);
        registerPanel.add(passwordField2, "cell 4 6,alignx center,growx 0,width 100:200:250");

        //---- registerButton ----
        registerButton.setText("\u0420\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u044f");
        registerButton.setFont(new Font("Arial", Font.PLAIN, 12));
        registerButton.setBorder(new EtchedBorder());
        registerButton.setBackground(new Color(40, 61, 82));
        registerButton.setForeground(Color.white);
        registerPanel.add(registerButton, "cell 4 7,align center center,grow 0 0,width 100:150:250,height 30:35:45");

        //---- backButton ----
        backButton.setText("\u041d\u0430\u0437\u0430\u0434");
        backButton.setFont(new Font("Arial", Font.PLAIN, 12));
        backButton.setBorder(new EtchedBorder());
        backButton.setBackground(new Color(40, 61, 82));
        backButton.setForeground(Color.white);
        registerPanel.add(backButton, "cell 4 8,align center center,grow 0 0,width 100:150:250,height 30:35:45");
    }
    public JPanel getRegisterPanel() {
        return registerPanel;
    }
}

