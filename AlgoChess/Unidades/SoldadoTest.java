package Unidades;

import org.junit.Assert;
import org.junit.Test;

public class SoldadoTest {

    @Test
    public void testSoldadoAtacaASoldadoEnemigoCorrectamente() {
        Soldado unSoldado = new Soldado(0, 0, "juan");
        Soldado enemigo = new Soldado(1, 1, "fede");

        unSoldado.atacar(enemigo);

        Assert.assertEquals(90, enemigo.getVida());
    }

    @Test
    public void testSoldadoAtacaASoldadoAliadoYSaltaExcepcion() {
        Soldado unSoldado = new Soldado(0, 0, "juan");
        Soldado otroSoldado = new Soldado(0, 0, "juan");
        try {
            unSoldado.atacar(otroSoldado);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(otroSoldado.getVida(), 100);
    }
}
