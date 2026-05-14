package lectmocity.modelo;

public class EstadoPrestado implements EstadoLibro {

    @Override
    public void prestar(Libro libro) {
        System.out.println("No se puede prestar. El libro ya está prestado.");
    }

    @Override
    public void devolver(Libro libro) {
        libro.setEstado(new EstadoDisponible());
        System.out.println("El libro fue devuelto correctamente.");
    }

    @Override
    public void reservar(Libro libro) {
        System.out.println("No se puede reservar. El libro está prestado.");
    }

    @Override
    public String obtenerEstado() {
        return "Prestado";
    }
}