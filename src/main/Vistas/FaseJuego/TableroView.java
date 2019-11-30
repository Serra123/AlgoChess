package Vistas.FaseJuego;

import Unidades.Posicion.Posicion;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class TableroView extends GridPane {

    private static final int LADO = 20;
    private JuegoPrincipal faseDeJuegoDelTablero; // referencia a la fase a la cual pertenece

    private BotonCasillero[][] botonesCasillero = new BotonCasillero[LADO][LADO];

    public TableroView(JuegoPrincipal faseDeJuegoDelTablero){
        this.faseDeJuegoDelTablero = faseDeJuegoDelTablero;

        for(int i = 0; i < LADO; i++){
            for(int j = 0; j < LADO;j++){
                Posicion unaPosicion = new Posicion(i,j);
                botonesCasillero[i][j] = new BotonCasillero(faseDeJuegoDelTablero,unaPosicion);
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

    public void agregarCasillerosClickeadosALista(ArrayList listaPosiciones) {
        for(int i = 0; i < LADO; i++){
            for(int j = 0; j < LADO;j++){
                botonesCasillero[i][j].cambiarEventHandlerParaCrearBatallon(listaPosiciones);
            }
        }
    }

    public void resetearComportamientoDeCasilleros() {
        for(int i = 0; i < LADO; i++){
            for(int j = 0; j < LADO;j++){
                botonesCasillero[i][j].resetarEventHandler();
            }
        }
    }
}
