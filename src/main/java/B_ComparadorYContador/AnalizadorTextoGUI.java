package B_ComparadorYContador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.nio.file.Files;
import java.util.Map;

public class AnalizadorTextoGUI extends JFrame {
    private JTextArea textArea;
    private JButton analyzeButton, loadButton;
    private final JFileChooser fileChooser;

    public AnalizadorTextoGUI() {
        setTitle("Analizador de Texto");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fileChooser = new JFileChooser();
        initUI();
    }

    private void initUI() {
        textArea = new JTextArea();
        analyzeButton = new JButton("Analizar Texto");
        loadButton = new JButton("Cargar Archivo");

        loadButton.addActionListener(this::loadAction);
        analyzeButton.addActionListener(this::analyzeAction);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loadButton);
        buttonPanel.add(analyzeButton);

        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadAction(ActionEvent event) {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                String content = Files.readString(file.toPath());
                textArea.setText(content);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al cargar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
