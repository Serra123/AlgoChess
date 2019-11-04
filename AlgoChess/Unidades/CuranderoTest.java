package Unidades;

import org.junit.Assert;
import org.junit.Test;

public class CuranderoTest {

    @Test
    public void curarAliadoCorrectamenteTest(){
        Curandero unCurandero = new Curandero(0,0,"");
        Soldado soldadoAliado = new Soldado(1,1,"");
        Soldado soldadoEnemigo = new Soldado(2,2,"");

        soldadoEnemigo.atacar(soldadoAliado);
        soldadoEnemigo.atacar(soldadoAliado);

        unCurandero.curar(soldadoAliado);

        Assert.assertEquals(soldadoAliado.getVida(),95);
    }

    @Test
    public void curarCatapultaTiraError(){
        Curandero unCurandero = new Curandero(0,0,"");
        Catapulta unaCatapulta = new Catapulta(1,1,"");

        try {
            unCurandero.curar(unaCatapulta);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
            //y aca que elija otra unidad a la que curar
        }
        Assert.assertEquals(unaCatapulta.getVida(),50);
    }


}
