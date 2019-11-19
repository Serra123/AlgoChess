package Jugador;

import Excepciones.ExcepcionLasUnidadesEstanSeparadas;
import Excepciones.*;
import Tablero.Tablero;
import Unidades.Batallon;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import Unidades.Unidad;
import Unidades.UnidadMovible;

import java.util.ArrayList;

public class Ejercito {
    private String nombre;
    private ArrayList<Unidad> unidades;

    public Ejercito(String nombre){
        this.nombre = nombre;
        unidades = new ArrayList<>();
    }
    public void agregarUnidad(Unidad unaUnidad){
        this.unidades.add(unaUnidad);
    }
    public String getNombre(){
        return this.nombre;
    }

}
