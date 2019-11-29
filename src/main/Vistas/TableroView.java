package Vistas;

import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import javafx.scene.layout.GridPane;

public class TableroView extends GridPane {

    private static int LADO = 20;

    private BotonCasillero [][] botonCasillero= new BotonCasillero[LADO][LADO];

    public TableroView(Tablero tablero, InfoCasillero infoCasillero, Jugador jugadorUno, Jugador jugadorDos){
        for(int i = 0; i < LADO; i++){
            for(int j = 0; j < LADO;j++){
                Posicion unaPosicion = new Posicion(i,j);
                botonCasillero[i][j] = new BotonCasillero(tablero,unaPosicion,infoCasillero, jugadorUno, jugadorDos);
                this.add(botonCasillero[i][j],j,i);
            }
        }
    }

    public void actualizar(){
        for(int i = 0; i < LADO; i++){
            for(int j = 0; j < LADO;j++){
                botonCasillero[i][j].fire();
            }
        }
    }

    public void mostrar(Posicion unaPosicion) {
        botonCasillero[unaPosicion.getFila()][unaPosicion.getColumna()].fire();
    }
}
