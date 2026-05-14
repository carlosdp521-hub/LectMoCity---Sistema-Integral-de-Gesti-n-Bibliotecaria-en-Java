package lectmocity.patrones;

public class ServicioBibliotecaReal implements ServicioBiblioteca {

    @Override
    public void eliminarLibro(int idLibro) {
        System.out.println("Libro con ID " + idLibro + " eliminado del sistema.");
    }
}