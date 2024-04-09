package D_InterfazGraficaAvanzada;

import javax.swing.*;
import java.awt.*;

public class LogoPanel extends JPanel {

    public LogoPanel() {
        setPreferredSize(new Dimension(200, 100)); // Ajusta las dimensiones según necesites
        setBackground(Color.WHITE); // Establece el color de fondo del logo
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Aquí es donde comenzarías a dibujar las formas y letras que componen tu logo
        // Por ejemplo, dibujar una letra 'U' simple:
        g2d.setColor(Color.BLUE);
        g2d.setFont(new Font("Arial", Font.BOLD, 48)); // Ajusta la fuente como sea necesario
        g2d.drawString("UAX", getWidth() / 4, getHeight() / 2);

        // Dibuja un rectángulo alrededor del logo (si es necesario)
        g2d.setColor(Color.BLACK);
        g2d.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

        g2d.dispose();
    }
}
