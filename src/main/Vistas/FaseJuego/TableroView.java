package Vistas.FaseJuego;

import Unidades.Posicion.Posicion;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class TableroView extends GridPane {

    private static final int LADO = 20;
    private static final String NARANJAOSCURO = "-fx-background-color:  #a04000;";
    private static final String BORDO = "-fx-background-color:    #6e2c00;";

    private BotonCasillero[][] botonesCasillero = new BotonCasillero[LADO][LADO];

    public TableroView(JuegoPrincipal faseDeJuegoDelTablero){

        for(int i = 0; i < LADO; i++){
            for(int j = 0; j < LADO;j++){
                Posicion unaPosicion = new Posicion(i,j);
                if(i<LADO/2){
                    botonesCasillero[i][j] = new BotonCasillero(faseDeJuegoDelTablero,unaPosicion, BORDO);
                    botonesCasillero[i][j].getStyleClass().add("botonCasillero");
                }else{
                    botonesCasillero[i][j] = new BotonCasillero(faseDeJuegoDelTablero,unaPosicion, NARANJAOSCURO);
                    botonesCasillero[i][j].getStyleClass().add("botonCasillero1");
                }
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

    public void agregarCasillerosClickeadosALista(ArrayList<Posicion> listaPosiciones) {
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
