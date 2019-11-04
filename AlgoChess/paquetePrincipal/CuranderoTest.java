package paquetePrincipal;

import org.junit.Assert;
import org.junit.Test;

public class CuranderoTest {

    @Test
    public void curarAliadoCorrectamenteTest(){
        Curandero unCurandero = new Curandero();
        Soldado soldadoAliado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();

        soldadoEnemigo.atacar(soldadoAliado);
        soldadoEnemigo.atacar(soldadoAliado);

        unCurandero.curar(soldadoAliado);

        Assert.assertEquals(soldadoAliado.getVida(),95);
    }

    @Test
    public void curarCatapultaTiraError(){
        Curandero unCurandero = new Curandero();
        Catapulta unaCatapulta = new Catapulta();

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
