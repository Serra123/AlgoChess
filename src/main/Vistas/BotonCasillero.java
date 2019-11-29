package Vistas;

import Controller.CasilleroEventHandler;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import javafx.scene.control.Button;

public class BotonCasillero extends Button {

    BotonCasillero(Tablero tablero, Posicion unaPosicion, InfoCasillero infoCasillero, Jugador jugadorUno, Jugador jugadorDos){
        this.setPrefSize(50,30);
        this.setOnAction(new CasilleroEventHandler(tablero,unaPosicion,infoCasillero,this,jugadorUno));
    }

}
