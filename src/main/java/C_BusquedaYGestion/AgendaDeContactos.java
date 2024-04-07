package C_BusquedaYGestion;

import java.util.ArrayList;
import java.util.List;

public class AgendaDeContactos {
    private List<Contacto> contactos;

    public AgendaDeContactos() {
        this.contactos = new ArrayList<>();
    }


    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public void eliminarContacto(Contacto contacto) {
        contactos.remove(contacto);
    }

    public Contacto buscarContactoPorNombre(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null;
    }
}


class Contacto {
    private String nombre;
    private String email;
    private String numeroTelefono;

    public Contacto(String nombre, String email, String numeroTelefono) {
        this.nombre = nombre;
        this.email = email;
        this.numeroTelefono = numeroTelefono;
    }

    public String getNombre() {
        return nombre;
    }




