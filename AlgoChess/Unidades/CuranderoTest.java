package Unidades;

import Unidades.Posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

public class CuranderoTest {

    @Test
    public void testCurarSoldadoAliadoCorrectamente(){
        Posicion unaPosicion = new Posicion(0,0);
        Curandero unCurandero = new Curandero(unaPosicion,"");
        Soldado soldadoAliado = new Soldado(unaPosicion,"Ejercito aliado");
        Soldado soldadoEnemigo = new Soldado(unaPosicion,"Ejercito enemigo");

        soldadoEnemigo.atacar(soldadoAliado);
        soldadoEnemigo.atacar(soldadoAliado);

        unCurandero.curar(soldadoAliado);

        Assert.assertEquals(soldadoAliado.getVida(),95);
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
        Assert.assertEquals(unaCatapulta.getVida(),50);
    }


}
