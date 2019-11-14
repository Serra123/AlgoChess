package Tests;

import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

public class SoldadoTest {

    @Test
    public void testSoldadoAtacaASoldadoEnemigoCorrectamente() {
        Posicion unaPosicion = new Posicion(0,0);
        Soldado unSoldado = new Soldado(unaPosicion, "juan");
        Soldado enemigo = new Soldado(unaPosicion, "fede");

        unSoldado.atacar(enemigo);

        Assert.assertEquals(90, enemigo.getVida());
    }

    @Test
    public void testSoldadoAtacaASoldadoAliadoYSaltaExcepcion() {
        Posicion unaPosicion = new Posicion(0,0);
        Soldado unSoldado = new Soldado(unaPosicion, "juan");
        Soldado otroSoldado = new Soldado(unaPosicion, "juan");
        try {
            unSoldado.atacar(otroSoldado);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(otroSoldado.getVida(), 100);
    }
}
