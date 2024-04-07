package A_EditorDeTextoInteractivo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class EditorDeTextoGUI extends JFrame {

    private JTextArea textArea;
    private JFileChooser fileChooser;

    public EditorDeTextoGUI() {
        super("Editor de Texto Interactivo");

        textArea = new JTextArea();
        fileChooser = new JFileChooser();


}
