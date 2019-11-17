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

        ArrayList<Posicion> nuevasPosiciones = new ArrayList<>();
        for (UnidadMovible soldado : soldados) {

            Posicion nuevaPosicion = soldado.getPosicion().calcularNuevaPosicionRespectoDe(posicionCentralNueva, posicionCentralVieja);
            nuevasPosiciones.add(nuevaPosicion);
            /*try {
                soldado.mover(nuevaPosicion, unTablero);
            } catch (ExcepcionCasilleroOcupado e) {
                //no hago nada,si tira esta excepcion esta bien que no lo mueva.
            }*/
        }
        moverSoldados(nuevasPosiciones,0);
    }


    public void moverSoldados(ArrayList<Posicion> nuevasPosiciones,int soldadoActual){

        boolean mismaPosicionConDos = nuevasPosiciones.get(soldadoActual).calcularDistancia(soldados.get(1).getPosicion()) == 0;
        boolean mismaPosicionConTres = nuevasPosiciones.get(soldadoActual).calcularDistancia(soldados.get(2).getPosicion()) == 0;

        if(mismaPosicionConDos && soldadoActual!=1){
            moverSoldados(nuevasPosiciones,1);
        }
        else if(mismaPosicionConTres && soldadoActual!=2){
            moverSoldados(nuevasPosiciones,2);
        }
        moverUnSoldado(nuevasPosiciones,soldadoActual);
        if(soldadoActual<2){
            moverSoldados(nuevasPosiciones,soldadoActual+1);
        }

    }

    public void moverUnSoldado(ArrayList<Posicion> nuevasPosiciones,int soldadoActual){
        try{
            soldados.get(soldadoActual).mover(nuevasPosiciones.get(soldadoActual),unTablero);
        }
        catch (ExcepcionCasilleroOcupado e){
            //no hago nada,si tira esta excepcion esta bien que no lo mueva.
        }
    }

}
