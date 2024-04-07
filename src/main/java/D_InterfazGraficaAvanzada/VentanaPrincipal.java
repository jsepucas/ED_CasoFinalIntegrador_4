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

