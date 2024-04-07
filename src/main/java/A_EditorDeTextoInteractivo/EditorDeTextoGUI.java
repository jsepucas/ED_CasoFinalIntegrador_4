package A_EditorDeTextoInteractivo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditorDeTextoGUI {
    private JFrame frame;
    private JTabbedPane tabbedPane;

    public EditorDeTextoGUI() {
        frame = new JFrame("Editor de Texto Avanzado");
        tabbedPane = new JTabbedPane();

        // Ejemplo de cómo agregar una nueva ventana (tab)
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        tabbedPane.addTab("Documento 1", scrollPane);

        // Seguimiento del ratón
        textArea.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("Posición del ratón: " + e.getX() + ", " + e.getY());
            }
        });

        frame.add(tabbedPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    // Método para agregar una nueva ventana (tab)
    public void agregarNuevaVentana(String titulo) {
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        tabbedPane.addTab(titulo, scrollPane);
    }
}
