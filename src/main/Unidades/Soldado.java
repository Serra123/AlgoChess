package Unidades;

import Excepciones.ExcepcionAtaqueAAliado;
import Unidades.Posicion.Posicion;

public class Soldado extends UnidadMovible {

    private static int DANIOCUERPOACUERPO = 10;
    private static int VIDAINICIAL = 100;
    private static int COSTO = 1;

    @Override
    public boolean candidatoABatallonEn(Posicion unaPosicion) {
        return (this.posicion.equals(unaPosicion));
    }

    public Soldado(Posicion unaPosicion, String unNombreDeJugador) {
        super(unaPosicion);
        this.vida = VIDAINICIAL;
        this.vidaMaxima = VIDAINICIAL;
        this.costo = COSTO;
        this.posicion = unaPosicion;
        ejercito = unNombreDeJugador;
    }

    public void atacar(Unidad unidadEnemiga){
        if(this.esAliado(unidadEnemiga)){
            throw new ExcepcionAtaqueAAliado();
        }
        unidadEnemiga.recibirAtaque(DANIOCUERPOACUERPO);
    }
}
