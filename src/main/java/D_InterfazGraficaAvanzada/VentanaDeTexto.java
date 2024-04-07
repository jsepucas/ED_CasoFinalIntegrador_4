package E_Validacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ValidadorEmailGUI extends JFrame {
    private JTextField campoEmail;
    private JLabel etiquetaValidacion;

    public ValidadorEmailGUI() {
        setTitle("Validador de Email");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        configurarUI();
    }

