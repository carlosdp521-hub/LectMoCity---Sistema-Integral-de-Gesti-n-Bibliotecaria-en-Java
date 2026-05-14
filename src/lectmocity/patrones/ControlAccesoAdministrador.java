package lectmocity.patrones;

public class ControlAccesoAdministrador implements ServicioBiblioteca {

    private ServicioBibliotecaReal servicioReal;
    private String rolUsuario;

    public ControlAccesoAdministrador(String rolUsuario) {
        this.rolUsuario = rolUsuario;
        this.servicioReal = new ServicioBibliotecaReal();
    }

    @Override
    public void eliminarLibro(int idLibro) {
        if (rolUsuario.equalsIgnoreCase("Administrador")) {
            servicioReal.eliminarLibro(idLibro);
        } else {
            System.out.println("Acceso denegado. Solo un administrador puede eliminar libros.");
        }
    }
}