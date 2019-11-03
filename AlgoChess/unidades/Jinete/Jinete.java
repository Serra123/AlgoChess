package unidades.Jinete;

import unidades.Interfaces.UnidadAtaque;
import unidades.Interfaces.UnidadMovimiento;
import unidades.Unidad;

public class Jinete extends Unidad implements UnidadAtaque, UnidadMovimiento{
    private EstadoAcompañamiento estadoAcompañamiento;
    private int dañoCuerpoACuerpo;
    private int dañoADistancia;
    Jinete(){
        this.costo = 3;
        this.vida = 100;
        this.dañoADistancia = 15;
        this.dañoCuerpoACuerpo = 5;
    }
}
