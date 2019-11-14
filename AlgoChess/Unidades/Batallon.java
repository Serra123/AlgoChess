package Unidades;

import Unidades.Posicion.Posicion;

import java.util.ArrayList;

public class Batallon {

    ArrayList<Soldado> soldados;
    Soldado soldadoCentral;


    public Batallon(ArrayList<Soldado> soldados){
        this.soldados = soldados;
        this.soldadoCentral = this.getSoldadoCentral();
    }

    public Soldado getSoldadoCentral(){

        double distanciaMin = 100;
        Soldado soldadoCentral = soldados.get(1);
        for(int i=0;i<soldados.size();i++){
            double distanciaSoldado = 0;
            for (int j=0;j<soldados.size();j++){
                distanciaSoldado+= soldados.get(i).getPosicion().calcularDistancia(soldados.get(j).getPosicion());
            }
            if(distanciaSoldado<distanciaMin){
                distanciaMin = distanciaSoldado;
                soldadoCentral=soldados.get(i);
            }
        }
        return soldadoCentral;

    }

    public void moverCentroA(Posicion posicionCentralNueva) {

        Posicion posicionCentralVieja = soldadoCentral.getPosicion();
        //soldadoCentral.actualizarPosicion(posicionCentralNueva);
        for (int i=0;i<soldados.size();i++){
            soldados.get(i).getPosicion().mantenerDistanciaARespectoDe(posicionCentralNueva,posicionCentralVieja);
        };
    }


}
