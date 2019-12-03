package Jugador;

import Excepciones.*;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import Unidades.Unidad;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Ejercito {

    private final String nombreEjercito;
    private ArrayList<Unidad> unidades;
    private int puntos;
    private static final int PUNTOSINICIALES = 20;

    public Ejercito(String nombreEjercito){
        this.unidades = new ArrayList<>();
        this.puntos = PUNTOSINICIALES;
        this.nombreEjercito = nombreEjercito;
    }

    public void agregarUnidad(Unidad unaUnidad) throws ExcepcionPuntosInsuficientes{
        int costoUnidad = unaUnidad.getCosto();
        if(costoUnidad > this.puntos){
            throw new ExcepcionPuntosInsuficientes();
        }else{
            this.unidades.add(unaUnidad);
            this.puntos -= costoUnidad;
        }
    }

    public int getPuntos() {
        return this.puntos;
    }

    void puedoCrearUnidad(String tipoUnidad) throws ExcepcionPuntosInsuficientes{

        int costoUnidad=0;
        switch (tipoUnidad){
            case "Soldado" : costoUnidad = 1;
                break;
            case "Curandero" : costoUnidad = 2;
                break;
            case "Jinete" : costoUnidad = 3;
                break;
            case "Catapulta" : costoUnidad = 5;
                break;
        }
        if(costoUnidad > this.puntos){
            throw new ExcepcionPuntosInsuficientes();
        }
    }

    public boolean ejercitoVacio(){
        return (unidades.size()==0);
    }

    public void eliminarUnidad(Unidad unidadAtacada) {
        this.unidades.remove(unidadAtacada);
    }

    public String getNombreEjercito() {
        return nombreEjercito;
    }

}
