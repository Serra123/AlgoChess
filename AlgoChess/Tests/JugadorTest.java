package Tests;

import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

public class JugadorTest {
    @Test
    public void jugadorNoPuedeCrearUnidadesCuandoSeQuedaSinPuntos(){
        Jugador unJugador = new Jugador("juan");
        Posicion posicionUno = new Posicion(0,1);
        Posicion posicionDos = new Posicion(0,2);
        Posicion posicionTres = new Posicion(0,3);
        Posicion posicionCuatro = new Posicion(0,4);
        Posicion posicionCinco = new Posicion(0,5);
        Tablero unTablero = new Tablero(10,10,"juan","Jugador2");
        unJugador.crearUnidadEnPosicion(posicionUno,"Catapulta", unTablero);
        unJugador.crearUnidadEnPosicion(posicionDos,"Catapulta", unTablero);
        unJugador.crearUnidadEnPosicion(posicionTres,"Catapulta", unTablero);
        unJugador.crearUnidadEnPosicion(posicionCuatro,"Catapulta", unTablero);
        try{
            unJugador.crearUnidadEnPosicion(posicionCinco,"Catapulta", unTablero);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
            //manejar excepcion
        }
    }

   /* @Test
    public void jugadorSinUnidadesIntentaJugarYPierde(){
        Jugador unJugador = new Jugador("juan");
        try{
            unJugador.jugarTurno();
        } catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }*/

    @Test
    public void PosicionNuevaMantieneSuRelacionConAntigua(){
        Posicion unaPosicion = new Posicion(0,3);
        Posicion nuevaPosicionCentral = new Posicion(1,2);
        Posicion viejaPosicionCentral = new Posicion(0,2);
        Posicion unaPosicionNueva = new Posicion (1,3);
        unaPosicion.mantenerDistanciaARespectoDe(nuevaPosicionCentral,viejaPosicionCentral);
        boolean mismaFila = unaPosicionNueva.getFila()==unaPosicion.getFila();
        boolean mismaColumna = unaPosicionNueva.getColumna()==unaPosicion.getColumna();
        Assert.assertTrue( (mismaFila & mismaColumna) );
    }


}
