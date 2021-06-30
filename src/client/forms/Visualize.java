package client.forms;

import client.App;
import client.Client;
import common.Request;
import common.Response;
import common.data.Flat;
import net.miginfocom.swing.MigLayout;
import resources.LocaleBundle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class Visualize extends JPanel {
    private JPanel visualizePanel;
    private Thread draw;
    private Client client;
    private JButton backButton;
    private boolean isActive;
    private JLabel name;
    private DrawSpace drawSpace;
    private ArrayList<PointWithColor> myCopy = new ArrayList<>();

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
        drawSpace = new DrawSpace(this.client);
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
        visualizePanel.add(name, "cell 3 0,align center center,grow 0 0");

        backButton.setText("\u041d\u0430\u0437\u0430\u0434");
        backButton.setBackground(Color.white);
        backButton.setForeground(new Color(161, 35, 106));
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        visualizePanel.add(backButton, "cell 6 7,align center center,grow 0 0,width 80:130:220,height 30:30:50");


        //======== drawSpace ========

        drawSpace.setBackground(Color.white);
        drawSpace.setLayout(null);
        Dimension preferredSize = new Dimension();
        for(int i = 0; i < drawSpace.getComponentCount(); i++) {
            Rectangle bounds = drawSpace.getComponent(i).getBounds();
            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
        }
        Insets insets = drawSpace.getInsets();
        preferredSize.width += insets.right;
        preferredSize.height += insets.bottom;
        drawSpace.setMinimumSize(preferredSize);
        drawSpace.setPreferredSize(preferredSize);
        visualizePanel.add(drawSpace, "cell 1 1 5 7");

    }


    public void setObjects() {
        try {
            client.send(new Request("show", "", client.getUser()));
            Response fromServer = client.receive();
            Hashtable<Integer, Flat> collection = fromServer.getCollection();
            myCopy.removeIf(point -> !collection.containsValue(point.getFlat()));
            int maxX = -1000;
            int minX = Integer.MAX_VALUE;
            int maxY = -1000;
            int minY = Integer.MAX_VALUE;
            int weight = (int) (drawSpace.getWidth() * 0.9);
            int height = (int) (drawSpace.getHeight() * 0.9);
            //System.out.println(weight+" "+height);
            for (Map.Entry<Integer, Flat> e : collection.entrySet()) {
                if (e.getValue().getCoordinates().getX() > maxX) maxX = (int)(float) e.getValue().getCoordinates().getX();
                if (e.getValue().getCoordinates().getX() < minX) minX = (int)(float) e.getValue().getCoordinates().getX();
                if (e.getValue().getCoordinates().getY() > maxY)
                    maxY = (int) (double) e.getValue().getCoordinates().getY();
                if (e.getValue().getCoordinates().getY() < minY)
                    minY = (int) (double) e.getValue().getCoordinates().getY();
            }
            DrawSpace.miny=(int) (height + (drawSpace.getHeight() * 0.05));

            DrawSpace.zerox=(int) (( - minX) * (weight / (maxX - minX)) + (drawSpace.getWidth() * 0.05));;
            DrawSpace.maxx=(int) ((maxX - minX) * (weight / (maxX - minX)) + (drawSpace.getWidth() * 0.05));
            DrawSpace.zeroy=(int) (-( - minY) * (height / (maxY - minY))+height + (drawSpace.getHeight() * 0.05));
            DrawSpace.maxy=(int) (-(maxY - minY) * (height / (maxY - minY))+height + (drawSpace.getHeight() * 0.05));
            for (Map.Entry<Integer, Flat> e : collection.entrySet()) {
                int oldX = (int)(float) e.getValue().getCoordinates().getX();
                int oldY = (int) (double) e.getValue().getCoordinates().getY();
                int x = (int) ((oldX - minX) * (weight / (maxX - minX)) + (drawSpace.getWidth() * 0.05));
                int y = (int) (-(oldY - minY) * (height / (maxY - minY))+height + (drawSpace.getHeight() * 0.05));
                PointWithColor point = new PointWithColor(
                        x,
                        y,
                        Color.decode(e.getValue().getOwner().getColor()),
                        height ,
                        String.valueOf(e.getValue().getID()),
                        e.getValue(),
                        e.getKey());
                if (!myCopy.contains(point)) {
                    point.radius = 1;
                    myCopy.add(point);
                } else {
                    int index = 0;
                    for (PointWithColor fromList : myCopy) {
                        if (fromList.equals(point)) break;
                        index++;
                    }
                    myCopy.get(index).radius += 1;
                    if (myCopy.get(index).radius > height / 10)
                        myCopy.get(index).radius = height / 10;
                    point.radius = myCopy.get(index).radius;
                }

                drawSpace.addPointWithColor(point);
            }

        } catch (IOException exception) {
            JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("ioPaneError"));
        } catch (ClassNotFoundException classNotFoundException) {
            JOptionPane.showMessageDialog(null, LocaleBundle.getCurrentBundle().getString("classNotFoundError"));
        }
    }

    public void startThread() {
        isActive = true;
        draw=new Thread(new Runnable() {
            @Override
            public void run() {
                long start= System.nanoTime();
                drawSpace.clearPoints();
                setObjects();
                drawSpace.repaint();
                while (isActive) {

                    long time=0;
                    long finish= System.nanoTime();
                    if ((finish-start)/ 1000000000<=8){
                        drawSpace.NewCoordinates();
                        drawSpace.repaint();


                    }
                    else{
                        drawSpace.clearPoints();
                        setObjects();
                        drawSpace.repaint();
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ignored) {}
                }


            }

        });
        draw.start();
        

    }

    public void localize() {
        backButton.setText(LocaleBundle.getCurrentBundle().getString("back_button"));

    }
    public JPanel getVisualizePanel() {
        return visualizePanel;
    }
}
