package Unidades;

import Unidades.Posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

public class UnidadMovibleTest {
    @Test
    public void UnidadMovibleSeMueveAbajo(){
        Posicion unaPosicion = new Posicion(1,0);
        UnidadMovible unaUnidadMovible = new UnidadMovible(0,0);
        unaUnidadMovible.mover(unaPosicion);
        Assert.assertEquals(1,unaPosicion.getFila());
    }

    @Test
    public void UnidadMovibleSeMueveArriba(){
        Posicion unaPosicion = new Posicion(0,0);
        UnidadMovible unaUnidadMovible = new UnidadMovible(1,0);
        unaUnidadMovible.mover(unaPosicion);
        Assert.assertEquals(0,unaPosicion.getFila());
    }

    @Test
    public void UnidadMovibleSeMueveIzquierda(){
        Posicion unaPosicion = new Posicion(0,0);
        UnidadMovible unaUnidadMovible = new UnidadMovible(0,1);
        unaUnidadMovible.mover(unaPosicion);
        Assert.assertEquals(0,unaPosicion.getColumna());
    }

    @Test
    public void UnidadMovibleSeMueveDerecha(){
        Posicion unaPosicion = new Posicion(0,1);
        UnidadMovible unaUnidadMovible = new UnidadMovible(0,0);
        unaUnidadMovible.mover(unaPosicion);
        Assert.assertEquals(1,unaPosicion.getColumna());
    }

    @Test
    public void UnidadMovibleSeMueveArribaIzquierda(){
        Posicion unaPosicion = new Posicion(0,0);
        UnidadMovible unaUnidadMovible = new UnidadMovible(1,1);
        unaUnidadMovible.mover(unaPosicion);
        Assert.assertEquals(0,unaPosicion.getFila());
        Assert.assertEquals(0,unaPosicion.getColumna());
    }

    @Test
    public void UnidadMovibleSeMueveArribaDerecha(){
        Posicion unaPosicion = new Posicion(0,1);
        UnidadMovible unaUnidadMovible = new UnidadMovible(1,0);
        unaUnidadMovible.mover(unaPosicion);
        Assert.assertEquals(0,unaPosicion.getFila());
        Assert.assertEquals(1,unaPosicion.getColumna());
    }

    @Test
    public void UnidadMovibleSeMueveAbajoIzquierda(){
        Posicion unaPosicion = new Posicion(1,0);
        UnidadMovible unaUnidadMovible = new UnidadMovible(0,1);
        unaUnidadMovible.mover(unaPosicion);
        Assert.assertEquals(1,unaPosicion.getFila());
        Assert.assertEquals(0,unaPosicion.getColumna());
    }

    @Test
    public void UnidadMovibleSeMueveAbajoDerecha(){
        Posicion unaPosicion = new Posicion(1,1);
        UnidadMovible unaUnidadMovible = new UnidadMovible(0,0);
        unaUnidadMovible.mover(unaPosicion);
        Assert.assertEquals(1,unaPosicion.getFila());
        Assert.assertEquals(1,unaPosicion.getColumna());
    }


}
