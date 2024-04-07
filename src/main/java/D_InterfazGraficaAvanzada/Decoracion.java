package D_InterfazGraficaAvanzada;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Decoracion extends JPanel {

    // Definir los colores del gradiente
    private Color colorInicio = Color.BLUE; // Color al inicio del gradiente
    private Color colorFin = Color.GREEN; // Color al final del gradiente

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        // Crear un gradiente que vaya de arriba a abajo
        GradientPaint gradiente = new GradientPaint(
                new Point(0, 0), colorInicio,
                new Point(0, getHeight()), colorFin);

        g2d.setPaint(gradiente);
        g2d.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        g2d.dispose();
    }
}
