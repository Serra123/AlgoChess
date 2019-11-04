package Unidades;

import Unidades.Posicion.Posicion;

public class Soldado extends UnidadMovible {

    private int danioCuerpoACuerpo;

    public Soldado(int fila,int columna, String unNombreDeJugador) {
        danioCuerpoACuerpo = 10;
        vida = 100;
        costo = 1;
        this.posicion = new Posicion(fila,columna);
        ejercito = unNombreDeJugador;
    }

    public void atacar(Unidad unidadEnemiga){
        unidadEnemiga.recibirAtaque(danioCuerpoACuerpo);
    }
}
