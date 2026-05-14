package lectmocity.modelo;

public class Usuario {

    private int id;
    private String nombre;
    private String tipoUsuario;

    public Usuario(int id, String nombre, String tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " | Tipo: " + tipoUsuario;
    }
}