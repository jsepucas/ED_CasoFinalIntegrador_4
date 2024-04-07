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



