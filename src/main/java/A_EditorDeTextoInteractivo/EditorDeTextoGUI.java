package A_EditorDeTextoInteractivo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class EditorDeTextoGUI extends JFrame {
    private JTextArea textArea;
    private JButton saveButton, openButton, folderButton;
    private JList<File> fileList;
    private DefaultListModel<File> fileListModel;

    public EditorDeTextoGUI() {
        setTitle("Editor de Texto Interactivo");
        setSize(700, 500); // Ajustado para mejor visualización
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initUI();
        setVisible(true);
    }

    private void initUI() {
        textArea = new JTextArea();
        saveButton = new JButton("Guardar");
        openButton = new JButton("Abrir");
        folderButton = new JButton("Seleccionar Carpeta");

        saveButton.addActionListener(e -> saveTextToFile());
        openButton.addActionListener(e -> openTextFromFile());
        folderButton.addActionListener(e -> selectFolder());

        fileListModel = new DefaultListModel<>();
        fileList = new JList<>(fileListModel);
        fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fileList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                openSelectedFile();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(openButton);
        buttonPanel.add(folderButton);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(fileList), new JScrollPane(textArea));
        splitPane.setDividerLocation(125);

        this.setLayout(new BorderLayout());
        this.add(splitPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void saveTextToFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(textArea.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error guardando el archivo: " + e.getMessage());
            }
        }
    }

    private void openTextFromFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            readFile(file);
        }
    }

    private void selectFolder() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File folder = fileChooser.getSelectedFile();
            listTextFiles(folder.toPath());
        }
    }

    private void listTextFiles(Path folder) {
        try {
            List<File> files = Files.walk(folder)
                    .filter(Files::isRegularFile)
                    .filter(p -> p.toString().endsWith(".txt"))
                    .map(Path::toFile)
                    .collect(Collectors.toList());

            fileListModel.clear();
            files.forEach(fileListModel::addElement);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error listando archivos: " + e.getMessage());
        }
    }

    private void openSelectedFile() {
        File selectedFile = fileList.getSelectedValue();
        if (selectedFile != null) {
            readFile(selectedFile);
        }
    }

    private void readFile(File file) {
        try (FileReader reader = new FileReader(file)) {
            textArea.setText("");
            int c;
            while ((c = reader.read()) != -1) {
                textArea.append(String.valueOf((char) c));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error leyendo el archivo: " + e.getMessage());
        }
    }
}
