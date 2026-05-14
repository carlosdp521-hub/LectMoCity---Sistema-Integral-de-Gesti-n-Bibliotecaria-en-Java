package lectmocity.modelo;

public interface EstadoLibro {
    void prestar(Libro libro);
    void devolver(Libro libro);
    void reservar(Libro libro);
    String obtenerEstado();
}