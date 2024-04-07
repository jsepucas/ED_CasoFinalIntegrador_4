package D_InterfazGraficaAvanzada;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaDeTexto {
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public VentanaDeTexto(String titulo) {
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);

        // Seguimiento del ratón
        textArea.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("Posición del ratón: " + e.getX() + ", " + e.getY());
            }
        });
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }
}