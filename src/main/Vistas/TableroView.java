package Vistas;

import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import javafx.scene.layout.GridPane;

public class TableroView extends GridPane {

    private static final int LADO = 20;

    private BotonCasillero [][] botonesCasillero = new BotonCasillero[LADO][LADO];

    public TableroView(Tablero tablero, InfoCasillero infoCasillero, Jugador jugadorUno, Jugador jugadorDos){
        for(int i = 0; i < LADO; i++){
            for(int j = 0; j < LADO;j++){
                Posicion unaPosicion = new Posicion(i,j);
                botonesCasillero[i][j] = new BotonCasillero(tablero, unaPosicion, infoCasillero, jugadorUno, jugadorDos);
                this.add(botonesCasillero[i][j],j,i);
            }
        }
    }

    public void actualizar(){
        for(int i = 0; i < LADO; i++){
            for(int j = 0; j < LADO;j++){
                botonesCasillero[i][j].fire();
            }
        }
    }

    public void mostrar(Posicion unaPosicion) {
        botonesCasillero[unaPosicion.getFila()][unaPosicion.getColumna()].fire();
    }
}
