package Unidades;

import Excepciones.ExcepcionAtaqueAAliado;
import Unidades.Posicion.Posicion;

import javax.swing.text.ViewFactory;

public class Jinete extends UnidadMovible {

    private static int COSTO = 3;
    private static int VIDAINICIAL = 100;

    private Arma armaDeAtaque;

    public Jinete(Posicion unaPosicion, String unNombreDeJugador) {
        super(unaPosicion);
        this.costo = COSTO;
        this.vida = VIDAINICIAL;
        this.vidaMaxima = VIDAINICIAL;
        this.ejercito = unNombreDeJugador;
        armaDeAtaque = new Espada();
    }

    public void atacar(Unidad unaUnidad){
        if(this.esAliado(unaUnidad)){
            throw new ExcepcionAtaqueAAliado();
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
