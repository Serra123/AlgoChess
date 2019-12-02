package Controller;

import javafx.scene.control.Alert;

public class AlertaErrorEnCreacionDeUnidad extends Alert {
    public AlertaErrorEnCreacionDeUnidad(String cabecera, String contenido) {
        super(Alert.AlertType.INFORMATION);
        this.setTitle("ERROR");
        this.setHeaderText(cabecera);
        this.setContentText(contenido);
        this.showAndWait();

    }
}
