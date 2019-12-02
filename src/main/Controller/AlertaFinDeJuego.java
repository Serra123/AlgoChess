package Controller;

import javafx.scene.control.Alert;
import javafx.scene.layout.Region;

public class AlertaFinDeJuego extends Alert {
    public AlertaFinDeJuego(String nombreGanador) {
        super(Alert.AlertType.INFORMATION);
        this.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        this.setTitle("Fin del juego");
        this.setHeaderText("Tenemos un ganador!");
        this.setContentText("Felicitaciones " + nombreGanador + ", eres el ganador del AlgoChess!!!");
        this.showAndWait();
    }
}
