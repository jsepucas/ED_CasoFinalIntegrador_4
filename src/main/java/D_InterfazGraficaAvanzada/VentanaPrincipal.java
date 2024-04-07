package D_InterfazGraficaAvanzada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        super("Ventana Principal");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton abrirVentana = new JButton("Abrir Documento");
        abrirVentana.addActionListener(e -> new VentanaDocumento().setVisible(true));
        add(abrirVentana);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }
}

class VentanaDocumento extends JFrame {
    public VentanaDocumento() {
        super("Documento");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Componentes de la ventana de documento
        JTextArea areaTexto = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        add(scrollPane);

        JLabel posicionRaton = new JLabel("Posición: ");
        add(posicionRaton, BorderLayout.SOUTH);

        // Seguimiento del ratón
        areaTexto.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                posicionRaton.setText("Posición: " + e.getX() + ", " + e.getY());
            }
        });

        // Barra de desplazamiento interactiva
        JScrollBar barraDesplazamiento = scrollPane.getVerticalScrollBar();
        barraDesplazamiento.addAdjustmentListener(e -> {
            int valorMaximo = barraDesplazamiento.getMaximum() - barraDesplazamiento.getVisibleAmount();
            int valorActual = barraDesplazamiento.getValue();
            double porcentaje = valorActual * 100.0 / valorMaximo;
            setTitle("Documento - Progreso: " + (int) porcentaje + "%");
        });

        setLocationRelativeTo(null);
    }
}
