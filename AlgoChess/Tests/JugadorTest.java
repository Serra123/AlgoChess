package Tests;

import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import org.junit.Test;

public class JugadorTest {
    @Test
    public void jugadorNoPuedeCrearUnidadesCuandoSeQuedaSinPuntos(){
        Tablero.setParametrosConsigna();
        Tablero unTablero = Tablero.getInstancia();
        Jugador unJugador = new Jugador("Jugador1");
        Posicion posicionUno = new Posicion(8,1);
        Posicion posicionDos = new Posicion(8,2);
        Posicion posicionTres = new Posicion(8,3);
        Posicion posicionCuatro = new Posicion(8,4);
        Posicion posicionCinco = new Posicion(8,5);
        unJugador.crearUnidadEnPosicion(posicionUno,"Catapulta");
        unJugador.crearUnidadEnPosicion(posicionDos,"Catapulta");
        unJugador.crearUnidadEnPosicion(posicionTres,"Catapulta");
        unJugador.crearUnidadEnPosicion(posicionCuatro,"Catapulta");
        try{
            unJugador.crearUnidadEnPosicion(posicionCinco,"Catapulta");
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
}
