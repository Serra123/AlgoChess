package Unidades;

import Unidades.Posicion.Posicion;

public class Jinete extends UnidadMovible {

    private Arma armaDeAtaque;

    public Jinete(int fila, int columna,String unNombreDeJugador) {
        super(fila,columna);
        this.costo = 3;
        this.vida = 100;
        this.ejercito = unNombreDeJugador;
        armaDeAtaque = new Espada();
    }

    public void atacar(Unidad unaUnidad){
        if(this.esAliado(unaUnidad)){
            throw new RuntimeException("No podes atacar a un aliado");
        }
        armaDeAtaque.atacar(unaUnidad);
    }

    public void cambiarArmaAEspada(){
        armaDeAtaque = new Espada();
    }

    public void cambiarArmaAArcoYFlecha(){
        armaDeAtaque = new ArcoYFlecha();
    }
}
