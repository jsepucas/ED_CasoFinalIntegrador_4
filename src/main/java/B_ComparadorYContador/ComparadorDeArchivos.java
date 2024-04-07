package B_ComparadorYContador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ComparadorDeArchivos extends JFrame {
    private JButton compareButton;
    private JTextArea resultArea;
    private final JFileChooser fileChooser;

    public ComparadorDeArchivos() {
        setTitle("Comparador de Archivos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fileChooser = new JFileChooser();
        initUI();
    }


    private void initUI() {
        compareButton = new JButton("Comparar Archivos");
        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);

        compareButton.addActionListener(this::compareAction);

        setLayout(new BorderLayout());
        add(compareButton, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void compareAction(ActionEvent event) {
        try {
            File file1 = chooseFile();
            if (file1 == null) return;
            File file2 = chooseFile();
            if (file2 == null) return;

            String content1 = new String(Files.readAllBytes(Paths.get(file1.getAbsolutePath())));
            String content2 = new String(Files.readAllBytes(Paths.get(file2.getAbsolutePath())));

            if (content1.equals(content2)) {
                resultArea.setText("Los archivos son idénticos.");
            } else {
                resultArea.setText("Los archivos difieren.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer los archivos: " + e.getMessage());
        }
    }

    private File chooseFile() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }
}

