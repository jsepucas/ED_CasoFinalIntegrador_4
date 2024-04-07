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

        // Ejemplo
        try {
            File file1 = new File("ruta/al/archivo1.txt");
            File file2 = new File("ruta/al/archivo2.txt");

            boolean sonIguales = comparador.comparar(file1, file2);
            System.out.println("Los archivos son iguales: " + sonIguales);

            long numPalabras = analizador.contarPalabras(file1);
            System.out.println("Número de palabras en el archivo1: " + numPalabras);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

