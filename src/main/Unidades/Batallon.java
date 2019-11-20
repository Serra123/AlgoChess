package Unidades;

import Excepciones.*;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;

import java.util.ArrayList;

public class Batallon {

    private ArrayList<UnidadMovible> soldados;
    private UnidadMovible soldadoCentral;
    private Tablero unTablero;

    public Batallon(ArrayList<UnidadMovible> listaSoldados, Tablero unTablero){
        agregarSoldados(listaSoldados);
        this.soldadoCentral = this.getSoldadoCentral();
        this.unTablero = unTablero;
        soldadosEstanContiguos();
        soldadosPertenecenAlMismoEjercito();
        unidadesSonSoldados();
    }

    private void agregarSoldados(ArrayList<UnidadMovible> listaSoldados) throws ExcepcionCantidadInsuficienteDeSoldados{
        if(listaSoldados.size()<3){
            throw new ExcepcionCantidadInsuficienteDeSoldados();
        }
        else{
            this.soldados = new ArrayList<>();
            for(int i=0;i<3;i++){
                this.soldados.add(listaSoldados.get(i));
            }
        }
    }

    private void soldadosEstanContiguos() throws ExcepcionLasUnidadesEstanSeparadas {
        for(int i=0;i<soldados.size();i++){
            int cantidadPosicionesSeparadas = 0;
            for (UnidadMovible soldado : soldados) {
                double distanciaAPosicionActual = soldados.get(i).distanciaA(soldado);
                if (distanciaAPosicionActual >= 2) {
                    cantidadPosicionesSeparadas++;
                }
            }
            if (cantidadPosicionesSeparadas>1) {
                throw new ExcepcionLasUnidadesEstanSeparadas();
            }
        }
    }

    private void soldadosPertenecenAlMismoEjercito() throws ExcepcionSoldadosNoPerteneceATuEjercito {
        if( !(soldados.get(0).esAliado(soldados.get(1)) & soldados.get(1).esAliado(soldados.get(2))) ){
            throw new ExcepcionSoldadosNoPerteneceATuEjercito();
        }
    }
    private void unidadesSonSoldados() throws ExcepcionTipoUnidadInvalida {
        for (UnidadMovible soldado : soldados) {
            if (!(soldado instanceof Soldado)) {
                throw new ExcepcionTipoUnidadInvalida();
            }
        }
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
        validarPosicionNueva(posicionCentralNueva,posicionCentralVieja);
        ArrayList nuevasPosiciones = calcularPosicionesNuevas(posicionCentralNueva,posicionCentralVieja);
        moverSoldados(nuevasPosiciones,0);
    }
    public void validarPosicionNueva(Posicion posicionCentralNueva,Posicion posicionCentralVieja) throws ExcepcionMovimientoInvalido {
        if (posicionCentralNueva.calcularDistancia(posicionCentralVieja)>1.5){
            throw new ExcepcionMovimientoInvalido();
        }
    }
    private ArrayList calcularPosicionesNuevas(Posicion posicionCentralNueva,Posicion posicionCentralVieja){
        ArrayList<Posicion> nuevasPosiciones = new ArrayList<>();
        for (UnidadMovible soldado : soldados) {
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
        catch (ExcepcionCasilleroOcupado e){
            //no hago nada,si tira esta excepcion esta bien que no lo mueva.
        }
    }

}
