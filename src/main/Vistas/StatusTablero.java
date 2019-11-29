package Vistas;

import javafx.scene.layout.VBox;

public class StatusTablero extends VBox {
    InfoCasillero infoCasillero;


    public StatusTablero(InfoCasillero infoCasillero) {
        this.infoCasillero = infoCasillero;
        this.getChildren().add(new AgregarUnidades());
        this.getChildren().add(infoCasillero);
    }
}
