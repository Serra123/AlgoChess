package Vistas;

import Controller.CasilleroEventHandler;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import javafx.scene.control.Button;

public class BotonCasillero extends Button {

    private Tablero tablero;
    private Posicion posicion;
    private Jugador jugadorUno;
    private Jugador jugadorDos;

    public BotonCasillero(Tablero tablero, Posicion unaPosicion, InfoCasillero infoCasillero, Jugador jugadorUno, Jugador jugadorDos){
        this.tablero = tablero;
        this.posicion = unaPosicion;
        this.jugadorUno = jugadorUno;
        this.jugadorDos = jugadorDos;
        this.setPrefSize(50,30);
        this.setOnAction(new CasilleroEventHandler(tablero,unaPosicion,infoCasillero,this,jugadorUno,jugadorDos));
    }

    public void actualizar(){

    }

}
