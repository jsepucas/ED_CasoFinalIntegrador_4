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
