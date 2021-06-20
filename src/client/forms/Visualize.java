package client.forms;

import client.App;
import client.Client;
import net.miginfocom.swing.MigLayout;
import resources.LocaleBundle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Visualize extends JPanel {
    private JPanel visualizePanel;
    private Thread draw;
    private Client client;
    private JButton backButton;
    private boolean isActive;
    private JLabel name;
    public Visualize(Client client) {
        this.client = client;
        initComponents();
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isActive = false;
                App.mainFrame.setContentPane(App.mainMenu.getMainMenuPanel());
                App.mainFrame.validate();
            }
        });
    }

    private void initComponents(){
        visualizePanel=new JPanel();
        backButton=new JButton();
        name=new JLabel();
        visualizePanel.setBackground(new Color(148, 204, 227));
        visualizePanel.setLayout(new MigLayout(
                "insets 0,hidemode 3",
                // columns
                "[70,grow,fill]" +
                        "[70,grow,fill]" +
                        "[grow,fill]" +
                        "[70,grow,fill]" +
                        "[70,grow,fill]",
                // rows
                "[80,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]" +
                        "[50,grow,fill]"));
        //---- name ----
        name.setText("Flat");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("Arial",Font.PLAIN, 50));
        name.setBackground(new Color(255, 102, 102));
        name.setForeground(new Color(194, 103, 160));
        visualizePanel.add(name, "cell 2 0,align center center,grow 0 0");

        backButton.setText("\u041d\u0430\u0437\u0430\u0434");
        backButton.setBackground(Color.white);
        backButton.setForeground(new Color(161, 35, 106));
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        visualizePanel.add(backButton, "cell 6 7,align center center,grow 0 0,width 80:130:220,height 30:30:50");
    }
    public void startThread() {
        isActive = true;
        

    }

    public void localize() {
        backButton.setText(LocaleBundle.getCurrentBundle().getString("back_button"));
    }
    public JPanel getVisualizePanel() {
        return visualizePanel;
    }
}
