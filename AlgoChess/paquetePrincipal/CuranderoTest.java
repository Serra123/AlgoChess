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
}
