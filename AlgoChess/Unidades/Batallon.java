package Unidades;

import Excepciones.ExcepcionCasilleroOcupado;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;

import java.util.ArrayList;

public class Batallon {

    private ArrayList<UnidadMovible> soldados;
    private UnidadMovible soldadoCentral;
    private Tablero unTablero;

    public Batallon(ArrayList<UnidadMovible> soldados, Tablero unTablero){
        this.soldados = soldados;
        this.soldadoCentral = this.getSoldadoCentral();
        this.unTablero = unTablero;
    }

    public UnidadMovible getSoldadoCentral(){

        double distanciaMin = 100;
        UnidadMovible soldadoCentral = soldados.get(1);
        for(int i=0;i<soldados.size();i++){
            double distanciaSoldado = 0;
            for (UnidadMovible soldado : soldados) {
                distanciaSoldado += soldados.get(i).getPosicion().calcularDistancia(soldado.getPosicion());
            }
            if(distanciaSoldado<distanciaMin){
                distanciaMin = distanciaSoldado;
                soldadoCentral=soldados.get(i);
            }
        }
        return soldadoCentral;

    }

    public void moverCentroA(Posicion posicionCentralNueva) {
        Posicion posicionCentralVieja = new Posicion(soldadoCentral.getPosicion().getFila(),soldadoCentral.getPosicion().getColumna());
        for (UnidadMovible soldado : soldados) {

            Posicion nuevaPosicion = soldado.getPosicion().calcularNuevaPosicionRespectoDe(posicionCentralNueva, posicionCentralVieja);
            try{
                soldado.mover(nuevaPosicion,unTablero);
            }
            catch (ExcepcionCasilleroOcupado e){
                //no hago nada,si tira esta excepcion esta bien que no lo mueva.
            }
        }
    }
}
