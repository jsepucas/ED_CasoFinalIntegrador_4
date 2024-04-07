package E_Validacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class HerramientaDibujoGUI extends JFrame {
    private JPanel lienzo;

    public HerramientaDibujoGUI() {
        setTitle("Herramienta de Dibujo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        configurarUI();
    }
