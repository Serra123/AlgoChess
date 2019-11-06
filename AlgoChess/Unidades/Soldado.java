package Unidades;

import Unidades.Posicion.Posicion;

public class Soldado extends UnidadMovible {

    private int danioCuerpoACuerpo;

    public Soldado(Posicion unaPosicion, String unNombreDeJugador) {
        super(unaPosicion);
        danioCuerpoACuerpo = 10;
        vida = 100;
        costo = 1;
        this.posicion = unaPosicion;
        ejercito = unNombreDeJugador;
    }

    public void atacar(Unidad unidadEnemiga){
        if(this.esAliado(unidadEnemiga)){
            throw new RuntimeException("No podes atacar a una unidad aliada");
        }
        unidadEnemiga.recibirAtaque(danioCuerpoACuerpo);
    }
}
