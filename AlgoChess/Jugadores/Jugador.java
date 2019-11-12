package Jugadores;

import Tablero.Tablero;
import Unidades.*;
import Unidades.Posicion.Posicion;

import java.util.ArrayList;

public class Jugador {
    private int puntos;
    private Ejercito ejercito;
    Jugador(String nombre){
        this.puntos = 20;
        this.ejercito = new Ejercito(nombre);
    }
    private void reducirPuntos(int costo) {
        this.puntos -= costo;
        if(this.puntos < 0) throw new RuntimeException("No alcanzan los puntos");
    }

    public Unidad crearSoldadoEnPosicion(Posicion unaPosicion, Tablero unTablero){
        String nombre = this.ejercito.getNombre();
        Soldado unSoldado = new Soldado(unaPosicion,nombre);
        this.reducirPuntos(unSoldado.getCosto());
        this.ejercito.agregarUnidad(unSoldado);
        return unSoldado;
    }


    public Unidad crearJineteEnPosicion(Posicion unaPosicion,Tablero unTablero){
        String nombreEjercito = this.ejercito.getNombre();
        Jinete unJinete = new Jinete(unaPosicion,nombreEjercito);
        this.reducirPuntos(unJinete.getCosto());
        this.ejercito.agregarUnidad(unJinete);
        return unJinete;
    }
    public Unidad crearCatapultaEnPosicion(Posicion unaPosicion,Tablero unTablero){
        String nombreEjercito = this.ejercito.getNombre();
        Catapulta unaCatapulta = new Catapulta(unaPosicion, nombreEjercito);
        this.reducirPuntos(unaCatapulta.getCosto());
        this.ejercito.agregarUnidad(unaCatapulta);
        return unaCatapulta;
    }
    public Unidad crearCuranderoEnPosicion(Posicion unaPosicion,Tablero unTablero){
        String nombreEjercito = this.ejercito.getNombre();
        Curandero unCurandero = new Curandero(unaPosicion,nombreEjercito);
        this.reducirPuntos(unCurandero.getCosto());
        this.ejercito.agregarUnidad(unCurandero);
        return unCurandero;
    }

}
