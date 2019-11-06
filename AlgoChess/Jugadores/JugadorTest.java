package Jugadores;

import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import org.junit.Test;

public class JugadorTest {
    @Test
    public void jugadorNoPuedeCrearUnidadesCuandoSeQuedaSinPuntos(){
        Jugador unJugador = new Jugador("juan");
        Posicion unaPosicion = new Posicion(0,1);
        Tablero unTablero = new Tablero(10,10,"juan","Jugador2");
        unJugador.crearCatapultaEnPosicion(unaPosicion,unTablero);
        unJugador.crearCatapultaEnPosicion(unaPosicion,unTablero);
        unJugador.crearCatapultaEnPosicion(unaPosicion,unTablero);
        unJugador.crearCatapultaEnPosicion(unaPosicion,unTablero);
        try{
            unJugador.crearCatapultaEnPosicion(unaPosicion,unTablero);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
            //manejar excepcion
        }
    }

    @Test
    public void jugadorSinUnidadesIntentaJugarYPierde(){
        Jugador unJugador = new Jugador("juan");
        try{
            unJugador.jugarTurno();
        } catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
