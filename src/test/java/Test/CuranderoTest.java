package Test;

import Tablero.Tablero;
import Unidades.Catapulta;
import Unidades.Curandero;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import javafx.geometry.Pos;
import org.junit.Assert;
import org.junit.Test;

public class CuranderoTest {

    @Test
    public void testCurarSoldadoAliadoCorrectamente(){
        Tablero unTablero = new Tablero(20,20,"Ejercito aliado","Ejercito enemigo");
        Posicion posicionUno = new Posicion(8,0);
        Posicion posicionDos = new Posicion(9,0);
        Posicion posicionTres = new Posicion(10,0);
        Curandero unCurandero = new Curandero(posicionUno,"Ejercito aliado");
        Soldado soldadoAliado = new Soldado(posicionDos,"Ejercito aliado");
        Soldado soldadoEnemigo = new Soldado(posicionTres,"Ejercito enemigo");
        unTablero.colocarUnidad(unCurandero);
        unTablero.colocarUnidad(soldadoAliado);
        unTablero.colocarUnidad(soldadoEnemigo);

        soldadoEnemigo.atacar(soldadoAliado, unTablero);
        soldadoEnemigo.atacar(soldadoAliado, unTablero);
        unCurandero.curar(soldadoAliado);

        Assert.assertEquals(soldadoAliado.getVida(),95,0);
    }

    @Test
    public void testCurarUnidadNoDebeSuperarSuVidaMaxima(){
        Tablero unTablero = new Tablero(20,20,"Ejercito aliado","Ejercito enemigo");
        Posicion posicionUno = new Posicion(8,0);
        Posicion posicionDos = new Posicion(9,0);
        Posicion posicionTres = new Posicion(10,0);
        Curandero unCurandero = new Curandero(posicionUno,"Ejercito aliado");
        Soldado soldadoAliado = new Soldado(posicionDos,"Ejercito aliado");
        Soldado soldadoEnemigo = new Soldado(posicionTres,"Ejercito enemigo");
        unTablero.colocarUnidad(unCurandero);
        unTablero.colocarUnidad(soldadoAliado);
        unTablero.colocarUnidad(soldadoEnemigo);

        soldadoEnemigo.atacar(soldadoAliado, unTablero);
        unCurandero.curar(soldadoAliado);

        Assert.assertEquals(soldadoAliado.getVida(),100,0);
    }

    @Test
    public void testCurarCatapultaTiraError(){
        Posicion unaPosicion = new Posicion(0,0);
        Curandero unCurandero = new Curandero(unaPosicion,"");
        Catapulta unaCatapulta = new Catapulta(unaPosicion,"");

        try {
            unCurandero.curar(unaCatapulta);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
            //En esta parte, el jugador tendría que poder elegir otra unidad para curar.
        }
        Assert.assertEquals(unaCatapulta.getVida(),50,0);
    }


}
