package paquetePrincipal;

import org.junit.Assert;
import org.junit.Test;

public class JineteTest {

    @Test
    public void testJineteAtacaSoldadoEnemigoCorrectamente(){
        Jinete unJinete = new Jinete();
        Soldado enemigo = new Soldado();

        unJinete.atacar(enemigo);

        Assert.assertEquals(95, enemigo.getVida());
    }

}
