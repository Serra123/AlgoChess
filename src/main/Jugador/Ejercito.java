package Jugador;

import Excepciones.*;
import Unidades.Unidad;

import java.util.ArrayList;

public class Ejercito {

    private ArrayList<Unidad> unidades;
    private int puntos;
    private static int PUNTOSINICIALES = 20;

    public Ejercito(){
        this.unidades = new ArrayList<>();
        this.puntos = PUNTOSINICIALES;
    }

    public void agregarUnidad(Unidad unaUnidad) throws ExcepcionPuntosInsuficientes{
        int costoUnidad = unaUnidad.getCosto();
        this.unidades.add(unaUnidad);
        if(costoUnidad > this.puntos){
            throw new ExcepcionPuntosInsuficientes();
        }else{
            this.puntos -= costoUnidad;
        }
    }

    public int getPuntos() {
        return this.puntos;
    }
}