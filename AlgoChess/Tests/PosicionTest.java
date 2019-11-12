package Tests;

import Unidades.Posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

public class PosicionTest {
    @Test
    public void PosicionSeMueve(){
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(1,1);
        unaPosicion.mover(otraPosicion);
        boolean mismaPosicion = (unaPosicion.getFila() == otraPosicion.getFila() && unaPosicion.getColumna() == otraPosicion.getColumna());
        Assert.assertTrue(mismaPosicion);
    }
}
