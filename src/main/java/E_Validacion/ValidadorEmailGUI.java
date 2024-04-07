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

    private void configurarUI() {
    }

    private void validarEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (email.matches(regex)) {
            etiquetaValidacion.setText("Email válido");
            etiquetaValidacion.setForeground(Color.GREEN);
        } else {
            etiquetaValidacion.setText("Email no válido");
            etiquetaValidacion.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ValidadorEmailGUI::new);
    }
}

