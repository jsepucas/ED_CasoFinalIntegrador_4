package A_EditorDeTextoInteractivo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EditorDeTextoGUI extends JFrame {

    private JTextArea textArea;
    private JFileChooser fileChooser;

    public EditorDeTextoGUI() {
        super("Editor de Texto Interactivo");

        textArea = new JTextArea();
        fileChooser = new JFileChooser();

        // Creación del menú
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Archivo");
        JMenuItem openItem = new JMenuItem("Abrir");
        JMenuItem saveItem = new JMenuItem("Guardar");
        JMenuItem listItem = new JMenuItem("Listar Archivos");
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(listItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Acción para abrir el archivo
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

        // Acción para guardar el archivo
        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int returnValue = fileChooser.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        textArea.write(new FileWriter(selectedFile));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

        // Acción para listar archivos
        listItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedDirectory = fileChooser.getSelectedFile();
                    File[] filesInDirectory = selectedDirectory.listFiles();
                    if (filesInDirectory != null) {
                        for (File file : filesInDirectory) {
                            System.out.println(file.getName());
                        }
                    }
                }
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            }
        });

        // Configuración del layout
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EditorDeTextoGUI();
    }
}