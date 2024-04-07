import A_EditorDeTextoInteractivo.EditorDeTextoGUI;
import B_ComparadorYContador.ComparadorDeArchivos;
import B_ComparadorYContador.AnalizadorDeTexto;
import C_BusquedaYGestion.AgendaDeContactos;
import C_BusquedaYGestion.BuscadorDePalabras;
import C_BusquedaYGestion.Contacto;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // GUI
        EditorDeTextoGUI gui = new EditorDeTextoGUI();

        // Crear instancias de ComparadorDeArchivos, AnalizadorDeTexto, BuscadorDePalabras y AgendaDeContactos
        ComparadorDeArchivos comparador = new ComparadorDeArchivos();
        AnalizadorDeTexto analizador = new AnalizadorDeTexto();
        BuscadorDePalabras buscador = new BuscadorDePalabras();
        AgendaDeContactos agenda = new AgendaDeContactos();

        // Ejemplo
        try {
            File file1 = new File("ruta/al/tuArchivo1.txt");
            File file2 = new File("ruta/al/tuArchivo2.txt");

            boolean sonIguales = comparador.comparar(file1, file2);
            System.out.println("Los archivos son iguales: " + sonIguales);

            long numPalabras = analizador.contarPalabras(file1);
            System.out.println("Número de palabras en el archivo1: " + numPalabras);

            long numOcurrencias = buscador.buscarPalabra(file1, "tuPalabraABuscar");
            System.out.println("Número de ocurrencias de 'tuPalabraABuscar' en el archivo1: " + numOcurrencias);

            Contacto contacto = new Contacto("TuNombre", "TuEmail", "TuNumeroTelefono");
            agenda.agregarContacto(contacto);
            System.out.println("Contacto agregado a la agenda: " + contacto.getNombre());

            // Agregar una nueva ventana (tab) a la GUI
            gui.agregarNuevaVentana("Nueva ventana");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}