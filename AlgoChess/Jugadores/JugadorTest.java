package Jugadores;

import org.junit.Test;

public class JugadorTest {
    @Test
    public void jugadorNoPuedeCrearUnidadesCuandoSeQuedaSinPuntos(){
        Jugador unJugador = new Jugador("juan");
        unJugador.crearCatapultaEnPosicion(0,0);
        unJugador.crearCatapultaEnPosicion(0,0);
        unJugador.crearCatapultaEnPosicion(0,0);
        unJugador.crearCatapultaEnPosicion(0,0);
        try{
            unJugador.crearCatapultaEnPosicion(0,0);
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
