package client.forms;

import client.App;
import client.Client;
import net.miginfocom.swing.MigLayout;
import resources.LocaleBundle;


import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class StartMenu extends JPanel {
    private JPanel startMenuPanel;
    private JLabel name;
    private JButton loginButton;
    private JButton registerButton;
    private JButton exitButton;
    private JComboBox<String> chooseLang;
    private Client client;
    public StartMenu(Client client) {
        initComponents();
        this.client = client;
        chooseLang.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                LocaleBundle.setBundle(String.valueOf(e.getItem()));
                localize();
                App.login.localize();
                App.insert.localize();
                App.register.localize();
                App.update.localize();
                App.replaceg.localize();
                App.replacel.localize();
                App.script.localize();
                App.show.localize();


            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.mainFrame.setContentPane(App.login.getLoginPanel());
                App.mainFrame.validate();
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.mainFrame.setContentPane(App.register.getRegisterPanel());
                App.mainFrame.validate();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
    public void localize() {
        loginButton.setText(LocaleBundle.getCurrentBundle().getString("login_button"));
        registerButton.setText(LocaleBundle.getCurrentBundle().getString("registration"));
        exitButton.setText(LocaleBundle.getCurrentBundle().getString("startMenu_closeButton"));

    }
    private void initComponents() {
        startMenuPanel = new JPanel();
        name = new JLabel();

        loginButton = new JButton();
        registerButton = new JButton();
        exitButton = new JButton();
        chooseLang = new JComboBox<>();

        //======== startMenuPanel ========
        startMenuPanel.setBackground(new Color(148, 204, 227));
        //startMenuPanel.setBackground(new Color(188, 143, 143));
        /*startMenuPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
                javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e",javax
                .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
                .awt.Font("Dialo\u0067",java.awt.Font.BOLD,12),java.awt
                .Color.red),startMenuPanel. getBorder()));startMenuPanel. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("borde\u0072".
                equals(e.getPropertyName()))throw new RuntimeException();}});
        */startMenuPanel.setLayout(new MigLayout(
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
                "[214,grow,fill]" +
                        "[]" +
                        "[48]" +
                        "[]" +
                        "[]" +
                        "[214,grow,fill]" +
                        "[]" +
                        "[]"));
        //---- name ----
        name.setText("Flat");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("Arial",Font.BOLD, 70));
        name.setBackground(new Color(194, 103, 160));
        name.setForeground(new Color(194, 103, 160));
        startMenuPanel.add(name, "cell 4 0,align center center,grow 0 0");
        //---- loginButton ----
        loginButton.setText("\u0412\u043e\u0439\u0442\u0438");

        loginButton.setFont(new Font("Arial", Font.PLAIN, 25));
        loginButton.setBackground(new Color(196, 116, 161));
        loginButton.setForeground(new Color(40, 61, 82));
        loginButton.setBorder(new RoundedBorder(15,new Color(161, 35, 106)));
        startMenuPanel.add(loginButton, "cell 4 1,align center center,grow 0 0,width 100:150:250,height 30:35:45");

        //---- registerButton ----
        registerButton.setText("\u0420\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u044f");
        registerButton.setFont(new Font("Arial", Font.PLAIN, 25));
        registerButton.setBackground(new Color(196, 116, 161));
        registerButton.setForeground(new Color(40, 61, 82));
        registerButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        startMenuPanel.add(registerButton, "cell 4 2,align center center,grow 0 0,width 100:150:250,height 30:35:45");

        //---- exitButton ----
        exitButton.setText("\u0417\u0430\u043a\u0440\u044b\u0442\u044c");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 25));
        exitButton.setBackground(new Color(196, 116, 161));
        exitButton.setForeground(new Color(40, 61, 82));
        exitButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        startMenuPanel.add(exitButton, "cell 4 3,align center center,grow 0 0,width 100:150:250,height 30:35:45");

        chooseLang.setModel(new DefaultComboBoxModel<>(new String[] {
                "Русский",
                "Македонски",
                "Polski",
                "Español"
        }));
        chooseLang.setBackground(new Color(207, 176, 193));
        chooseLang.setForeground(new Color(40, 61, 82));
        chooseLang.setFont(new Font("Arial", Font.PLAIN, 18));
        chooseLang.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        startMenuPanel.add(chooseLang, "cell 4 4,align center center,grow 0 0,width 100:150:250,height 30:35:45");

    }
    public JPanel getStartMenuPanel() {
        return startMenuPanel;
    }
}
