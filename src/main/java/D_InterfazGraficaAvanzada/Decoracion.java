package D_InterfazGraficaAvanzada;

import javax.swing.*;
import java.awt.*;

public class Decoracion {

    public static void aplicarDecoracion(JFrame ventana) {
        // Aplica un tema general si es necesario
        establecerLookFeel();

        // Configura el fondo y los estilos de los componentes
        PanelConFondo panelFondo = new PanelConFondo();
        ventana.setContentPane(panelFondo);
    }

    public static JButton crearBotonDecorado(String texto) {
        JButton boton = new JButton(texto);
        // Personalización del botón
        boton.setPreferredSize(new Dimension(200, 50));
        // Añade más estilos si es necesario
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

            Graphics2D g2d = (Graphics2D) g;
            GradientPaint gradiente = new GradientPaint(0, 0, Color.BLUE, 0, getHeight(), Color.WHITE);
            g2d.setPaint(gradiente);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
