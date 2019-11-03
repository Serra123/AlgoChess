package unidades;

import unidades.Interfaces.UnidadAtaque;

public class Catapulta extends Unidad implements UnidadAtaque{
    private int dañoADistancia;
    Catapulta(){
        this.dañoADistancia = 20;
    }
}
