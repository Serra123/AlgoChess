package Unidades;

import Unidades.Posicion.Posicion;

import java.util.ArrayList;

public class Batallon {

    private ArrayList<Unidad> soldados;
    private Unidad soldadoCentral;


    public Batallon(ArrayList<Unidad> soldados){
        this.soldados = soldados;
        this.soldadoCentral = this.getSoldadoCentral();
    }

    public Unidad getSoldadoCentral(){

        double distanciaMin = 100;
        Unidad soldadoCentral = soldados.get(1);
        for(int i=0;i<soldados.size();i++){
            double distanciaSoldado = 0;
            for (Unidad soldado : soldados) {
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
        for (Unidad soldado : soldados) {
            soldado.getPosicion().mantenerDistanciaARespectoDe(posicionCentralNueva, posicionCentralVieja);
        }
    }
}
