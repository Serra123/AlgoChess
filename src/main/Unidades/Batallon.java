package Unidades;

import Excepciones.*;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;

import java.util.ArrayList;

public class Batallon {

    private ArrayList<Soldado> soldados;
    private UnidadMovible soldadoCentral;
    private Tablero unTablero;

    public Batallon(ArrayList<Soldado> listaSoldados){
        this.soldados = listaSoldados;
        this.soldadoCentral = this.getSoldadoCentral();
    }
    public void agregarTablero(Tablero unTablero){
        this.unTablero = unTablero;
    }
    public int getCantidadSoldados(){
        return soldados.size();
    }

    private UnidadMovible getSoldadoCentral(){
        double distanciaMin = 100;
        UnidadMovible soldadoCentral = soldados.get(1);
        for(int i=0;i<soldados.size();i++){
            double distanciaSoldado = 0;
            for (UnidadMovible soldado : soldados) {
                distanciaSoldado += soldados.get(i).distanciaA(soldado);
            }
            if(distanciaSoldado<distanciaMin){
                distanciaMin = distanciaSoldado;
                soldadoCentral=soldados.get(i);
            }
        }
        return soldadoCentral;
    }
    public void moverBatallon(Posicion posicionCentralNueva) {
        Posicion posicionCentralVieja = soldadoCentral.getPosicion();
        ArrayList nuevasPosiciones = calcularPosicionesNuevas(posicionCentralNueva,posicionCentralVieja);
        moverSoldados(nuevasPosiciones,0);
    }
    private ArrayList calcularPosicionesNuevas(Posicion posicionCentralNueva,Posicion posicionCentralVieja){
        ArrayList<Posicion> nuevasPosiciones = new ArrayList<>();
        for (Soldado soldado : soldados) {
            Posicion nuevaPosicion = soldado.getPosicion().calcularNuevaPosicionRespectoDe(posicionCentralNueva, posicionCentralVieja);
            nuevasPosiciones.add(nuevaPosicion);
        }
        return nuevasPosiciones;
    }
    private void moverSoldados(ArrayList<Posicion> nuevasPosiciones,int soldadoActual){
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
    private void moverUnSoldado(ArrayList<Posicion> nuevasPosiciones,int soldadoActual){
        try{
            soldados.get(soldadoActual).mover(nuevasPosiciones.get(soldadoActual),unTablero);
        }
        catch (ExcepcionCasilleroOcupado | ExcepcionMovimientoInvalido e){
            //no hago nada,si tira esta excepcion esta bien que no lo mueva.
        }
    }

}
