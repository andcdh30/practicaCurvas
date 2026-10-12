package curvas;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.awt.FontFormatException;


public class ArbolFractal extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

       Font fuentePersonalizada;
        try {
            fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, new File("C:/Users/Brokian TI 2025/Documents/NetBeansProjects/practicaCurvas/src/resourses/pruebaclase.ttf"));
            fuentePersonalizada = fuentePersonalizada.deriveFont(48f);
            g2.setFont(fuentePersonalizada);
            g2.drawString("A B C D", 100, 400);
        } catch (FontFormatException ex) {
            System.getLogger(ArbolFractal.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(ArbolFractal.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        



        // Invocar el árbol fractal desde el centro inferior del panel
        /////dibujarArbol(g2, getWidth() / 2, getHeight() - 50, -100, 10);
    }

    // Función recursiva para dibujar el árbol
    private void dibujarArbol(Graphics2D g, int x1, int y1, double angulo, int profundidad) {
        if (profundidad == 0) return;

        int x2 = x1 + (int)(Math.cos(Math.toRadians(angulo)) * profundidad * 10);
        int y2 = y1 + (int)(Math.sin(Math.toRadians(angulo)) * profundidad * 10);

        g.drawLine(x1, y1, x2, y2);

        // Recursión: dos ramas nuevas
        dibujarArbol(g, x2, y2, angulo - 20, profundidad - 1);
        dibujarArbol(g, x2, y2, angulo + 20, profundidad - 1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Árbol Fractal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ArbolFractal());
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}