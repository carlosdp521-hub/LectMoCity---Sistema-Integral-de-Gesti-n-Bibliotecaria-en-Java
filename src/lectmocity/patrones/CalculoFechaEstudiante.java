package lectmocity.patrones;

import java.time.LocalDate;

public class CalculoFechaEstudiante implements CalculoFechaDevolucion {

    @Override
    public LocalDate calcularFecha() {
        return LocalDate.now().plusDays(7);
    }
}