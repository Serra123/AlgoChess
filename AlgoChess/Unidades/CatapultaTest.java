package Unidades;

import Unidades.Posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

public class CatapultaTest {

    @Test
    public void testCatapultaAtacaSoldadoEnemigoCorrectamente(){
        Posicion unaPosicion = new Posicion(0,0);

        Catapulta unaCatapulta = new Catapulta(unaPosicion,"");
        Soldado enemigo = new Soldado(unaPosicion,"Enemigo");

        unaCatapulta.atacar(enemigo);

        Assert.assertEquals(80, enemigo.getVida());
    }

    @Test
    public void testCatapultaAtacaSoldadoAliadoCorrectamente(){
        Posicion unaPosicion = new Posicion(0,0);

        Catapulta unaCatapulta = new Catapulta(unaPosicion,"Ejercito aliado");
        Soldado aliado = new Soldado(unaPosicion,"Ejercito aliado");

        unaCatapulta.atacar(aliado);

        Assert.assertEquals(80, aliado.getVida());
    }
}
