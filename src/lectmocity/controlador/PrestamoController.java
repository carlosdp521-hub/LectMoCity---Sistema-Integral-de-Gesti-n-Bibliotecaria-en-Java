package lectmocity.controlador;

import lectmocity.modelo.Libro;
import lectmocity.modelo.Prestamo;
import lectmocity.modelo.Usuario;
import lectmocity.patrones.*;

import java.util.ArrayList;
import java.util.List;

public class PrestamoController {

    private List<Prestamo> prestamos;
    private InventarioObservable inventario;

    public PrestamoController(InventarioObservable inventario) {
        this.prestamos = new ArrayList<>();
        this.inventario = inventario;
    }

    public void prestarLibro(Libro libro, Usuario usuario) {
        if (libro == null || usuario == null) {
            System.out.println("Libro o usuario no encontrado.");
            return;
        }

        CalculoFechaDevolucion estrategia;

        if (usuario.getTipoUsuario().equalsIgnoreCase("Docente")) {
            estrategia = new CalculoFechaDocente();
        } else {
            estrategia = new CalculoFechaEstudiante();
        }

        libro.prestar();

        Prestamo prestamo = new Prestamo(libro, usuario, estrategia.calcularFecha());
        prestamos.add(prestamo);

        GestorPrestamos.getInstancia().registrarOperacion("Préstamo registrado para " + usuario.getNombre());
        inventario.notificar("El libro '" + libro.getTitulo() + "' cambió a estado: " + libro.getEstado().obtenerEstado());
    }

    public void devolverLibro(Libro libro) {
        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        libro.devolver();
        inventario.notificar("El libro '" + libro.getTitulo() + "' fue devuelto.");
    }

    public void listarPrestamos() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
        } else {
            for (Prestamo prestamo : prestamos) {
                System.out.println(prestamo);
            }
        }
    }
}