package D_InterfazGraficaAvanzada;

import javax.swing.*;
import java.awt.*;

public class Decoracion {



    public static JPanel crearPanelPrincipalConLogo(ImageIcon logo) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);

        JLabel etiquetaLogo = new JLabel(logo);
        etiquetaLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(etiquetaLogo);

        panel.add(Box.createVerticalStrut(20)); // Espacio entre el logo y los botones

        return panel;
    }

    public static JButton crearBotonDecorado(String texto) {
        JButton boton = new JButton(texto);
        boton.setPreferredSize(new Dimension(200, 50));
        boton.setMaximumSize(new Dimension(200, 50));
        boton.setAlignmentX(Component.CENTER_ALIGNMENT); // Alinear botones en el centro
        // Estilos adicionales aquí, como colores, fuentes, etc.
        return boton;
    }

    private static void establecerLookFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Otras decoraciones personalizadas...

    // Clase interna para el panel con fondo
    public static class PanelConFondo extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Dibuja el gradiente de fondo
            Graphics2D g2d = (Graphics2D) g;
            GradientPaint gradiente = new GradientPaint(0, 0, Color.BLUE, 0, getHeight(), Color.WHITE);
            g2d.setPaint(gradiente);
            g2d.fillRect(0, 0, getWidth(), getHeight());

            // Dibuja el logo de UAX
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("SansSerif", Font.BOLD, 77));
            // Centrar el texto
            FontMetrics metrics = g2d.getFontMetrics();
            int x = (getWidth() - metrics.stringWidth("UAX")) / 2;
            int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
            g2d.drawString("UAX", x, y);
        }
    }
}
