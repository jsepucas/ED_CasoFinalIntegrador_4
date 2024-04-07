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