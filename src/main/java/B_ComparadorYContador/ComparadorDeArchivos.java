package A_EditorDeTextoInteractivo;

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