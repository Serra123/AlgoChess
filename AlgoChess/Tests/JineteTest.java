package Tests;

import Unidades.Jinete;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

public class JineteTest {

    @Test
    public void testJineteAtacaConEspadaASoldadoEnemigoCorrectamente(){
        Posicion unaPosicion = new Posicion(0,0);
        Jinete unJinete = new Jinete(unaPosicion,"");
        Soldado enemigo = new Soldado(unaPosicion,"Ejercito enemigo");

        unJinete.cambiarArmaAEspada();

        unJinete.atacar(enemigo);

        Assert.assertEquals(95, enemigo.getVida());
    }

    @Test
    public void testJineteAtacaConArcoYFlechaASoldadoEnemigoCorrectamente(){
        Posicion unaPosicion = new Posicion(0,0);
        Jinete unJinete = new Jinete(unaPosicion,"");
        Soldado unEnemigo = new Soldado(unaPosicion,"Ejercito enemigo");

        unJinete.cambiarArmaAArcoYFlecha();

        unJinete.atacar(unEnemigo);

        Assert.assertEquals(85, unEnemigo.getVida());
    }
    @Test
    public void testJineteAtacaAJineteAliadoYSaltaExcepcion() {
        Posicion unaPosicion = new Posicion(0,0);
        Jinete unJinete = new Jinete(unaPosicion, "juan");
        Jinete otroJinete = new Jinete(unaPosicion, "juan");
        try {
            unJinete.atacar(otroJinete);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(otroJinete.getVida(), 100);
    }

}
