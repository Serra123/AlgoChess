package Tests;

import Excepciones.ExcepcionAtaqueAAliado;
import Excepciones.ExcepcionAtaqueFueraDeRango;
import Unidades.Jinete;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

public class JineteTest {

    @Test
    public void testJineteAtacaConEspadaASoldadoEnemigoCorrectamente(){
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(1,0);
        Jinete unJinete = new Jinete(unaPosicion,"");
        Soldado enemigo = new Soldado(otraPosicion,"Ejercito enemigo");

        unJinete.cambiarArmaAEspada();

        unJinete.atacar(enemigo);

        Assert.assertEquals(95, enemigo.getVida());
    }

    @Test(expected = ExcepcionAtaqueFueraDeRango.class)
    public void testJineteNoPuedeAtacarASoldadoEnemigoLejanoConEspada(){
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(3,0);
        Jinete unJinete = new Jinete(unaPosicion,"");
        Soldado enemigo = new Soldado(otraPosicion,"Ejercito enemigo");

        unJinete.cambiarArmaAEspada();

        unJinete.atacar(enemigo);
    }

    @Test
    public void testJineteAtacaConArcoYFlechaASoldadoEnemigoCorrectamente(){
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(4,0);
        Jinete unJinete = new Jinete(unaPosicion,"");
        Soldado unEnemigo = new Soldado(otraPosicion,"Ejercito enemigo");

        unJinete.cambiarArmaAArcoYFlecha();

        unJinete.atacar(unEnemigo);

        Assert.assertEquals(85, unEnemigo.getVida());
    }

    @Test(expected = ExcepcionAtaqueFueraDeRango.class)
    public void testJineteNoPuedeAtacarASoldadoEnemigoCercanoConArcoYFlecha(){
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(1,0);
        Jinete unJinete = new Jinete(unaPosicion,"");
        Soldado enemigo = new Soldado(otraPosicion,"Ejercito enemigo");

        unJinete.cambiarArmaAArcoYFlecha();

        unJinete.atacar(enemigo);
    }

    @Test(expected = ExcepcionAtaqueFueraDeRango.class)
    public void testJineteNoPuedeAtacarASoldadoEnemigoLejanoConArcoYFlecha(){
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(10,0);
        Jinete unJinete = new Jinete(unaPosicion,"");
        Soldado enemigo = new Soldado(otraPosicion,"Ejercito enemigo");

        unJinete.cambiarArmaAArcoYFlecha();

        unJinete.atacar(enemigo);
    }
    @Test(expected = ExcepcionAtaqueAAliado.class)
    public void testJineteAtacaAJineteAliadoYSaltaExcepcion() {
        Posicion unaPosicion = new Posicion(0,0);
        Jinete unJinete = new Jinete(unaPosicion, "juan");
        Jinete otroJinete = new Jinete(unaPosicion, "juan");
        unJinete.atacar(otroJinete);
        }

}
