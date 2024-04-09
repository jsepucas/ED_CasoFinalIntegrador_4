import A_EditorDeTextoInteractivo.EditorDeTextoGUI;
import B_ComparadorYContador.ComparadorDeArchivos;
import B_ComparadorYContador.AnalizadorTextoGUI;
import C_BusquedaYGestion.BuscadorDePalabrasGUI;
import D_InterfazGraficaAvanzada.Decoracion;
import D_InterfazGraficaAvanzada.LogoPanel;
import D_InterfazGraficaAvanzada.VentanaPrincipal;
import E_Validacion.HerramientaDibujoGUI;
import E_Validacion.ValidadorEmailGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAplicacion extends JFrame {

    public MainAplicacion() {
        setTitle("Aplicación de la Universidad Alfonso X el Sabio (UAX)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(680, 370);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 1));

        setLayout(new BorderLayout());

        Decoracion.PanelConFondo panelFondo = new Decoracion.PanelConFondo();


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

        JButton botonHerramientaDibujo = Decoracion.crearBotonDecorado("Herramienta de Dibujo \uD83D\uDD8B");
        botonHerramientaDibujo.addActionListener(e -> abrirHerramientaDibujo());

        setVisible (true);

        panelFondo.add(botonEditor);
        panelFondo.add(botonComparador);
        panelFondo.add(botonAnalizador);
        panelFondo.add(botonBuscador);
        panelFondo.add(botonValidadorEmail);
        panelFondo.add(botonHerramientaDibujo);

        setContentPane(panelFondo);
        setVisible (true);
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

    private void abrirHerramientaDibujo() {
        new HerramientaDibujoGUI().setVisible(true);
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

    private static class LogoPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Dibujo del logo aquí
            g.setFont(new Font("SansSerif", Font.BOLD, 48));
            g.drawString("UAX", 1, 5); // Posición simplificada
        }
    }

    // Método para crear un botón decorado
    private JButton crearBotonDecorado(String texto, ActionListener accion) {
        JButton boton = new JButton(texto);
        boton.addActionListener(accion);
        // Personalizar el botón si es necesario
        return boton;
    }
}
