package Unidades;

import Excepciones.ExcepcionAtaqueAAliado;
import Excepciones.ExcepcionDistanciaAtaqueInvalida;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;

public class Soldado extends UnidadMovible {

    private static final int DANIOCUERPOACUERPO = 10;
    private static final int VIDAINICIAL = 100;
    private static final int COSTO = 1;
    private static final int DISTANCIACORTA = 2;

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

    @Override
    public void atacar(Unidad unidadEnemiga, Tablero unTablero){
        boolean enemigoEstaEnSuSector = unTablero.estaEnSector(unidadEnemiga);
        if(this.esAliado(unidadEnemiga)){
            throw new ExcepcionAtaqueAAliado();
        }
        else if(this.posicion.calcularDistancia(unidadEnemiga.getPosicion()) > DISTANCIACORTA){
            throw new ExcepcionDistanciaAtaqueInvalida();
        }
        else {
            unidadEnemiga.recibirAtaque(DANIOCUERPOACUERPO, enemigoEstaEnSuSector);
        }
    }

    @Override
    public String getTipoUnidad(){
        return "soldado";
    }
}
