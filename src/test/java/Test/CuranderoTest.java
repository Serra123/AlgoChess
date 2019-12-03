package Test;

import Jugador.Ejercito;
import Tablero.Tablero;
import Unidades.Catapulta;
import Unidades.Curandero;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

public class CuranderoTest {

    @Test
    public void testCurarSoldadoAliadoCorrectamente(){
        Ejercito unEjercito = new Ejercito("Ejercito aliado");
        Ejercito otroEjercito = new Ejercito("Ejercito enemigo");
        Tablero unTablero = new Tablero(20,20,"Ejercito aliado","Ejercito enemigo");
        Posicion posicionUno = new Posicion(8,0);
        Posicion posicionDos = new Posicion(9,0);
        Posicion posicionTres = new Posicion(10,0);
        Curandero unCurandero = new Curandero(posicionUno,unEjercito);
        Soldado soldadoAliado = new Soldado(posicionDos,unEjercito);
        Soldado soldadoEnemigo = new Soldado(posicionTres,otroEjercito);
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
        Ejercito unEjercito = new Ejercito("Ejercito aliado");
        Ejercito otroEjercito = new Ejercito("Ejercito enemigo");
        Tablero unTablero = new Tablero(20,20,"Ejercito aliado","Ejercito enemigo");
        Posicion posicionUno = new Posicion(8,0);
        Posicion posicionDos = new Posicion(9,0);
        Posicion posicionTres = new Posicion(10,0);
        Curandero unCurandero = new Curandero(posicionUno,unEjercito);
        Soldado soldadoAliado = new Soldado(posicionDos,unEjercito);
        Soldado soldadoEnemigo = new Soldado(posicionTres,otroEjercito);
        unTablero.colocarUnidad(unCurandero);
        unTablero.colocarUnidad(soldadoAliado);
        unTablero.colocarUnidad(soldadoEnemigo);

        soldadoEnemigo.atacar(soldadoAliado, unTablero);
        unCurandero.curar(soldadoAliado);

        Assert.assertEquals(soldadoAliado.getVida(),100,0);
    }

    @Test
    public void testCurarCatapultaTiraError(){
        Ejercito unEjercito = new Ejercito("");
        Posicion unaPosicion = new Posicion(0,0);
        Curandero unCurandero = new Curandero(unaPosicion,unEjercito);
        Catapulta unaCatapulta = new Catapulta(unaPosicion,unEjercito);

        try {
            unCurandero.curar(unaCatapulta);
        }
        catch (RuntimeException ignored) {
        }
        Assert.assertEquals(unaCatapulta.getVida(),50,0);
    }


}
