package paquetePrincipal;

import org.junit.Assert;
import org.junit.Test;

public class SoldadoTest {

    @Test
    public void testSoldadoAtacaSoldadoEnemigoCorrectamente(){
        Soldado unSoldado = new Soldado();
        Soldado enemigo = new Soldado();

        unSoldado.atacar(enemigo);

        Assert.assertEquals(90, enemigo.getVida());
    }

}
