package Vistas;

import Unidades.Posicion.Posicion;
import javafx.scene.control.Label;

public class InfoCasillero extends Label{
    Posicion posicion;
    public InfoCasillero(String texto){
        this.setText(texto);
    }

    public void actualizarPosicionClickeada(Posicion posicion) {
        this.posicion=posicion;
        this.setText("("+(posicion.getFila()+1)+";"+(posicion.getColumna()+1)+")");
    }
}
