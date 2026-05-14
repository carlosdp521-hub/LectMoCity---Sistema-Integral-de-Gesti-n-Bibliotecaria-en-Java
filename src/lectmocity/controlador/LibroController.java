package lectmocity.controlador;

import lectmocity.modelo.Libro;
import lectmocity.patrones.InventarioObservable;

import java.util.ArrayList;
import java.util.List;

public class LibroController {

    private List<Libro> libros;
    private InventarioObservable inventario;

    public LibroController(InventarioObservable inventario) {
        this.libros = new ArrayList<>();
        this.inventario = inventario;
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        inventario.notificar("Se agregó el libro: " + libro.getTitulo());
    }

    public Libro buscarLibroPorId(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }
}