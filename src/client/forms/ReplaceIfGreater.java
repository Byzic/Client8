package client.forms;

import client.App;
import client.Client;
import common.Request;
import common.Response;
import common.data.*;
import exceptions.IncorrectValueException;
import net.miginfocom.swing.MigLayout;
import resources.LocaleBundle;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;

public class ReplaceIfGreater extends JPanel {
    private Client client;
    private JPanel insertPanel;
    private JLabel name;
    private JButton backButton;
    private JLabel flatName;
    private JTextField nameField;
    private JLabel xyLable;
    private JTextField xField;
    private JTextField yField;
    private JLabel areaLable;
    private JTextField areaField;
    private JLabel numberLable;
    private JTextField numberField;
    private JLabel furnishLable;
    private JComboBox furnishBox;
    private JLabel viewLable;
    private JComboBox viewBox;
    private JLabel transportLable;
    private JComboBox transportBox;
    private JLabel nameHouse;
    private JTextField houseField;
    private JLabel yearHouse;
    private JTextField yearField;
    private JLabel floorHouse;
    private JTextField floorField;
    private JLabel keyLable;
    private JTextField keyField;
    private JButton insertButton;
    public ReplaceIfGreater(Client client){
        initComponents();
        this.client=client;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.mainFrame.setContentPane(App.mainMenu.getMainMenuPanel());
                App.mainFrame.validate();
            }
        });
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder errors = new StringBuilder();
                int key = 0;
                try {
                    key = Integer.parseInt(keyField.getText());
                    if (key <= 0) throw new IncorrectValueException();
                } catch (NumberFormatException exception) {
                    errors.append(LocaleBundle.getCurrentBundle().getString("Exception1")+"\n");
                } catch (IncorrectValueException notDeclaredValueException) {
                    errors.append(LocaleBundle.getCurrentBundle().getString("Exception2")+"\n");
                }
                String name = null;
                try {
                    name = nameField.getText();
                    if (name.isEmpty()) throw new IncorrectValueException();
                } catch (IncorrectValueException Exception) {
                    errors.append(LocaleBundle.getCurrentBundle().getString("Exception3")+"\n");
                }
                Float x = null;
                Float y=null;
                try{
                    x=Float.valueOf(xField.getText());
                    y=Float.valueOf(yField.getText());
                    if (x<=-107)throw new IncorrectValueException();


                }catch (NumberFormatException exception) {
                    errors.append(LocaleBundle.getCurrentBundle().getString("Exception10")+"\n");
                } catch (IncorrectValueException Exception) {
                    errors.append(LocaleBundle.getCurrentBundle().getString("Exception11")+"\n");
                }


                Float area = null;
                try{
                    area=Float.parseFloat(areaField.getText());
                    if (area>741 | area <0) throw new IncorrectValueException();
                }catch (NumberFormatException exception) {
                    errors.append(LocaleBundle.getCurrentBundle().getString("Exception4")+"\n");
                } catch (IncorrectValueException Exception) {
                    errors.append(LocaleBundle.getCurrentBundle().getString("Exception5")+"\n");
                }
                Integer numberRooms=null;
                try{
                    numberRooms=Integer.valueOf(numberField.getText());
                    if (numberRooms>11 | numberRooms <0) throw new IncorrectValueException();
                }catch (NumberFormatException exception) {
                    errors.append(LocaleBundle.getCurrentBundle().getString("Exception12")+"\n");
                } catch (IncorrectValueException Exception) {
                    errors.append(LocaleBundle.getCurrentBundle().getString("Exception13")+"\n");
                }



                String nameHous=null;
                House house=null;
                Long year;
                Long numberOfFloors = null;
                try{
                    if (houseField.getText().isEmpty() & yearField.getText().isEmpty() & floorField.getText().isEmpty()) throw new NullPointerException();
                    nameHous=houseField.getText();
                    year=Long.parseLong(yearField.getText());
                    try{
                        if (year>846 | year <0) throw new IncorrectValueException();
                    }catch (IncorrectValueException Exception) {
                        errors.append(LocaleBundle.getCurrentBundle().getString("Exception8")+"\n");
                    }
                    numberOfFloors=Long.parseLong(floorField.getText());
                    try{
                        if (numberOfFloors <0) throw new IncorrectValueException();
                    }catch (IncorrectValueException Exception) {
                        errors.append(LocaleBundle.getCurrentBundle().getString("Exception9")+"\n");
                    }
                    if (nameHous.isEmpty()) throw new IncorrectValueException();
                    house=new House(nameHous,year,numberOfFloors);


                }catch (NumberFormatException exception) {
                    errors.append(LocaleBundle.getCurrentBundle().getString("Exception6")+"\n");
                }catch (IncorrectValueException Exception) {
                    errors.append(LocaleBundle.getCurrentBundle().getString("Exception7")+"\n");
                }
                catch (NullPointerException ex){
                    house=null;

                }

                if (errors.toString().equals("")) {
                    try {

                        client.send(new Request("replace_if_greater",
                                String.valueOf(key),
                                new Flat(11,
                                        name, new Coordinates(x, y),
                                        LocalDateTime.now(),
                                        area,
                                        numberRooms,
                                        Furnish.valueOf( (furnishBox.getItemAt(furnishBox.getSelectedIndex())).toString()),
                                        View.valueOf( (viewBox.getItemAt(viewBox.getSelectedIndex())).toString()),
                                        Transport.valueOf( (transportBox.getItemAt(transportBox.getSelectedIndex())).toString()),
                                        house,
                                        client.getUser()
                                ), client.getUser())
                        );
                        Response response = client.receive();
                        JOptionPane.showMessageDialog(null, response.localize());
                        App.mainFrame.setContentPane(App.mainMenu.getMainMenuPanel());
                        App.mainFrame.validate();
                    } catch (IOException exception) {
                        JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("ioPaneError"));
                    } catch (ClassNotFoundException classNotFoundException) {
                        JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("classNotFoundError"));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, errors.toString());
                }

            }

        });
    }

    public void initComponents(){
        insertPanel=new JPanel();
        name = new JLabel();
        backButton = new JButton();
        flatName=new JLabel();
        nameField=new JTextField();
        xyLable=new JLabel();
        xField=new JTextField();
        yField=new JTextField();
        areaLable=new JLabel();
        areaField=new JTextField();
        numberLable=new JLabel();
        numberField=new JTextField();
        furnishLable=new JLabel();
        furnishBox=new JComboBox();
        viewLable=new JLabel();
        viewBox=new JComboBox();
        transportLable=new JLabel();
        transportBox=new JComboBox();
        nameHouse=new JLabel();
        houseField=new JTextField();
        yearHouse=new JLabel();
        yearField=new JTextField();
        floorHouse=new JLabel();
        floorField=new JTextField();
        keyLable=new JLabel();
        keyField=new JTextField();
        insertButton=new JButton();



        insertPanel.setBackground(new Color(148, 204, 227));
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
                        "[80,grow,fill]"+
                        "[140,grow,fill]" +
                        "[140,grow,fill]" +
                        "[110,grow,fill]" +
                        "[140,grow,fill]" +
                        "[140,grow,fill]" +
                        "[111,grow,fill]" +
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
        name.setText("Replace if greater");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("Arial",Font.PLAIN, 40));
        name.setBackground(new Color(255, 102, 102));
        name.setForeground(new Color(194, 103, 160));
        insertPanel.add(name, "cell 4 0 ,align center center,grow 0 0");

        //-----flatName-------
        flatName.setText("Владелец квартиры");
        flatName.setHorizontalAlignment(SwingConstants.CENTER);
        flatName.setForeground(new Color(40, 61, 82));
        flatName.setFont(new Font("Arial", Font.BOLD, 20));
        insertPanel.add(flatName, "cell 2 1");

        //-----nameField------
        nameField.setHorizontalAlignment(SwingConstants.CENTER);
        nameField.setFont(new Font("Arial", Font.BOLD, 20));
        nameField.setBackground(Color.white);
        nameField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        nameField.setBorder(new EtchedBorder());
        insertPanel.add(nameField, "cell 3 1,align center,grow 100 0,width 80:130:220,height 25:30:50");

        //-----xyLable----
        xyLable.setText("Местоположение");
        xyLable.setHorizontalAlignment(SwingConstants.CENTER);
        xyLable.setForeground(new Color(40, 61, 82));
        xyLable.setFont(new Font("Arial", Font.BOLD, 20));
        insertPanel.add(xyLable, "cell 2 2");

        //-----xyField-----
        xField.setHorizontalAlignment(SwingConstants.CENTER);
        xField.setBackground(Color.white);
        xField.setFont(new Font("Arial", Font.BOLD, 20));
        xField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        xField.setBorder(new EtchedBorder());
        insertPanel.add(xField, "cell 3 2,aligny center,grow 100 0,width 40:75:110,height 25:30:50");

        yField.setHorizontalAlignment(SwingConstants.CENTER);
        yField.setBackground(Color.white);
        yField.setFont(new Font("Arial", Font.BOLD, 20));
        yField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        yField.setBorder(new EtchedBorder());
        insertPanel.add(yField, "cell 3 2,aligny center,grow 100 0,width 40:75:110,height 25:30:50");

        //----areaLable-----
        areaLable.setText("Площадь");
        areaLable.setHorizontalAlignment(SwingConstants.CENTER);
        areaLable.setForeground(new Color(40, 61, 82));
        areaLable.setFont(new Font("Arial", Font.BOLD, 20));
        insertPanel.add(areaLable, "cell 2 3");

        //----areaField-------
        areaField.setHorizontalAlignment(SwingConstants.CENTER);
        areaField.setFont(new Font("Arial", Font.BOLD, 20));
        areaField.setBackground(Color.white);
        areaField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        areaField.setBorder(new EtchedBorder());
        insertPanel.add(areaField, "cell 3 3,aligny center,grow 100 0,width 80:130:220,height 25:30:50");

        //-----numberLable-----
        numberLable.setText("Количество комнат");
        numberLable.setHorizontalAlignment(SwingConstants.CENTER);
        numberLable.setForeground(new Color(40, 61, 82));
        numberLable.setFont(new Font("Arial", Font.BOLD, 20));
        insertPanel.add(numberLable, "cell 2 4");

        //-----numberField-----
        numberField.setHorizontalAlignment(SwingConstants.CENTER);
        numberField.setBackground(Color.white);
        numberField.setFont(new Font("Arial", Font.BOLD, 20));
        numberField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        numberField.setBorder(new EtchedBorder());
        insertPanel.add(numberField, "cell 3 4,aligny center,grow 100 0,width 80:130:220,height 25:30:50");

        //----furnishLable----
        furnishLable.setText("Отделка");
        furnishLable.setHorizontalAlignment(SwingConstants.CENTER);
        furnishLable.setForeground(new Color(40, 61, 82));
        furnishLable.setFont(new Font("Arial", Font.BOLD, 20));
        insertPanel.add(furnishLable, "cell 2 5");

        //----furnishBox-----

        furnishBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "NONE",
                "FINE",
                "BAD"
        }));
        furnishBox.setBackground(new Color(207, 176, 193));
        furnishBox.setForeground(new Color(40, 61, 82));
        furnishBox.setFont(new Font("Arial", Font.PLAIN, 18));
        furnishBox.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        furnishBox.setSelectedIndex(1);
        insertPanel.add(furnishBox, "cell 3 5,aligny center,grow 100 0,width 80:130:220,height 25:30:50");

        //----keyLable-----
        keyLable.setText("Ключ");
        keyLable.setHorizontalAlignment(SwingConstants.CENTER);
        keyLable.setForeground(new Color(40, 61, 82));
        keyLable.setFont(new Font("Arial", Font.BOLD, 20));
        insertPanel.add(keyLable, "cell 2 7");

        //----keyField-------
        keyField.setHorizontalAlignment(SwingConstants.CENTER);
        keyField.setBackground(Color.white);
        keyField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        keyField.setBorder(new EtchedBorder());
        keyField.setFont(new Font("Arial", Font.BOLD, 20));
        insertPanel.add(keyField, "cell 3 7,aligny center,grow 100 0,width 80:130:220,height 25:30:50");

        //----viewLable----
        viewLable.setText("Вид из окна");
        viewLable.setHorizontalAlignment(SwingConstants.CENTER);
        viewLable.setForeground(new Color(40, 61, 82));
        viewLable.setFont(new Font("Arial", Font.BOLD, 20));
        insertPanel.add(viewLable, "cell 5 1");

        //----viewBox-----

        viewBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "YARD",
                "BAD",
                "GOOD",
                "TERRIBLE"
        }));
        viewBox.setBackground(new Color(207, 176, 193));
        viewBox.setForeground(new Color(40, 61, 82));
        viewBox.setFont(new Font("Arial", Font.PLAIN, 18));
        viewBox.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        viewBox.setSelectedIndex(1);
        insertPanel.add(viewBox, "cell 6 1,align center,grow 100 0,width 80:130:220,height 25:30:50");

        //----transportLable----
        transportLable.setText("Количество транспорта");
        transportLable.setHorizontalAlignment(SwingConstants.CENTER);
        transportLable.setForeground(new Color(40, 61, 82));
        transportLable.setFont(new Font("Arial", Font.BOLD, 20));
        insertPanel.add(transportLable, "cell 5 2");

        //----transportBox-----

        transportBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "LITTLE",
                "NORMAL",
                "ENOUGH"
        }));
        transportBox.setBackground(new Color(207, 176, 193));
        transportBox.setForeground(new Color(40, 61, 82));
        transportBox.setFont(new Font("Arial", Font.PLAIN, 18));
        transportBox.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        transportBox.setSelectedIndex(1);
        insertPanel.add(transportBox, "cell 6 2,align center,grow 100 0,width 80:130:220,height 25:30:50");

        //-----nameHouse----
        nameHouse.setText("Название комплекса");
        nameHouse.setHorizontalAlignment(SwingConstants.CENTER);
        nameHouse.setForeground(new Color(40, 61, 82));
        nameHouse.setFont(new Font("Arial", Font.BOLD, 20));
        insertPanel.add(nameHouse, "cell 5 3");

        //-----houseField-----
        houseField.setHorizontalAlignment(SwingConstants.CENTER);
        houseField.setBackground(Color.white);
        houseField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        houseField.setFont(new Font("Arial", Font.BOLD, 20));
        houseField.setBorder(new EtchedBorder());
        insertPanel.add(houseField, "cell 6 3,aligny center,grow 100 0,width 80:130:220,height 25:30:50");

        //-----yearHouse----
        yearHouse.setText("Сколько лет назад был сдан");
        yearHouse.setHorizontalAlignment(SwingConstants.CENTER);
        yearHouse.setForeground(new Color(40, 61, 82));
        yearHouse.setFont(new Font("Arial", Font.BOLD, 20));
        insertPanel.add(yearHouse, "cell 5 4");

        //-----yearField-----
        yearField.setHorizontalAlignment(SwingConstants.CENTER);
        yearField.setBackground(Color.white);
        yearField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        yearField.setFont(new Font("Arial", Font.BOLD, 20));
        yearField.setBorder(new EtchedBorder());
        insertPanel.add(yearField, "cell 6 4,aligny center,grow 100 0,width 80:130:220,height 25:30:50");

        //-----floorHouse----
        floorHouse.setText("Количество этажей в доме");
        floorHouse.setHorizontalAlignment(SwingConstants.CENTER);
        floorHouse.setForeground(new Color(40, 61, 82));
        floorHouse.setFont(new Font("Arial", Font.BOLD, 20));
        insertPanel.add(floorHouse, "cell 5 5");

        //-----floorField-----
        floorField.setHorizontalAlignment(SwingConstants.CENTER);
        floorField.setBackground(Color.white);
        floorField.setFont(new Font("Arial", Font.BOLD, 20));
        floorField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        floorField.setBorder(new EtchedBorder());
        insertPanel.add(floorField, "cell 6 5,aligny center,grow 100 0,width 80:130:220,height 25:30:50");



        //----insertButton----
        insertButton.setText("Изменить");
        insertButton.setFont(new Font("Arial", Font.PLAIN, 25));
        insertButton.setBackground(new Color(196, 116, 161));
        insertButton.setForeground(new Color(40, 61, 82));
        insertButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        insertPanel.add(insertButton, "cell 5 7,align center center,grow 0 0,width 100:150:250,height 30:35:45");


        //---- backButton ----
        backButton.setText("\u041d\u0430\u0437\u0430\u0434");
        backButton.setBackground(Color.white);
        backButton.setForeground(new Color(161, 35, 106));
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        insertPanel.add(backButton, "cell 6 7,align center center,grow 0 0,width 80:130:220,height 30:30:50");
    }



    public void localize(){
        backButton.setText(LocaleBundle.getCurrentBundle().getString("back_button"));
        flatName.setText(LocaleBundle.getCurrentBundle().getString("flatName"));
        xyLable.setText(LocaleBundle.getCurrentBundle().getString("xyLable"));
        areaLable.setText(LocaleBundle.getCurrentBundle().getString("areaLable"));
        numberLable.setText(LocaleBundle.getCurrentBundle().getString("numberLable"));
        furnishLable.setText(LocaleBundle.getCurrentBundle().getString("furnishLable"));
        viewLable.setText(LocaleBundle.getCurrentBundle().getString("viewLable"));
        transportLable.setText(LocaleBundle.getCurrentBundle().getString("transportLable"));
        nameHouse.setText(LocaleBundle.getCurrentBundle().getString("nameHouse"));
        yearHouse.setText(LocaleBundle.getCurrentBundle().getString("yearHouse"));
        floorHouse.setText(LocaleBundle.getCurrentBundle().getString("floorHouse"));
        insertButton.setText(LocaleBundle.getCurrentBundle().getString("updateButton"));
        keyLable.setText(LocaleBundle.getCurrentBundle().getString("keyLable"));
    }


    public JPanel getReplaceGPanel(){
        return insertPanel;
    }


}
