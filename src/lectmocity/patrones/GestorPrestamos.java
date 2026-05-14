package lectmocity.patrones;

public class GestorPrestamos {

    private static GestorPrestamos instancia;

    private GestorPrestamos() {
    }

    public static GestorPrestamos getInstancia() {
        if (instancia == null) {
            instancia = new GestorPrestamos();
        }
        return instancia;
    }

    public void registrarOperacion(String mensaje) {
        System.out.println("[Gestor de préstamos]: " + mensaje);
    }
}