import A_EditorDeTextoInteractivo.EditorDeTextoGUI;
import B_ComparadorYContador.ComparadorDeArchivos;
import B_ComparadorYContador.AnalizadorTextoGUI;
import C_BusquedaYGestion.BuscadorDePalabrasGUI;
import D_InterfazGraficaAvanzada.VentanaPrincipal;
import E_Validacion.ValidadorEmailGUI; // Validador de Email.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainAplicacion extends JFrame {

    public MainAplicacion() {
        setTitle("Aplicación Unificada");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 1));

        JButton botonEditor = new JButton("Editor de Texto");
        botonEditor.addActionListener(e -> abrirEditor());

        JButton botonComparador = new JButton("Comparador de Archivos");
        botonComparador.addActionListener(e -> abrirComparador());

        JButton botonAnalizador = new JButton("Analizador de Texto");
        botonAnalizador.addActionListener(e -> abrirAnalizadorTexto());

        JButton botonBuscador = new JButton("Buscador de Palabras");
        botonBuscador.addActionListener(e -> abrirBuscador());

        JButton botonValidadorEmail = new JButton("Validador de Email");
        botonValidadorEmail.addActionListener(e -> abrirValidadorEmail());

