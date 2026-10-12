/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package curvas;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Curvas extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Suavizar bordes
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Puntos de control
        Point2D p0 = new Point2D.Double(50, 250);   // Inicio
        Point2D p1 = new Point2D.Double(100, 50);   // Control 1
        Point2D p2 = new Point2D.Double(400, 400);  // Control 2
        Point2D p3 = new Point2D.Double(450, 250);  // Fin

        // Dibujar líneas guía entre puntos de control
        g2.setColor(Color.LIGHT_GRAY);
        g2.draw(new Line2D.Double(p0, p1));
        g2.draw(new Line2D.Double(p1, p2));
        g2.draw(new Line2D.Double(p2, p3));

        // Dibujar puntos de control
        g2.setColor(Color.ORANGE);
        g2.fill(new Ellipse2D.Double(p1.getX() - 5, p1.getY() - 5, 10, 10));
        g2.fill(new Ellipse2D.Double(p2.getX() - 5, p2.getY() - 5, 10, 10));

        // Dibujar puntos inicial y final
        g2.setColor(Color.BLUE);
        g2.fill(new Ellipse2D.Double(p0.getX() - 5, p0.getY() - 5, 10, 10));
        g2.setColor(Color.RED);
        g2.fill(new Ellipse2D.Double(p3.getX() - 5, p3.getY() - 5, 10, 10));

        // Dibujar la curva Bézier cúbica
        g2.setColor(Color.BLACK);
        CubicCurve2D curva = new CubicCurve2D.Double(
            p0.getX(), p0.getY(),
            p1.getX(), p1.getY(),
            p2.getX(), p2.getY(),
            p3.getX(), p3.getY()
        );
        g2.setStroke(new BasicStroke(2));
        g2.draw(curva);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Curva Bézier Cúbica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Curvas());
        frame.setSize(550, 550);
        frame.setVisible(true);
    }
}
