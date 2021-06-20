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
            if (point.x - point.radius <= e.getX() && e.getX() <= point.x + point.radius && point.y - point.radius <= e.getY() && e.getY() <= point.y + point.radius){
                JOptionPane.showMessageDialog(null,"Тратататата");
            }
        }
    }


    @Override
    public void paintComponent(Graphics g) {
        System.out.println("DrawSpace 42 -перерисовка");
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (PointWithColor point : points) {
            g2.setColor(point.getColor());
            g2.fillRect(point.x - point.radius / 2, point.y - point.radius / 2, point.radius, point.radius);
            Polygon p = new Polygon();
            p.addPoint(point.x - point.radius / 2, point.y - point.radius / 2);
            p.addPoint(point.x + point.radius / 2, point.y - point.radius / 2);
            p.addPoint(point.x, point.radius/2);
            g2.fillPolygon(p);
            g2.setColor(new Color(255 - point.getColor().getRed(), 255 - point.getColor().getGreen(), 255 - point.getColor().getBlue()));
            g2.setFont(new Font("Arial", Font.PLAIN, 10));
            g2.drawString(point.getText(), point.x - g2.getFont().getSize() / 2, point.y + g2.getFont().getSize() / 2);
        }
        System.out.println("DrawSpace-59-Нарисовали новые");

    }
}
