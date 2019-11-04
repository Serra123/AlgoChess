package paquetePrincipal;

import org.junit.Assert;
import org.junit.Test;

public class SoldadoTest {

    @Test
    public void testSoldadoAtacaSoldadoEnemigoCorrectamente(){
        Soldado unSoldado = new Soldado(0,0);
        Soldado enemigo = new Soldado(1,1);

        unSoldado.atacar(enemigo);

        Assert.assertEquals(90, enemigo.getVida());
    }

}
