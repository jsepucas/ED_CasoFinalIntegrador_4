package C_BuscadorYAgenda;

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

    