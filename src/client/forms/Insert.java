package client.forms;

import client.App;
import client.Client;
import net.miginfocom.swing.MigLayout;
import resources.LocaleBundle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Insert extends JPanel {
    private Client client;
    private JPanel insertPanel;
    private JLabel name;
    private JButton backButton;
    public Insert(Client client){
        initComponents();
        this.client=client;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.mainFrame.setContentPane(App.mainMenu.getMainMenuPanel());
                App.mainFrame.validate();
            }
        });
    }

    public void initComponents(){
        insertPanel=new JPanel();
        name = new JLabel();
        backButton = new JButton();


        insertPanel.setBackground(new Color(148, 201, 242));
        insertPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(
                new javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion"
                ,javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
                ,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,12)
                ,java.awt.Color.red),insertPanel. getBorder()));insertPanel. addPropertyChangeListener(
                new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
                ){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException()
                        ;}});
        insertPanel.setLayout(new MigLayout(
                "insets 0,hidemode 3,align center center",
                // columns
                "[fill]" +
                        "[110,grow,fill]" +
                        "[110,grow,fill]" +
                        "[110,grow,fill]" +
                        "[110,grow,fill]" +
                        "[110,grow,fill]" +
                        "[110,grow,fill]" +
                        "[fill]",
                // rows
                "[80,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]"));


        //---- name ----
        name.setText("Insert Flat");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("Arial",Font.BOLD, 70));
        name.setBackground(new Color(255, 102, 102));
        name.setForeground(Color.WHITE);
        insertPanel.add(name, "cell 2 0 4 1,align center center,grow 0 0");

        //---- backButton ----
        backButton.setText("\u041d\u0430\u0437\u0430\u0434");
        backButton.setBackground(Color.white);
        backButton.setForeground(new Color(66,161,235));
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.setBorder(new RoundedBorder(10,new Color(66,161,235)));
        insertPanel.add(backButton, "cell 6 8,align center center,grow 0 0,width 80:80:110,height 30:30:50");
    }

    public void localize(){
        backButton.setText(LocaleBundle.getCurrentBundle().getString("back_button"));
    }


    public JPanel getInsertPanel(){
        return insertPanel;
    }


}
