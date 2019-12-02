package Controller;

import javafx.scene.control.Alert;
import javafx.scene.layout.Region;

public class AlertaErrorNombreDeJugador extends Alert {

    public AlertaErrorNombreDeJugador() {
        super(Alert.AlertType.INFORMATION);
        this.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        this.setTitle("Error en los nombres de los Jugadores");
        this.setHeaderText("Recuerda que los nombres tiene que cumplir 2 condiciones");
        this.setContentText("1) Los nombres no pueden ser iguales \n" + "2) Los nombres no pueden estar vacíos");

        this.showAndWait();
    }
}
