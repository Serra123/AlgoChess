package Unidades;

import Excepciones.ExcepcionAtaqueAAliado;
import Excepciones.ExcepcionAtaqueFueraDeRango;
import Unidades.Posicion.Posicion;


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

    public void atacar(Unidad unidadEnemiga){
        if(this.esAliado(unidadEnemiga)){
            throw new ExcepcionAtaqueAAliado();
        }
        if(this.puedeAtacar(unidadEnemiga)){
            armaDeAtaque.atacar(unidadEnemiga);
        }else throw new ExcepcionAtaqueFueraDeRango();
    }

    public boolean puedeAtacar(Unidad unidadEnemiga){
        return this.armaDeAtaque.puedeAtacar(this.posicion,unidadEnemiga.getPosicion());
    }

    public void cambiarArmaAEspada(){
        armaDeAtaque = new Espada();
    }

    public void cambiarArmaAArcoYFlecha(){
        armaDeAtaque = new ArcoYFlecha();
    }
}
