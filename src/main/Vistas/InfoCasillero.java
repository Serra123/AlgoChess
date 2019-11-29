package Vistas;

import Unidades.Posicion.Posicion;
import javafx.scene.control.Label;

public class InfoCasillero extends Label{

    private Posicion posicion;

    public InfoCasillero(String texto){
        this.setText(texto);
    }

    public void actualizarPosicionClickeada(String texto, Posicion unaPosicion) {

        this.setText(texto);
        this.posicion = unaPosicion;
    }

    public Posicion getPosicion(){

        return new Posicion(posicion);
    }
}
