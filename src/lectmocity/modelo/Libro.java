package lectmocity.modelo;

public class Libro {

    private int id;
    private String titulo;
    private String autor;
    private EstadoLibro estado;

    public Libro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.estado = new EstadoDisponible();
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public EstadoLibro getEstado() {
        return estado;
    }

    public void setEstado(EstadoLibro estado) {
        this.estado = estado;
    }

    public void prestar() {
        estado.prestar(this);
    }

    public void devolver() {
        estado.devolver(this);
    }

    public void reservar() {
        estado.reservar(this);
    }

    @Override
    public String toString() {
        return id + " - " + titulo + " | Autor: " + autor + " | Estado: " + estado.obtenerEstado();
    }
}