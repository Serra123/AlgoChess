package Controller;

import javafx.scene.control.Alert;

public class ExcepcionCrearUnidadEventHandler extends Alert {
    public ExcepcionCrearUnidadEventHandler(String cabecera, String contenido) {
        super(Alert.AlertType.INFORMATION);
        this.setTitle("ERROR");
        this.setHeaderText(cabecera);
        this.setContentText(contenido);
        this.showAndWait();

    }
}
