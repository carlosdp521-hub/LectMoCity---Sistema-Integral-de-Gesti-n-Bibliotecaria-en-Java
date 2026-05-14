package lectmocity.modelo;

import java.time.LocalDate;

public class Prestamo {

    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(Libro libro, Usuario usuario, LocalDate fechaDevolucion) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Libro: " + libro.getTitulo()
                + " | Usuario: " + usuario.getNombre()
                + " | Fecha préstamo: " + fechaPrestamo
                + " | Fecha devolución: " + fechaDevolucion;
    }
}