package Unidades;

import org.junit.Assert;
import org.junit.Test;

public class CatapultaTest {

    @Test
    public void testCatapultaAtacaSoldadoEnemigoCorrectamente(){
        Catapulta unaCatapulta = new Catapulta(0,0,"");
        Soldado enemigo = new Soldado(8,8,"Enemigo");

        unaCatapulta.atacar(enemigo);

        Assert.assertEquals(80, enemigo.getVida());
    }

    @Test
    public void testCatapultaAtacaSoldadoAliadoCorrectamente(){
        Catapulta unaCatapulta = new Catapulta(0,0,"Ejercito aliado");
        Soldado aliado = new Soldado(8,8,"Ejercito aliado");

        unaCatapulta.atacar(aliado);

        Assert.assertEquals(80, aliado.getVida());
    }
}
