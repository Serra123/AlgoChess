package Jugador;

import Unidades.Unidad;
import java.util.ArrayList;

public class Ejercito {
    String nombre;
    ArrayList<Unidad> unidades;

    Ejercito(String nombre){
        this.nombre = nombre;
        unidades = new ArrayList<Unidad>();
    }
    public void agregarUnidad(Unidad unaUnidad){
        this.unidades.add(unaUnidad);
    }
    public String getNombre(){
        return this.nombre;
    }

}
