package Vistas;

import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.Unidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CrearUnidadEventHandler implements EventHandler<ActionEvent> {

    private String unidadElegida;
    private VBox opcionesParaCrearUnidades;
    private Tablero tablero;
    private Posicion posicionClickeada;

    public CrearUnidadEventHandler(String unidadElegida, Tablero tablero, VBox opcionesParaCrearUnidades, Posicion posicionClickeada) {

        this.tablero = tablero;
        this.unidadElegida = unidadElegida;
        this.opcionesParaCrearUnidades = opcionesParaCrearUnidades;
        this.posicionClickeada = posicionClickeada;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        int fila = posicionClickeada.getFila()+1;
        int columna = posicionClickeada.getColumna()+1;

        Label opcionElegida = new Label();
        opcionElegida.setText("Crear "+unidadElegida+"\n en: ("+fila+";"+columna+")");
        opcionesParaCrearUnidades.getChildren().add(opcionElegida);

    }
}
