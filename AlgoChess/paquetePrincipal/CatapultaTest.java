package paquetePrincipal;

import org.junit.Assert;
import org.junit.Test;

public class CatapultaTest {

    @Test
    public void testCatapultaAtacaSoldadoEnemigoCorrectamente(){
        Catapulta unaCatapulta = new Catapulta();
        Soldado enemigo = new Soldado();

        unaCatapulta.atacar(enemigo);

        Assert.assertEquals(80, enemigo.getVida());
    }
}
