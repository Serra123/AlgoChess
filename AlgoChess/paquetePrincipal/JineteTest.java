package paquetePrincipal;

import org.junit.Assert;
import org.junit.Test;

public class JineteTest {

    @Test
    public void testJineteAtacaConEspadaASoldadoEnemigoCorrectamente(){
        Jinete unJinete = new Jinete();
        Soldado enemigo = new Soldado();

        unJinete.cambiarArmaAEspada();

        unJinete.atacar(enemigo);

        Assert.assertEquals(95, enemigo.getVida());
    }

    @Test
    public void testJineteAtacaConArcoYFlechaASoldadoEnemigoCorrectamente(){
        Jinete unJinete = new Jinete();
        Soldado enemigo = new Soldado();

        unJinete.cambiarArmaAArcoYFlecha();

        unJinete.atacar(enemigo);

        Assert.assertEquals(85, enemigo.getVida());
    }

}
