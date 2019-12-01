package Vistas.FaseJuego;

import Controller.CasilleroEventHandler;
import Controller.CasilleroParaBatallonEventHandler;
import Unidades.Posicion.Posicion;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class BotonCasillero extends Button {

    private JuegoPrincipal faseDeJuego;
    private Posicion posicion;


    BotonCasillero(JuegoPrincipal faseDeJuego, Posicion unaPosicion){
        this.faseDeJuego = faseDeJuego;
        this.posicion = unaPosicion;
        this.setPrefSize(50,34);
        this.setStyle("-fx-background-image: url('fondoCasillero.jpg')");
        this.setOnAction(new CasilleroEventHandler(faseDeJuego,unaPosicion,this));
    }

    public void cambiarEventHandlerParaCrearBatallon(ArrayList<Posicion> listaPosiciones) {
        this.setOnAction(new CasilleroParaBatallonEventHandler(faseDeJuego,posicion,this,listaPosiciones));
    }

    public void resetarEventHandler() {
        this.setOnAction(new CasilleroEventHandler(faseDeJuego,posicion,this));
    }
}
