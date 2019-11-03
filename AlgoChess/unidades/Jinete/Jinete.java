package unidades.Jinete;

import unidades.Interfaces.Ataque;
import unidades.Interfaces.Movimiento;
import unidades.Unidad;

public class Jinete extends Unidad implements Ataque, Movimiento {
    private EstadoAcompañamiento estadoAcompañamiento;
}
