package client.forms;

import client.App;
import client.Client;
import common.Request;
import common.Response;
import common.data.Flat;
import common.data.Furnish;
import common.data.Transport;
import common.data.View;
import net.miginfocom.swing.MigLayout;
import resources.LocaleBundle;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

public class Show extends JPanel {
    private JScrollPane scrollPane;
    private JTable table;
    private boolean isFilter;
    private Client client;
    private JPanel showPanel;
    private JButton updateButton;
    private JButton backButton;
    private JButton filterButton;
    private  JButton resetButton;
    private Hashtable<Integer, Flat> collection;
    public Show(Client client) {
        initComponents();
        this.client = client;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isFilter = false;
                App.mainFrame.setContentPane(App.mainMenu.getMainMenuPanel());
                App.mainFrame.validate();
            }

        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isFilter = false;
                drawTable();
            }
        });
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.mainFrame.setContentPane(App.filter.getFilterPanel());
                App.mainFrame.validate();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawTable();
            }
        });
        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                //if (e.getType() == TableModelEvent.UPDATE) updateCell(e);
            }
        });


    }
    private void initComponents(){
        showPanel=new JPanel();
        backButton=new JButton();
        updateButton=new JButton();
        resetButton=new JButton();
        filterButton=new JButton();
        scrollPane = new JScrollPane();
        table = new JTable();
        showPanel.setBackground(new Color(148, 204, 227));
        showPanel.setLayout(new MigLayout(
                "insets 0,hidemode 3",
                // columns
                "[70,grow,fill]" +
                        "[70,grow,fill]" +
                        "[grow,fill]" +
                        "[grow,fill]" +
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
                        "[50,grow,fill]" +
                        "[grow]"));
        backButton.setText("\u041d\u0430\u0437\u0430\u0434");
        backButton.setBackground(Color.white);
        backButton.setForeground(new Color(161, 35, 106));
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        showPanel.add(backButton, "cell 6 1,align center center,grow 0 0,width 80:130:220,height 30:30:50");
        //-----updateButton-----
        updateButton.setText("\u041e\u0431\u043d\u043e\u0432\u0438\u0442\u044c");
        updateButton.setForeground(new Color(40, 61, 82));
        updateButton.setFont(new Font("Arial", Font.PLAIN, 20));
        updateButton.setBackground(new Color(196, 116, 161));
        updateButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        showPanel.add(updateButton, "cell 4 1,align center center,grow 0 0,width 80:130:220,height 30:30:50");
        //---- resetButton ----
        resetButton.setText("\u0421\u0431\u0440\u043e\u0441");
        resetButton.setForeground(new Color(40, 61, 82));
        resetButton.setFont(new Font("Arial", Font.PLAIN, 20));
        resetButton.setBackground(new Color(196, 116, 161));
        resetButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        showPanel.add(resetButton, "cell 3 1,aligny center,grow 100 0");
        //-----filterButton-----
        filterButton.setText("\u0424\u0438\u043b\u044c\u0442\u0440");
        filterButton.setForeground(new Color(40, 61, 82));
        filterButton.setFont(new Font("Arial", Font.PLAIN, 20));
        filterButton.setBackground(new Color(196, 116, 161));
        filterButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        showPanel.add(filterButton, "cell 2 1,aligny center,grow 100 0");
        //======== scrollPane ========
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "id", "key", "name", "x", "y","date", "area", "number_of_rooms", "furnish", "view", "transport", "houseName", "yaer", "number_of_floors", "user"
                }
        ) {
            Class<?>[] columnTypes = new Class<?>[]{
                    Integer.class, Integer.class, String.class, Float.class, Float.class, Date.class, Float.class,
                    Integer.class, String.class, String.class, String.class, String.class, Long.class, Long.class, String.class
            };
            boolean[] columnEditable = new boolean[]{
                    false, false, true, true, true, false, true, true, true, true, true, true, true, true, false
            };

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnEditable[columnIndex];
            }
        });
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        scrollPane.setViewportView(table);
        showPanel.add(scrollPane, "cell 0 3 7 8");
    }
    public void localize(){
        backButton.setText(LocaleBundle.getCurrentBundle().getString("back_button"));
        updateButton.setText(LocaleBundle.getCurrentBundle().getString("update_button"));
        filterButton.setText(LocaleBundle.getCurrentBundle().getString("filter_button"));
        resetButton.setText(LocaleBundle.getCurrentBundle().getString("reset_button"));
    }

    public void setFilter(boolean filter) {
        isFilter = filter;
    }

    public void drawTable(){
        try {
            this.client.send(new Request("show", "", this.client.getUser()));

            Response response=client.receive();
            collection=response.getCollection();
            DefaultTableModel model = (DefaultTableModel) this.table.getModel();
            RowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
            table.setRowSorter(sorter);
            while (model.getRowCount() > 0) model.removeRow(0);
            for (Map.Entry<Integer, Flat> e : collection.entrySet()) {
                if (isFilter && !checkValueForFilter(e.getValue(), e.getKey())) {
                    continue;
                }
                LocalDateTime ldt = e.getValue().getCreationDate();
                Date outDate = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
                if (e.getValue().getHouse()==null){
                    model.addRow(new Object[]{
                                    e.getValue().getID(),
                                    e.getKey(),
                                    e.getValue().getName(),
                                    e.getValue().getCoordinates().getX(),
                                    e.getValue().getCoordinates().getY(),
                                    outDate,
                                    e.getValue().getArea(),
                                    e.getValue().getNumberOfRooms(),
                                    e.getValue().getFurnish().toString(),
                                    e.getValue().getView().toString(),
                                    e.getValue().getTransport().toString(),
                                    null,
                                    null,
                                    null,
                                    e.getValue().getOwner().getLogin()
                });}
                else{
                model.addRow(new Object[]{
                        e.getValue().getID(),
                        e.getKey(),
                        e.getValue().getName(),
                        e.getValue().getCoordinates().getX(),
                        e.getValue().getCoordinates().getY(),
                        outDate,
                        e.getValue().getArea(),
                        e.getValue().getNumberOfRooms(),
                        e.getValue().getFurnish().toString(),
                        e.getValue().getView().toString(),
                        e.getValue().getTransport().toString(),
                        e.getValue().getHouse().getName(),
                        e.getValue().getHouse().getYear(),
                        e.getValue().getHouse().getNumberOfFloors(),
                        e.getValue().getOwner().getLogin()}
                );
                }


            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    //проверяем элемент на заданный фильтр
    private boolean checkValueForFilter(Flat flat, int key) {
        String chooseField = App.filter.getChooseField().getItemAt(App.filter.getChooseField().getSelectedIndex());
        String argumentField = App.filter.getArgumentField().getText();
        String chooseTypeFilter = App.filter.getChooseTypeFilter().getItemAt(App.filter.getChooseTypeFilter().getSelectedIndex());
        if (chooseField.equals("id")) {
        try {
            int id = Integer.parseInt(argumentField);
            if (chooseTypeFilter.equals("=") && id == flat.getID()) return true;
            if (chooseTypeFilter.equals(">") && flat.getID() > id) return true;
            if (chooseTypeFilter.equals("<") && flat.getID() < id) return true;
            return false;
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Поле id должно быть числом!");
            return false; }
        }
        if (chooseField.equals("key")) {
            try {
                int getKey = Integer.parseInt(argumentField);
                if (chooseTypeFilter.equals("=") && getKey == key) {
                    return true;
                }
                if (chooseTypeFilter.equals(">") && key > getKey) return true;
                if (chooseTypeFilter.equals("<") && key < getKey) return true;
                return false;
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Поле key должно быть целым числом");
                return false;
            }
        };
        if (chooseField.equals("name")) {
            if (chooseTypeFilter.equals("=") && argumentField.equals(flat.getName())) {
                return true;
            }
            if (chooseTypeFilter.equals(">") && argumentField.compareTo(flat.getName()) < 0) return true;
            if (chooseTypeFilter.equals("<") && argumentField.compareTo(flat.getName()) > 0) return true;
            return false;
        }
        if (chooseField.equals("x")) {
            try {
                double x = Float.parseFloat(argumentField);
                if (chooseTypeFilter.equals("=") && flat.getCoordinates().getX() == x) {
                    return true;
                }
                if (chooseTypeFilter.equals(">") && flat.getCoordinates().getX() > x) return true;
                if (chooseTypeFilter.equals("<") && flat.getCoordinates().getX() < x) return true;
                return false;
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Поле x должно быть числом!");
                return false;
            }
        }
        if (chooseField.equals("y")) {
            try {
                float y = Float.parseFloat(argumentField);
                if (chooseTypeFilter.equals("=") && flat.getCoordinates().getY() == y) {
                    return true;
                }
                if (chooseTypeFilter.equals(">") && flat.getCoordinates().getY() > y) return true;
                if (chooseTypeFilter.equals("<") && flat.getCoordinates().getY() < y) return true;
                return false;
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Поле y должно быть числом!");
                return false;
            }
        }
        if (chooseField.equals("area")) {
            try {
                int area = Integer.parseInt(argumentField);
                if (chooseTypeFilter.equals("=") && flat.getArea() == area) {
                    return true;
                }
                if (chooseTypeFilter.equals(">") && flat.getArea() > area) return true;
                if (chooseTypeFilter.equals("<") && flat.getArea() < area) return true;
                return false;
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Поле area должно быть числом!");
                return false;
            }
        }
        if (chooseField.equals("number_of_rooms")) {
            try {
                double rooms = Integer.parseInt(argumentField);
                if (chooseTypeFilter.equals("=") && flat.getNumberOfRooms() == rooms) {
                    return true;
                }
                if (chooseTypeFilter.equals(">") && flat.getNumberOfRooms() > rooms) return true;
                if (chooseTypeFilter.equals("<") && flat.getNumberOfRooms() < rooms) return true;
                return false;
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Поле x должно быть числом!");
                return false;
            }
        }
        if (chooseField.equals("furnish")) {
            if (chooseTypeFilter.equals("=") && Furnish.valueOf(argumentField.toUpperCase()).equals(flat.getFurnish())) {
                return true;
            }
            if (chooseTypeFilter.equals(">") && Furnish.valueOf(argumentField.toUpperCase()).compareTo(flat.getFurnish())< 0) return true;
            if (chooseTypeFilter.equals("<") && Furnish.valueOf(argumentField.toUpperCase()).compareTo(flat.getFurnish()) > 0) return true;
            return false;
        }

        if (chooseField.equals("view")) {
            if (chooseTypeFilter.equals("=") && View.valueOf(argumentField.toUpperCase()).equals(flat.getView())) {
                return true;
            }
            if (chooseTypeFilter.equals(">") && View.valueOf(argumentField.toUpperCase()).compareTo(flat.getView())< 0) return true;
            if (chooseTypeFilter.equals("<") && View.valueOf(argumentField.toUpperCase()).compareTo(flat.getView()) > 0) return true;
            return false;
        }

        if (chooseField.equals("transport")) {
            if (chooseTypeFilter.equals("=") && Transport.valueOf(argumentField.toUpperCase()).equals(flat.getTransport())) {
                return true;
            }
            if (chooseTypeFilter.equals(">") && Transport.valueOf(argumentField.toUpperCase()).compareTo(flat.getTransport())< 0) return true;
            if (chooseTypeFilter.equals("<") && Transport.valueOf(argumentField.toUpperCase()).compareTo(flat.getTransport()) > 0) return true;
            return false;
        }

        if (flat.getHouse()!=null){
        if (chooseField.equals("houseName")) {
            if (chooseTypeFilter.equals("=") && argumentField.equals(flat.getHouse().getName())) {
                return true;
            }
            if (chooseTypeFilter.equals(">") && argumentField.compareTo(flat.getHouse().getName()) < 0) return true;
            if (chooseTypeFilter.equals("<") && argumentField.compareTo(flat.getHouse().getName()) > 0) return true;
            return false;
        }
        if (chooseField.equals("year")) {
            try {
                double year = Long.parseLong(argumentField);
                if (chooseTypeFilter.equals("=") && flat.getHouse().getYear() == year) {
                    return true;
                }
                if (chooseTypeFilter.equals(">") && flat.getHouse().getYear() > year) return true;
                if (chooseTypeFilter.equals("<") && flat.getHouse().getYear() < year) return true;
                return false;
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Поле x должно быть числом!");
                return false;
            }
        }
            if (chooseField.equals("number_of_floors")) {
                try {
                    double number_of_floors = Long.parseLong(argumentField);
                    if (chooseTypeFilter.equals("=") && flat.getHouse().getNumberOfFloors() == number_of_floors) {
                        return true;
                    }
                    if (chooseTypeFilter.equals(">") && flat.getHouse().getNumberOfFloors() > number_of_floors) return true;
                    if (chooseTypeFilter.equals("<") && flat.getHouse().getNumberOfFloors() < number_of_floors) return true;
                    return false;
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Поле x должно быть числом!");
                    return false;
                }
            }
        }
        if (chooseField.equals("user")) {
            if (chooseTypeFilter.equals("=") && argumentField.equals(flat.getOwner().getLogin())) {
                return true;
            }
            if (chooseTypeFilter.equals(">") && argumentField.compareTo(flat.getOwner().getLogin()) < 0) return true;
            if (chooseTypeFilter.equals("<") && argumentField.compareTo(flat.getOwner().getLogin()) > 0) return true;
            return false;
        }
        return false;
    }



    public JPanel getShowPanel(){
        return showPanel;
    }
}
