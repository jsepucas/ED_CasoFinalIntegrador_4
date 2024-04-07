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
        new EditorDeTextoGUI();

        // instancias de ComparadorDeArchivos, AnalizadorDeTexto, BuscadorDePalabras yy AgendaDeContactos
        ComparadorDeArchivos comparador = new ComparadorDeArchivos();
        AnalizadorDeTexto analizador = new AnalizadorDeTexto();
        BuscadorDePalabras buscador = new BuscadorDePalabras();
        AgendaDeContactos agenda = new AgendaDeContactos();

        // Ejemplo
        try {
            File file1 = new File("ruta/al/archivo1.txt");
            File file2 = new File("ruta/al/archivo2.txt");


            boolean sonIguales = comparador.comparar(file1, file2);
            System.out.println("Los archivos son iguales: " + sonIguales);

            long numPalabras = analizador.contarPalabras(file1);
            System.out.println("Número de palabras en el archivo1: " + numPalabras);


            long numOcurrencias = buscador.buscarPalabra(file1, "palabraABuscar");
            System.out.println("Número de ocurrencias de 'palabraABuscar' en el archivo1: " + numOcurrencias);

            Contacto contacto = new Contacto("Nombre", "Email", "NumeroTelefono");
            agenda.agregarContacto(contacto);
            System.out.println("Contacto agregado a la agenda: " + contacto.getNombre());

