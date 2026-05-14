package lectmocity.patrones;

public class ConexionBD {

    private static ConexionBD instancia;

    private ConexionBD() {
    }

    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    public void conectar() {
        System.out.println("Conexión establecida con la base de datos de LectMoCity.");
    }
}