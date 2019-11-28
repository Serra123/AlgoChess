package Vistas;

import Unidades.Posicion.Posicion;
import javafx.scene.control.Label;

public class InfoTablero extends Label{
    public InfoTablero(String texto){
        this.setText(texto);
    }

    public void actualizarPosicionClickeada(Posicion posicion) {
        this.setText("("+(posicion.getFila()+1)+";"+(posicion.getColumna()+1)+")");
    }
}
