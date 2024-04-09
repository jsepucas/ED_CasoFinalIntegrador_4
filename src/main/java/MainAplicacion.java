import A_EditorDeTextoInteractivo.EditorDeTextoGUI;
import B_ComparadorYContador.ComparadorDeArchivos;
import B_ComparadorYContador.AnalizadorTextoGUI;
import C_BusquedaYGestion.BuscadorDePalabrasGUI;
import D_InterfazGraficaAvanzada.Decoracion;
import D_InterfazGraficaAvanzada.VentanaPrincipal;
import E_Validacion.ValidadorEmailGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainAplicacion extends JFrame {

    public MainAplicacion() {
        setTitle("Aplicación de la Universidad Alfonso X el Sabio (UAX)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 1));

        Decoracion.PanelConFondo panelFondo = new Decoracion.PanelConFondo();
        panelFondo.setLayout(new GridLayout(0, 1, 10, 10));
        panelFondo.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JButton botonEditor = Decoracion.crearBotonDecorado("Editor de Texto \uD83D\uDCC7");
        botonEditor.addActionListener(e -> abrirEditor());

        JButton botonComparador = Decoracion.crearBotonDecorado("Comparador de Archivos ");
        botonComparador.addActionListener(e -> abrirComparador());

        JButton botonAnalizador = Decoracion.crearBotonDecorado("Analizador de Texto   ");
        botonAnalizador.addActionListener(e -> abrirAnalizadorTexto());

        JButton botonBuscador = Decoracion.crearBotonDecorado("Buscador de Palabras \uD83D\uDD0E");
        botonBuscador.addActionListener(e -> abrirBuscador());

        JButton botonValidadorEmail = Decoracion.crearBotonDecorado("Validador de Email   \uD83D\uDCE7  ");
        botonValidadorEmail.addActionListener(e -> abrirValidadorEmail());

        panelFondo.add(botonEditor);
        panelFondo.add(botonComparador);
        panelFondo.add(botonAnalizador);
        panelFondo.add(botonBuscador);
        panelFondo.add(botonValidadorEmail);

        setContentPane(panelFondo);
    }

    private void abrirEditor() {
        EditorDeTextoGUI editor = new EditorDeTextoGUI();
        editor.setVisible(true);
    }

    private void abrirComparador() {
        new ComparadorDeArchivos().setVisible(true);
    }

    private void abrirAnalizadorTexto() {
        new AnalizadorTextoGUI().setVisible(true);
    }

    private void abrirBuscador() {
        new BuscadorDePalabrasGUI().setVisible(true);
    }

    private void abrirValidadorEmail() {
        new ValidadorEmailGUI().setVisible(true);
    }

    public static void main(String[] args) {
        // Establecer el look and feel de la interfaz de usuario del sistema operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Asegurarse de que la ventana se muestre en el Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new MainAplicacion().setVisible(true));
    }
}
