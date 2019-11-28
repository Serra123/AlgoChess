package Vistas;

import Unidades.Posicion.Posicion;
import javafx.scene.control.Button;

public class BotonCasillero extends Button {

    private Posicion posicion;

    public BotonCasillero(Posicion unaPosicion){
        this.posicion = unaPosicion;

    }


}
