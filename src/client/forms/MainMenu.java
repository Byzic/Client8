package client.forms;

import client.App;
import client.Client;
import common.Request;
import common.Response;
import common.ResponseCode;
import common.User;
import common.data.Furnish;
import exceptions.IncorrectValueException;
import net.miginfocom.swing.MigLayout;
import resources.LocaleBundle;

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
    private JLabel user;
    private JLabel name;
    private JButton exitButton;
    private JButton helpButton;
    private JButton infoButton;
    private JButton insertButton;
    private JButton remove_keyButton;
    private JButton updateButton;
    private JButton clearButton;
    private JButton replaceIfGreaterButton;
    private JButton replaceIfLowerButton;
    private JButton lowerKeyButton;
    private JButton numberOfRoomsButton;
    private JButton countGreater;
    private JButton showButton;
    private JButton visualizeButton;
    private JButton executeScriptButton;
    public void setUser(User user) {
        this.client.setUser(user);
        this.user.setText("User: "+user.getLogin());
    }


    public MainMenu(Client client) {
        JLabel lable=new JLabel();
        lable.setFont(new Font("Arial", Font.PLAIN, 20));
        initComponents();
        this.client = client;
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    client.send(new Request("exit", "", client.getUser()));
                    Response response = client.receive();
                    if (response.getResponseCode().equals(ResponseCode.OK)) {
                        App.mainFrame.setContentPane(App.startMenu.getStartMenuPanel());
                        App.mainFrame.validate();
                    }
                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("ioPaneError"));
                } catch (ClassNotFoundException classNotFoundException) {
                    JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("classNotFoundError"));
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
        remove_keyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder errors=new StringBuilder();

                try{
                    Integer key;
                    lable.setText(LocaleBundle.getCurrentBundle().getString("removeKey?"));
                    String str=JOptionPane.showInputDialog(lable);
                    if (str.isEmpty()) throw new NullPointerException();
                    key=Integer.parseInt(str);
                    if (key <= 0) throw new IncorrectValueException();
                    client.send(new Request("remove_key",key.toString(),client.getUser()));
                    Response response=client.receive();
                    lable.setText(response.localize());
                    JOptionPane.showMessageDialog(null, lable);
                } catch (NumberFormatException exception) {
                    errors.append(LocaleBundle.getCurrentBundle().getString("Exception1")+"\n");
                    lable.setText(errors.toString());
                    JOptionPane.showMessageDialog(null, lable);
                } catch (IncorrectValueException notDeclaredValueException) {
                    errors.append(LocaleBundle.getCurrentBundle().getString("Exception2")+"\n");
                    lable.setText(errors.toString());
                    JOptionPane.showMessageDialog(null, lable);
                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("ioPaneError"));
                } catch (ClassNotFoundException classNotFoundException) {
                    JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("classNotFoundError"));
                }catch (NullPointerException ex){

                }

            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.mainFrame.setContentPane(App.update.getUpdatePanel());
                App.mainFrame.validate();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    client.send(new Request("clear", "", client.getUser()));
                    Response response = client.receive();
                    lable.setText(response.localize());
                    JOptionPane.showMessageDialog(null, lable);

                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("ioPaneError"));
                } catch (ClassNotFoundException classNotFoundException) {
                    JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("classNotFoundError"));
                }
            }
        });
        replaceIfGreaterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.mainFrame.setContentPane(App.replaceg.getReplaceGPanel());
                App.mainFrame.validate();
            }
        });
        replaceIfLowerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.mainFrame.setContentPane(App.replacel.getReplaceGPanel());
                App.mainFrame.validate();
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.show.drawTable();
                App.mainFrame.setContentPane(App.show.getShowPanel());
                App.mainFrame.validate();

            }
        });
        executeScriptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.mainFrame.setContentPane(App.script.getScriptPanel());
                App.mainFrame.validate();

            }
        });
        visualizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                App.visualize.startThread();
                App.mainFrame.setContentPane(App.visualize.getVisualizePanel());
                App.mainFrame.validate();
            }
        });
        lowerKeyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder errors=new StringBuilder();
                try{
                    Integer key;
                    lable.setText(LocaleBundle.getCurrentBundle().getString("lowerKey?"));
                    String str=JOptionPane.showInputDialog(lable);
                    if (str.isEmpty()) throw new NullPointerException();
                    key=Integer.parseInt(str);
                    if (key <= 0) throw new IncorrectValueException();
                    client.send(new Request("remove_lower_key",key.toString(),client.getUser()));
                    Response response=client.receive();
                    lable.setText(response.localize());
                    JOptionPane.showMessageDialog(null, lable);
                } catch (NumberFormatException exception) {
                    errors.append(LocaleBundle.getCurrentBundle().getString("Exception1")+"\n");
                    lable.setText(errors.toString());
                    JOptionPane.showMessageDialog(null, lable);
                } catch (IncorrectValueException notDeclaredValueException) {
                    errors.append(LocaleBundle.getCurrentBundle().getString("Exception2")+"\n");
                    lable.setText(errors.toString());
                    JOptionPane.showMessageDialog(null, lable);
                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("ioPaneError"));
                } catch (ClassNotFoundException classNotFoundException) {
                    JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("classNotFoundError"));
                }catch (NullPointerException ex){

                }

            }
        });
        countGreater.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder errors=new StringBuilder();
                try{
                    Furnish furn;
                    lable.setText(LocaleBundle.getCurrentBundle().getString("furnish?"));
                    String str=JOptionPane.showInputDialog(lable);
                    if (str.isEmpty()) throw new NullPointerException();
                    furn=Furnish.valueOf(str.toUpperCase());
                    client.send(new Request("count_greater_than_furnish",furn.toString(),client.getUser()));
                    Response response=client.receive();
                    lable.setText(response.localize());
                    JOptionPane.showMessageDialog(null, lable);
                } catch (IllegalArgumentException ex){

                    errors.append(LocaleBundle.getCurrentBundle().getString("Exception17")+"\n");
                    lable.setText(errors.toString());
                    JOptionPane.showMessageDialog(null, lable);
                }catch (NullPointerException exception) {

                    errors.append(LocaleBundle.getCurrentBundle().getString("Exception17")+"\n");
                    lable.setText(errors.toString());
                    JOptionPane.showMessageDialog(null, lable);
                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("ioPaneError"));
                } catch (ClassNotFoundException classNotFoundException) {
                    JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("classNotFoundError"));
                }

            }
        });
        numberOfRoomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder errors=new StringBuilder();
                try{
                    Integer numberOfRooms;
                    lable.setText(LocaleBundle.getCurrentBundle().getString("numberOfRoomsKey?"));
                    String str=JOptionPane.showInputDialog(lable);
                    if (str.isEmpty()) throw new NullPointerException();
                    numberOfRooms=Integer.parseInt(str);
                    if (numberOfRooms <= 0 || numberOfRooms >11 ) throw new IncorrectValueException();
                    client.send(new Request("remove_all_by_number_of_rooms",numberOfRooms.toString(),client.getUser()));
                    Response response=client.receive();
                    JOptionPane.showMessageDialog(null, response.localize());
                } catch (NumberFormatException exception) {
                    errors.append(LocaleBundle.getCurrentBundle().getString("Exception1")+"\n");
                    lable.setText(errors.toString());
                    JOptionPane.showMessageDialog(null, lable);
                } catch (IncorrectValueException notDeclaredValueException) {
                    errors.append(LocaleBundle.getCurrentBundle().getString("Exception13")+"\n");
                    lable.setText(errors.toString());
                    JOptionPane.showMessageDialog(null, lable);
                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("ioPaneError"));
                } catch (ClassNotFoundException classNotFoundException) {
                    JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("classNotFoundError"));
                }catch (NullPointerException ex){

                }
            }
        });
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    client.send(new Request("info", "", client.getUser()));
                    Response response = client.receive();
                    JOptionPane.showMessageDialog(null, response.localize());

                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("ioPaneError"));
                } catch (ClassNotFoundException classNotFoundException) {
                    JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("classNotFoundError"));
                }
            }
        });
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    client.send(new Request("help", "", client.getUser()));
                    Response response = client.receive();
                    JOptionPane.showMessageDialog(null, response.localize());
                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("ioPaneError"));
                } catch (ClassNotFoundException classNotFoundException) {
                    JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("classNotFoundError"));
                }

            }
        });

    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        mainMenuPanel = new JPanel();
        user= new JLabel();
        name = new JLabel();
        exitButton=new JButton();
        helpButton=new JButton();
        infoButton=new JButton();
        insertButton=new JButton();
        visualizeButton=new JButton();
        remove_keyButton=new JButton();
        updateButton=new JButton();
        clearButton=new JButton();
        lowerKeyButton=new JButton();
        replaceIfGreaterButton=new JButton();
        replaceIfLowerButton=new JButton();
        numberOfRoomsButton=new JButton();
        countGreater=new JButton();
        showButton=new JButton();
        executeScriptButton=new JButton();
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
        //------user---------
        user.setText("test");
        user.setForeground(Color.white);
        user.setHorizontalAlignment(SwingConstants.CENTER);
        user.setFont(new Font("Arial", Font.BOLD, 20));
        mainMenuPanel.add(user, "cell 1 0");
        //---- name ----
        name.setText("Flat");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("Arial",Font.BOLD, 50));
        name.setBackground(new Color(255, 102, 102));
        name.setForeground(Color.WHITE);
        mainMenuPanel.add(name, "cell 2 0 4 1,align center center,grow 0 0");
        //-----executeScriptButton-----
        executeScriptButton.setText("execute_script");
        executeScriptButton.setForeground(new Color(40, 61, 82));
        executeScriptButton.setFont(new Font("Arial", Font.PLAIN, 20));
        executeScriptButton.setBackground(new Color(196, 116, 161));
        executeScriptButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        mainMenuPanel.add(executeScriptButton, "cell 2 2");

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
        //-----updateButton-----
        updateButton.setText("update_id");
        updateButton.setForeground(new Color(40, 61, 82));
        updateButton.setFont(new Font("Arial", Font.PLAIN, 20));
        updateButton.setBackground(new Color(196, 116, 161));
        updateButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        mainMenuPanel.add(updateButton, "cell 4 2");
        //-----showButton-----
        showButton.setText("show");
        showButton.setForeground(new Color(40, 61, 82));
        showButton.setFont(new Font("Arial", Font.PLAIN, 20));
        showButton.setBackground(new Color(196, 116, 161));
        showButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        mainMenuPanel.add(showButton, "cell 3 4");
        //-----visualizeButton-----
        visualizeButton.setText("visualize");
        visualizeButton.setForeground(new Color(40, 61, 82));
        visualizeButton.setFont(new Font("Arial", Font.PLAIN, 20));
        visualizeButton.setBackground(new Color(196, 116, 161));
        visualizeButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        mainMenuPanel.add(visualizeButton, "cell 4 4");
        //-----countGreater-----
        countGreater.setText("count_greater_than_furnish");
        countGreater.setForeground(new Color(40, 61, 82));
        countGreater.setFont(new Font("Arial", Font.PLAIN, 20));
        countGreater.setBackground(new Color(196, 116, 161));
        countGreater.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        mainMenuPanel.add(countGreater, "cell 2 4");
        //-----remove_keyButton----
        remove_keyButton.setText("remove_key");
        remove_keyButton.setForeground(new Color(40, 61, 82));
        remove_keyButton.setFont(new Font("Arial", Font.PLAIN, 20));
        remove_keyButton.setBackground(new Color(196, 116, 161));
        remove_keyButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        mainMenuPanel.add(remove_keyButton, "cell 2 6");
        //-----clearButton-----
        clearButton.setText("clear");
        clearButton.setForeground(new Color(40, 61, 82));
        clearButton.setFont(new Font("Arial", Font.PLAIN, 20));
        clearButton.setBackground(new Color(196, 116, 161));
        clearButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        //mainMenuPanel.add(clearButton, "cell 5 6");
        //-----replaceIfGreaterButton-----
        replaceIfGreaterButton.setText("replace_if_greater");
        replaceIfGreaterButton.setForeground(new Color(40, 61, 82));
        replaceIfGreaterButton.setFont(new Font("Arial", Font.PLAIN, 20));
        replaceIfGreaterButton.setBackground(new Color(196, 116, 161));
        replaceIfGreaterButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        mainMenuPanel.add(replaceIfGreaterButton, "cell 4 6");
        //-----replaceIfLowerButton-----
        replaceIfLowerButton.setText("replace_if_lower");
        replaceIfLowerButton.setForeground(new Color(40, 61, 82));
        replaceIfLowerButton.setFont(new Font("Arial", Font.PLAIN, 20));
        replaceIfLowerButton.setBackground(new Color(196, 116, 161));
        replaceIfLowerButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        mainMenuPanel.add(replaceIfLowerButton, "cell 3 6");
        //-----lowerKeyButton-----
        lowerKeyButton.setText("remove_lower_key");
        lowerKeyButton.setForeground(new Color(40, 61, 82));
        lowerKeyButton.setFont(new Font("Arial", Font.PLAIN, 20));
        lowerKeyButton.setBackground(new Color(196, 116, 161));
        lowerKeyButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        mainMenuPanel.add(lowerKeyButton, "cell 3 8");
        //-----numberOfRoomsButton-----
        numberOfRoomsButton.setText("remove_all_by_number_of_rooms");
        numberOfRoomsButton.setForeground(new Color(40, 61, 82));
        numberOfRoomsButton.setFont(new Font("Arial", Font.PLAIN, 20));
        numberOfRoomsButton.setBackground(new Color(196, 116, 161));
        numberOfRoomsButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        mainMenuPanel.add(numberOfRoomsButton, "cell 2 8");
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
