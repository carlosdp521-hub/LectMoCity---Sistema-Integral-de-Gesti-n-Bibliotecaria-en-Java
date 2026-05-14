package lectmocity.patrones;

import lectmocity.modelo.Libro;

public class AdaptadorLibroDigital extends Libro {

    public AdaptadorLibroDigital(int id, LibroDigital libroDigital) {
        super(id, libroDigital.getNombreArchivo(), libroDigital.getAutorDigital());
    }
}