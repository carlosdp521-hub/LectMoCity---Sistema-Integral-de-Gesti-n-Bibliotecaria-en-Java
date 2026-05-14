package lectmocity.patrones;

import java.time.LocalDate;

public class CalculoFechaDocente implements CalculoFechaDevolucion {

    @Override
    public LocalDate calcularFecha() {
        return LocalDate.now().plusDays(15);
    }
}