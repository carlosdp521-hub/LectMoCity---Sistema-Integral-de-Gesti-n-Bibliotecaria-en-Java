package lectmocity;

import lectmocity.vista.VentanaPrincipal2;

public class Main2 {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            VentanaPrincipal2 ventana = new VentanaPrincipal2();
            ventana.iniciar();
        });
    }
}