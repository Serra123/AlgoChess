package Tests;

import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

public class JugadorTest {

    @Test
    public void PosicionNuevaMantieneSuRelacionConAntigua(){
        Posicion unaPosicion = new Posicion(0,3);
        Posicion nuevaPosicionCentral = new Posicion(1,2);
        Posicion viejaPosicionCentral = new Posicion(0,2);
        Posicion unaPosicionNueva = new Posicion (1,3);
        unaPosicion.mantenerDistanciaARespectoDe(nuevaPosicionCentral,viejaPosicionCentral);
        boolean mismaFila = unaPosicionNueva.getFila()==unaPosicion.getFila();
        boolean mismaColumna = unaPosicionNueva.getColumna()==unaPosicion.getColumna();
        Assert.assertTrue( (mismaFila & mismaColumna) );
    }


}
