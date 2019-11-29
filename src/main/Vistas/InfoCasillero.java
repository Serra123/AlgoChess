package Vistas;

import Excepciones.ExcepcionCasilleroVacio;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import javafx.scene.control.Label;

public class InfoCasillero extends Label{

    public InfoCasillero(String texto){
        this.setText(texto);
    }

    public void actualizarPosicionClickeada(String texto) {
        this.setText(texto);
    }
}
