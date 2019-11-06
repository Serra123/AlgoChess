package Unidades;

import org.junit.Assert;
import org.junit.Test;

public class CuranderoTest {

    @Test
    public void testCurarSoldadoAliadoCorrectamente(){
        Curandero unCurandero = new Curandero(0,0,"");
        Soldado soldadoAliado = new Soldado(1,1,"Ejercito aliado");
        Soldado soldadoEnemigo = new Soldado(2,2,"Ejercito enemigo");

        soldadoEnemigo.atacar(soldadoAliado);
        soldadoEnemigo.atacar(soldadoAliado);

        unCurandero.curar(soldadoAliado);

        Assert.assertEquals(soldadoAliado.getVida(),95);
    }

    @Test
    public void testCurarCatapultaTiraError(){
        Curandero unCurandero = new Curandero(0,0,"");
        Catapulta unaCatapulta = new Catapulta(1,1,"");

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
