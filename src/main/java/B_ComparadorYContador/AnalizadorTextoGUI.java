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