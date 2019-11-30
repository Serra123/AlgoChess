package Vistas;

import Controller.CasilleroEventHandler;
import Controller.CasilleroParaBatallonEventHandler;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class BotonCasillero extends Button {

    private Tablero tablero;
    private Posicion posicion;
    private InfoCasillero infoCasillero;
    private Jugador jugadorUno;
    private Jugador jugadorDos;


    BotonCasillero(Tablero tablero, Posicion unaPosicion, InfoCasillero infoCasillero, Jugador jugadorUno, Jugador jugadorDos){
        this.tablero = tablero;
        this.posicion = unaPosicion;
        this.infoCasillero = infoCasillero;
        this.jugadorUno = jugadorUno;
        this.jugadorDos = jugadorDos;
        this.setPrefSize(50,30);
        this.setOnAction(new CasilleroEventHandler(tablero,unaPosicion,infoCasillero,this,jugadorUno));
    }

    public void cambiarEventHandlerParaCrearBatallon(ArrayList listaPosiciones) {
        this.setOnAction(new CasilleroParaBatallonEventHandler(tablero,posicion,infoCasillero,this,jugadorUno,listaPosiciones));
        //this.setOnAction(); este set on action tiene que agregar la posicion clickeada hasta que apriete un boton listo
    }

    public void resetarEventHandler() {
        this.setOnAction(new CasilleroEventHandler(tablero,posicion,infoCasillero,this,jugadorUno));
    }
}
