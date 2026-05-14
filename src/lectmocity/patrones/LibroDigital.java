package lectmocity.patrones;

public class LibroDigital {

    private String nombreArchivo;
    private String autorDigital;

    public LibroDigital(String nombreArchivo, String autorDigital) {
        this.nombreArchivo = nombreArchivo;
        this.autorDigital = autorDigital;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public String getAutorDigital() {
        return autorDigital;
    }
}