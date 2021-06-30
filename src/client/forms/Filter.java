package client.forms;

import client.App;
import client.Client;
import common.data.Furnish;
import common.data.Transport;
import common.data.View;
import net.miginfocom.swing.MigLayout;
import resources.LocaleBundle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Filter extends JPanel {
    private Client client;
    private JPanel filterPanel;
    private JLabel name;
    private JButton backButton;
    private JLabel label1;
    private JComboBox chooseField;
    private JLabel label2;
    private JTextField argumentField;
    private JLabel label3;
    private JComboBox chooseTypeFilter;
    private JButton filterButton;
    public Filter(Client client) {
        initComponents();
        this.client = client;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //isFilter = false;
                App.mainFrame.setContentPane(App.show.getShowPanel());
                App.mainFrame.validate();
            }

        });
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (argumentField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("filterOptionPaneError2"));
                return;
                }
                if (chooseField.getItemAt(chooseField.getSelectedIndex()).equals("furnish")){
                    try{
                    Furnish.valueOf(argumentField.getText().toUpperCase());
                    }catch (IllegalArgumentException exception){
                        JOptionPane.showMessageDialog(null, "Необходимо ввести значение корректное для Furnish:NONE,FINE,BAD");
                        return;
                    }
                }
                if (chooseField.getItemAt(chooseField.getSelectedIndex()).equals("view")){
                    try{
                        View.valueOf(argumentField.getText().toUpperCase());
                    }catch (IllegalArgumentException exception){
                    JOptionPane.showMessageDialog(null, "Необходимо ввести значение корректное для View:YARD,BAD,GOOD,TERRIBLE");
                    return;
                }
                }
                if (chooseField.getItemAt(chooseField.getSelectedIndex()).equals("transport")){
                    try{
                        Transport.valueOf(argumentField.getText().toUpperCase());
                    }catch (IllegalArgumentException exception){
                        JOptionPane.showMessageDialog(null, "Необходимо ввести значение корректное для Transport:LITTLE,NORMAL,ENOUGH");
                        return;
                    }
                }




                App.show.setFilter(true);
                App.show.drawTable();
                App.mainFrame.setContentPane(App.show.getShowPanel());
                App.mainFrame.validate();
            }
        });
    }

    private void initComponents(){
        filterPanel=new JPanel();
        name = new JLabel();
        backButton =new JButton();
        label1=new JLabel();
        chooseField = new JComboBox<>();
        label2=new JLabel();
        argumentField = new JTextField();
        chooseTypeFilter = new JComboBox<>();
        filterButton = new JButton();
        label3=new JLabel();


        filterPanel.setBackground(new Color(148, 204, 227));
        filterPanel.setLayout(new MigLayout(
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
                        "[25,grow,fill]" +
                        "[35,grow,fill]" +
                        "[25,grow,fill]" +
                        "[35,grow,fill]" +
                        "[25,grow,fill]" +
                        "[35,grow,fill]" +
                        "[25,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]" +
                        "[25,grow,fill]"));

        //-----name ----
        name.setText("Filter Flat");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("Arial Black", Font.BOLD, 40));
        name.setBackground(new Color(194, 103, 160));
        name.setForeground(new Color(194, 103, 160));
        filterPanel.add(name, "cell 2 0 4 1,align center center,grow 0 0");
        //-----backButton-----
        backButton.setText("\u041d\u0430\u0437\u0430\u0434");
        backButton.setBackground(Color.white);
        backButton.setForeground(new Color(161, 35, 106));
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        filterPanel.add(backButton, "cell 6 8,align center center,grow 0 0,width 80:130:220,height 30:30:50");
        //---- label1 ----
        label1.setText("\u041f\u043e\u043b\u0435 \u0444\u0438\u043b\u044c\u0442\u0440\u0430:");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setForeground(new Color(40, 61, 82));
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        filterPanel.add(label1, "cell 2 1 4 1");
        //---- chooseField ----
        chooseField.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));;
        chooseField.setBackground(new Color(207, 176, 193));
        chooseField.setForeground(new Color(40, 61, 82));
        chooseField.setFont(new Font("Arial", Font.PLAIN, 18));
        chooseField.setModel(new DefaultComboBoxModel<>(new String[] {
                "id",
                "key",
                "name",
                "x",
                "y",
                "area",
                "number_of_rooms",
                "furnish",
                "view",
                "transport",
                "houseName",
                "year",
                "number_of_floors",
                "user"


        }));
        filterPanel.add(chooseField, "cell 3 2 2 1,aligny center,grow 100 0,height 30:30:40");

        //---- label2 ----
        label2.setText("\u0410\u0440\u0433\u0443\u043c\u0435\u043d\u0442:");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setForeground(new Color(40, 61, 82));
        label2.setFont(new Font("Arial", Font.BOLD, 20));
        filterPanel.add(label2, "cell 2 3 4 1");

        //---- argumentField ----
        argumentField.setBackground(Color.white);
        argumentField.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        filterPanel.add(argumentField, "cell 3 4 2 1,aligny center,grow 100 0,height 30:30:40");
        //-----label3-----
        label3.setText("\u0422\u0438\u043f \u0444\u0438\u043b\u044c\u0442\u0440\u0430:");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setForeground(new Color(40, 61, 82));
        label3.setFont(new Font("Arial", Font.BOLD, 20));
        filterPanel.add(label3, "cell 3 5 2 1");
        //-----chooseTypeFilter-----
        chooseTypeFilter.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));;
        chooseTypeFilter.setBackground(new Color(207, 176, 193));
        chooseTypeFilter.setForeground(new Color(40, 61, 82));
        chooseTypeFilter.setFont(new Font("Arial", Font.PLAIN, 18));
        chooseTypeFilter.setModel(new DefaultComboBoxModel<>(new String[] {
                "=",
                ">",
                "<"
        }));
        filterPanel.add(chooseTypeFilter, "cell 3 6 2 1,aligny center,grow 100 0,height 30:30:40");
        //---- filterButton ----
        filterButton.setText("\u0424\u0438\u043b\u044c\u0442\u0440\u043e\u0432\u0430\u0442\u044c");
        filterButton.setForeground(new Color(40, 61, 82));
        filterButton.setFont(new Font("Arial", Font.PLAIN, 20));
        filterButton.setBackground(new Color(196, 116, 161));
        filterButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        filterPanel.add(filterButton, "cell 3 8 2 1,aligny center,grow 100 0,height 30:30:50");
    }
    public void localize(){
        backButton.setText(LocaleBundle.getCurrentBundle().getString("back_button"));
        filterButton.setText(LocaleBundle.getCurrentBundle().getString("filterbutton"));
        label1.setText(LocaleBundle.getCurrentBundle().getString("filter_label1"));
        label2.setText(LocaleBundle.getCurrentBundle().getString("filter_label2"));
        label3.setText(LocaleBundle.getCurrentBundle().getString("filter_label3"));


    }
    public JComboBox<String> getChooseField() {
        return chooseField;
    }

    public JTextField getArgumentField() {
        return argumentField;
    }

    public JComboBox<String> getChooseTypeFilter() {
        return chooseTypeFilter;
    }

    public JPanel getFilterPanel(){
        return filterPanel;
    }
}
