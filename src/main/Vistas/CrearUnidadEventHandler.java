package Vistas;

import Tablero.Tablero;
import Unidades.Unidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CrearUnidadEventHandler implements EventHandler<ActionEvent> {

    String unidadElegida;
    VBox opcionesParaCrearUnidades;

    public CrearUnidadEventHandler(String unidadElegida, Tablero tablero, VBox opcionesParaCrearUnidades) {

        this.unidadElegida = unidadElegida;
        this.opcionesParaCrearUnidades = opcionesParaCrearUnidades;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Label opcionElegida = new Label();
        opcionElegida.setText("Usted eleigio crear: "+unidadElegida);
        opcionesParaCrearUnidades.getChildren().add(opcionElegida);

    }
}
