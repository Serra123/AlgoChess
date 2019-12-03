package Controller;

import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class AlertaFinDeJuego extends Alert {
    public AlertaFinDeJuego(String nombreGanador, Stage unaVentana) {
        super(Alert.AlertType.INFORMATION);
        this.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        this.setTitle("Fin del juego");
        this.setHeaderText("Tenemos un ganador!");
        this.setContentText("Felicitaciones " + nombreGanador + ", eres el ganador del AlgoChess!!!");
        this.setOnCloseRequest(e-> unaVentana.close());
        this.showAndWait();
    }
}
