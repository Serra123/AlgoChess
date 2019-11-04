package paquetePrincipal;

import org.junit.Assert;
import org.junit.Test;

public class CatapultaTest {

    @Test
    public void testCatapultaAtacaSoldadoEnemigoCorrectamente(){
        Catapulta unaCatapulta = new Catapulta(0,0);
        Soldado enemigo = new Soldado(1,1);

        unaCatapulta.atacar(enemigo);

        Assert.assertEquals(80, enemigo.getVida());
    }
}
