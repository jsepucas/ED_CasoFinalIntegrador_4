package C_BusquedaYGestion;

public class Contacto {
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

    public String getEmail() {
        return email;
    }


    public String getNumeroTelefono() {
        return numeroTelefono;
    }
}
