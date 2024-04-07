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

        //Creacion del menu

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Archivo");
        JMenuItem openItem = new JMenuItem("Abrir");
        JMenuItem saveItem = new JMenuItem("Guardar");
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        //Accion para abrir el archivoo

        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        textArea.read(new FileReader(selectedFile), null);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

        //accion para guardarlo








}
