package lectmocity.patrones;

import java.util.ArrayList;
import java.util.List;

public class InventarioObservable {

    private List<ObservadorInventario> observadores = new ArrayList<>();

    public void agregarObservador(ObservadorInventario observador) {
        observadores.add(observador);
    }

    public void notificar(String mensaje) {
        for (ObservadorInventario observador : observadores) {
            observador.actualizar(mensaje);
        }
    }
}