package lectmocity.modelo;

public class EstadoDisponible implements EstadoLibro {

    @Override
    public void prestar(Libro libro) {
        libro.setEstado(new EstadoPrestado());
        System.out.println("El libro fue prestado correctamente.");
    }

    @Override
    public void devolver(Libro libro) {
        System.out.println("El libro ya se encuentra disponible.");
    }

    @Override
    public void reservar(Libro libro) {
        libro.setEstado(new EstadoReservado());
        System.out.println("El libro fue reservado correctamente.");
    }

    @Override
    public String obtenerEstado() {
        return "Disponible";
    }
}