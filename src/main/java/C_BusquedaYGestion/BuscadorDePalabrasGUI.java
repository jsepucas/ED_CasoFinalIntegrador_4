package C_BusquedaYGestion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuscadorDePalabrasGUI extends JFrame {
    private JTextArea areaDeTexto;
    private JTextField campoDeBusqueda;
    private JButton botonCargar, botonBuscar;
    private final JFileChooser selectorDeArchivos;

    public BuscadorDePalabrasGUI() {
        setTitle("Buscador de Palabras");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        selectorDeArchivos = new JFileChooser();
        iniciarUI();
    }

    private void iniciarUI() {
        areaDeTexto = new JTextArea();
        areaDeTexto.setEditable(false);
        campoDeBusqueda = new JTextField(20);
        botonCargar = new JButton("Cargar Archivo");
        botonBuscar = new JButton("Buscar Palabra");

        botonCargar.addActionListener(this::accionCargar);
        botonBuscar.addActionListener(this::accionBuscar);

        JPanel panelNorte = new JPanel();
        panelNorte.add(botonCargar);
        panelNorte.add(new JLabel("Palabra:"));
        panelNorte.add(campoDeBusqueda);
        panelNorte.add(botonBuscar);

        setLayout(new BorderLayout());
        add(panelNorte, BorderLayout.NORTH);
        add(new JScrollPane(areaDeTexto), BorderLayout.CENTER);

        setVisible(true);
    }

    private void accionCargar(ActionEvent evento) {
        if (selectorDeArchivos.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File archivo = selectorDeArchivos.getSelectedFile();
            try {
                String contenido = Files.readString(archivo.toPath());
                areaDeTexto.setText(contenido);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al cargar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void accionBuscar(ActionEvent evento) {
        String palabra = campoDeBusqueda.getText().trim();
        String texto = areaDeTexto.getText();
        if (palabra.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una palabra para buscar.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Pattern patron = Pattern.compile("\\b" + Pattern.quote(palabra) + "\\b", Pattern.CASE_INSENSITIVE);
        Matcher coincidencia = patron.matcher(texto);
        int contador = 0;
        while (coincidencia.find()) {
            contador++;
        }

        JOptionPane.showMessageDialog(this, "La palabra '" + palabra + "' aparece " + contador + " veces en el texto.", "Resultado de la Búsqueda", JOptionPane.INFORMATION_MESSAGE);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(BuscadorDePalabrasGUI::new);
    }
}