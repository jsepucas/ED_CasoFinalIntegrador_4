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
        setSize(1000, 1000);
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

    private void analyzeAction(ActionEvent event) {
        String content = textArea.getText();
        Map<String, Integer> wordCount = AnalizadorDeTexto.analyzeText(content);
        int totalWords = AnalizadorDeTexto.totalWords(content);

        StringBuilder analysisResult = new StringBuilder("Total de palabras: " + totalWords + "\n\nFrecuencia de palabras:\n");
        wordCount.forEach((word, count) -> analysisResult.append(word).append(": ").append(count).append("\n"));

        JOptionPane.showMessageDialog(this, analysisResult.toString(), "Resultado del Análisis", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AnalizadorDeTexto::new);
    }
}