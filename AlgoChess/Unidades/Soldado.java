package Unidades;

import Excepciones.ExcepcionAtaqueAAliado;
import Excepciones.ExcepcionAtaqueFueraDeRango;
import Unidades.Posicion.Posicion;

public class Soldado extends UnidadMovible {

    private static int DANIOCUERPOACUERPO = 10;
    private static int VIDAINICIAL = 100;
    private static int COSTO = 1;
    private int danio;

    public Soldado(Posicion unaPosicion, String unNombreDeJugador) {
        super(unaPosicion);
        this.vida = VIDAINICIAL;
        this.vidaMaxima = VIDAINICIAL;
        this.costo = COSTO;
        this.danio = DANIOCUERPOACUERPO;
        this.posicion = unaPosicion;
        ejercito = unNombreDeJugador;
    }

    public void atacar(Unidad unidadEnemiga){
        if(this.esAliado(unidadEnemiga)){
            throw new ExcepcionAtaqueAAliado();
        }
        if(this.puedeAtacar(unidadEnemiga)){
            unidadEnemiga.recibirAtaque(danio);
        } else throw new ExcepcionAtaqueFueraDeRango();
    }

    public boolean puedeAtacar(Unidad unidadEnemiga){
        double distanciaAtaque = this.posicion.calcularDistancia(unidadEnemiga.getPosicion());
        return (distanciaAtaque <= 2);
    }

}
