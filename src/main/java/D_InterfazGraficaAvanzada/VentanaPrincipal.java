package D_InterfazGraficaAvanzada;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        super("Ventana Principal");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton abrirVentana = new JButton("Abrir Documento");
        abrirVentana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaDocumento nuevaVentana = new VentanaDocumento();
                nuevaVentana.setVisible(true);
            }
        });
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
        JTextArea areaTexto = new JTextArea();
        add(new JScrollPane(areaTexto));
        setLocationRelativeTo(null);
    }
}