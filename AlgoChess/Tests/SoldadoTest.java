package Tests;

import Excepciones.ExcepcionAtaqueAAliado;
import Excepciones.ExcepcionAtaqueFueraDeRango;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

public class SoldadoTest {

    @Test
    public void testSoldadoAtacaASoldadoEnemigoCorrectamente() {
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(1,0);
        Soldado unSoldado = new Soldado(unaPosicion, "juan");
        Soldado enemigo = new Soldado(otraPosicion, "fede");

        unSoldado.atacar(enemigo);

        Assert.assertEquals(90, enemigo.getVida());
    }

    @Test(expected = ExcepcionAtaqueFueraDeRango.class)
    public void testSoldadoNoPuedeAtacarASoldadoEnemigoLejos(){
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(3,0);
        Soldado unSoldado = new Soldado(unaPosicion, "juan");
        Soldado enemigo = new Soldado(otraPosicion, "fede");
        unSoldado.atacar(enemigo);
}

    @Test(expected = ExcepcionAtaqueAAliado.class)
    public void testSoldadoAtacaASoldadoAliadoYSaltaExcepcion() {
        Posicion unaPosicion = new Posicion(0,0);
        Soldado unSoldado = new Soldado(unaPosicion, "juan");
        Soldado otroSoldado = new Soldado(unaPosicion, "juan");
        unSoldado.atacar(otroSoldado);
    }
}
