package Tests;

import Excepciones.ExcepcionCasilleroVacio;
import Tablero.Tablero;
import Unidades.Jinete;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

public class JineteTest {

    @Test   //Todavía me queda modificar esta prueba en base a la nueva implementacion de Jinete. Fede.
    public void testJineteAtacaConEspadaASoldadoEnemigoCorrectamente(){
        Tablero unTablero = new Tablero(20,20,"Fede","Juan");

        Posicion unaPosicion = new Posicion(0,0);
        Jinete unJinete = new Jinete(unaPosicion,"");
        Soldado enemigo = new Soldado(unaPosicion,"Ejercito enemigo");

        unJinete.cambiarArmaAEspada();

        //unJinete.atacar(enemigo, );

        //Assert.assertEquals(95, enemigo.getVida());
    }

    @Test //Todavía me queda modificar esta prueba en base a la nueva implementacion de Jinete. Fede.
    public void testJineteAtacaConArcoYFlechaASoldadoEnemigoCorrectamente(){
        Posicion unaPosicion = new Posicion(0,0);
        Jinete unJinete = new Jinete(unaPosicion,"");
        Soldado unEnemigo = new Soldado(unaPosicion,"Ejercito enemigo");

        unJinete.cambiarArmaAArcoYFlecha();

//        unJinete.atacar(unEnemigo, );

       //Assert.assertEquals(85, unEnemigo.getVida());
    }
    @Test
    public void testJineteAtacaAJineteAliadoYSaltaExcepcion() {
        Tablero unTablero = new Tablero(20, 20, "Fede", "Juan");
        Posicion unaPosicion = new Posicion(0,0);
        Jinete unJinete = new Jinete(unaPosicion, "juan");
        Jinete otroJinete = new Jinete(unaPosicion, "juan");
        try {
         //  unJinete.atacar(otroJinete, );
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        //Assert.assertEquals(otroJinete.getVida(), 100);
    }

    @Test
    public void testJineteTieneSoldadoCercaAtacaConArcoYFlecha() throws ExcepcionCasilleroVacio {
        Posicion posicionJineteAliado = new Posicion(5,5);
        Posicion posicionSoldadoAliado = new Posicion(5,4);
        Posicion posicionEnemigo = new Posicion(18,0);

        Jinete jineteAliado = new Jinete(posicionJineteAliado, "Fede");
        Soldado soldadoAliado = new Soldado(posicionSoldadoAliado, "Fede");
        Jinete enemigo = new Jinete(posicionEnemigo, "Juan");

        Tablero unTablero = new Tablero(20,20,"Fede","Juan");
        unTablero.colocarUnidad(jineteAliado);
        unTablero.colocarUnidad(soldadoAliado);
        unTablero.colocarUnidad(enemigo);


        jineteAliado.atacar(enemigo, unTablero);



        Assert.assertEquals(enemigo.getVida(),85);
    }

}
