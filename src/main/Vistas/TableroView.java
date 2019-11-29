package Vistas;

import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import javafx.scene.layout.GridPane;

public class TableroView extends GridPane {

    private static int FILAS = 20;
    private static int COLUMNAS = 20;


    public TableroView(Tablero tablero, InfoCasillero infoCasillero, Jugador jugadorUno, Jugador jugadorDos){
        for(int i = 0; i < FILAS; i++){
            for(int j = 0; j < COLUMNAS;j++){
                Posicion unaPosicion = new Posicion(i,j);
                this.add(new BotonCasillero(tablero,unaPosicion,infoCasillero, jugadorUno, jugadorDos),j,i);
            }
        }
    }
    //que va a ser una matriz de casilleros
}
