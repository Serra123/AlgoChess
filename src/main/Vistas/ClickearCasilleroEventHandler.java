package Vistas;

import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.Unidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ClickearCasilleroEventHandler implements EventHandler<ActionEvent> {

    private Button boton;
    private Posicion posicionUserData;
    private Label infoUsuarioClickeado;
    private Posicion posicionClickeada;
    private Tablero tablero;

    public ClickearCasilleroEventHandler(Button boton, Tablero tablero, Label infoUsuarioClickeado, Posicion posicionClickeada) {
        //no puedo modificar el texto del boton desde acá asique ya fue,lo hago en juego principal
        this.posicionUserData = (Posicion) boton.getUserData();
        this.infoUsuarioClickeado =  infoUsuarioClickeado;
        this.posicionClickeada = posicionClickeada;
        this.tablero = tablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        boton.setText("aa");
        Unidad unidad;
        posicionClickeada=posicionUserData;
        int fila = posicionUserData.getFila()+1;
        int columna = posicionUserData.getColumna()+1;
        try {
            unidad = tablero.getUnidad(posicionUserData);
            infoUsuarioClickeado.setText("\n\n\nPosicion: ("+fila+";"+columna+")\nUnidad: "+unidad.getTipoUnidad()+"\nVida:"+unidad.getVida());
        }
        catch (RuntimeException e){
            infoUsuarioClickeado.setText("\n\n\nNo hay una unidad acá");
        }

    }
}
