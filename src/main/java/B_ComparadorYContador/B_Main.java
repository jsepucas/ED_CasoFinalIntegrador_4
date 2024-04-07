package B_ComparadorYContador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class B_Main extends JFrame {
    private JButton openComparatorButton;
    private JButton openAnalyzerButton;

    public B_Main() {
        setTitle("Comparador y Analizador de Texto");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
    }


    private void initUI() {
        openComparatorButton = new JButton("Abrir Comparador de Archivos");
        openAnalyzerButton = new JButton("Abrir Analizador de Texto");

        openComparatorButton.addActionListener(this::ComparadorDeArchivos);
        openAnalyzerButton.addActionListener(this::AnalizadorDeTexto);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(openComparatorButton);
        panel.add(openAnalyzerButton);

        this.add(panel);
        pack(); // Ajusta el tamaño de la ventana según los componentes
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setVisible(true);
    }
