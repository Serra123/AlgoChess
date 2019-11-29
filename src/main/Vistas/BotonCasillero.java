package Vistas;

import Controller.CasilleroEventHandler;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import javafx.scene.control.Button;

public class BotonCasillero extends Button {

    private Posicion posicion;

    public BotonCasillero(Tablero tablero, Posicion unaPosicion, InfoCasillero infoCasillero){
        this.posicion = unaPosicion;
        this.setPrefSize(50,30);
        this.setOnAction(new CasilleroEventHandler(tablero,unaPosicion,infoCasillero,this));

    }


}
