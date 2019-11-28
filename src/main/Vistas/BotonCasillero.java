package Vistas;

import Controller.CasilleroEventHandler;
import Unidades.Posicion.Posicion;
import javafx.scene.control.Button;

public class BotonCasillero extends Button {

    private Posicion posicion;

    public BotonCasillero(Posicion unaPosicion,InfoTablero infoTablero){
        this.posicion = unaPosicion;
        this.setPrefSize(50,30);
        this.setOnAction(new CasilleroEventHandler(unaPosicion,infoTablero));

    }


}
