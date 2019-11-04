package Unidades;

import Unidades.Posicion.Posicion;

public class Jinete extends UnidadMovible {

    private Arma armaDeAtaque;


    public Jinete(int fila, int columna,String unNombreDeJugador) {
        this.costo = 3;
        this.vida = 100;
        this.posicion = new Posicion(fila,columna);
        this.ejercito = unNombreDeJugador;
        armaDeAtaque = new Espada();
    }

    public void atacar(Unidad enemigo){

        armaDeAtaque.atacar(enemigo);
    }

    public void cambiarArmaAEspada(){
        armaDeAtaque = new Espada();
    }

    public void cambiarArmaAArcoYFlecha(){
        armaDeAtaque = new ArcoYFlecha();
    }
}
