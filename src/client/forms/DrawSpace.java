package client.forms;

import client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DrawSpace extends JPanel {
    private ArrayList<PointWithColor> points;
    private Client client;
    public static int minx;
    public static int maxx;
    public static int miny;
    public static int maxy;
    public static int zerox;
    public static int zeroy;
    public DrawSpace(Client client) {
        points = new ArrayList<>();
        this.client = client;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                checkForClick(e);
            }
        });
    }
    public void addPointWithColor(PointWithColor point) {
        points.add(point);
    }
    public void clearPoints() {

        points.clear();
    }
    private void checkForClick(MouseEvent e) {
        ArrayList<PointWithColor> copy = new ArrayList<>(points);
        for (PointWithColor point : copy) {
            if (point.x - 11*point.radius <= e.getX() && e.getX() <= point.x +11* point.radius && point.y - 11*point.radius <= e.getY() && e.getY() <= point.y + 11*point.radius){
                JOptionPane.showMessageDialog(null,"id: "+point.getFlat().getID()+"\n"+
            "name: "+point.getFlat().getName()+"\n"+
                        "x: "+point.getFlat().getCoordinates().getX()+"\n"+
                        "y: "+point.getFlat().getCoordinates().getY()+"\n"+
                        "creator: "+point.getFlat().getOwner().getLogin());
            }
        }
    }
    private int index=0;
    int i=1;
    public void NewCoordinates(){

        ArrayList<PointWithColor> copy = new ArrayList<>(points);
        for (PointWithColor point : copy) {
            point.setX(i);
            point.setY(i);
        }
        index=index+i;
        if (index>12){
            i=-1;
        }
        if (index<-12){
            i=1;
        }


    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (PointWithColor point : points) {
            g2.setColor(new Color(255 - point.getColor().getRed(), 255 - point.getColor().getGreen(), 255 - point.getColor().getBlue()));
            g2.setFont(new Font("Arial", Font.PLAIN, 16));
            g2.fillRect((point.x - 10*point.radius ) , (point.y - 10*point.radius) , 20*point.radius, 20*point.radius);
            Polygon p = new Polygon();
            p.addPoint(point.x - 14*point.radius, point.y - 10*point.radius);
            p.addPoint(point.x + 14*point.radius , point.y - 10*point.radius);
            p.addPoint(point.x , point.y-20*point.radius);
            g2.fillPolygon(p);
            g2.setColor(new Color(255 - point.getColor().getRed(), 255 - point.getColor().getGreen(), 255 - point.getColor().getBlue()));
            g2.setFont(new Font("Arial", Font.PLAIN, 16));
            g2.setColor(Color.BLACK);
            g2.drawLine(zerox,miny,zerox,maxy);
            g2.drawLine(zerox+10,maxy+10,zerox,maxy);
            g2.drawLine(zerox-10,maxy+10,zerox,maxy);
            g2.drawLine(maxx+20,zeroy,minx,zeroy);
            g2.drawLine(maxx+10,zeroy+10,maxx+20,zeroy);
            g2.drawLine(maxx+10,zeroy-10,maxx+20,zeroy);
            g2.drawString(point.getText(), point.x - g2.getFont().getSize() / 2, point.y + g2.getFont().getSize() / 2);
        }


    }
}
