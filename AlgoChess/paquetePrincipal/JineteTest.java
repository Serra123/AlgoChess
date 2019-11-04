package paquetePrincipal;

import org.junit.Assert;
import org.junit.Test;

public class JineteTest {

    @Test
    public void testJineteAtacaConEspadaASoldadoEnemigoCorrectamente(){
        Jinete unJinete = new Jinete(0,0);
        Soldado enemigo = new Soldado(1,1);

        unJinete.cambiarArmaAEspada();

        unJinete.atacar(enemigo);

        Assert.assertEquals(95, enemigo.getVida());
    }

    @Test
    public void testJineteAtacaConArcoYFlechaASoldadoEnemigoCorrectamente(){
        Jinete unJinete = new Jinete(0,0);
        Soldado enemigo = new Soldado(1,1);

        unJinete.cambiarArmaAArcoYFlecha();

        unJinete.atacar(enemigo);

        Assert.assertEquals(85, enemigo.getVida());
    }

}
