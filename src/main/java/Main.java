import A_EditorDeTextoInteractivo.EditorDeTextoGUI;
import B_ComparadorYContador.ComparadorDeArchivos;
import B_ComparadorYContador.AnalizadorDeTexto;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // GUI
        new EditorDeTextoGUI();

        // Crear instancias de ComparadorDeArchivos y AnalizadorDeTexto
        ComparadorDeArchivos comparador = new ComparadorDeArchivos();
        AnalizadorDeTexto analizador = new AnalizadorDeTexto();

