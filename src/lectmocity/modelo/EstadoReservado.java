package lectmocity.modelo;

public class EstadoReservado implements EstadoLibro {

    @Override
    public void prestar(Libro libro) {
        libro.setEstado(new EstadoPrestado());
        System.out.println("El libro reservado fue prestado correctamente.");
    }

    @Override
    public void devolver(Libro libro) {
        libro.setEstado(new EstadoDisponible());
        System.out.println("El libro reservado quedó disponible.");
    }

    @Override
    public void reservar(Libro libro) {
        System.out.println("El libro ya se encuentra reservado.");
    }

    @Override
    public String obtenerEstado() {
        return "Reservado";
    }
}