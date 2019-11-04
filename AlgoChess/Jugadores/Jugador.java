package Jugadores;

import Unidades.*;

import java.util.ArrayList;

public class Jugador {
    private int puntos;
    private String nombre;
    private ArrayList<Unidad> unidades;

    Jugador(String nombre){
        this.puntos = 20;
        this.nombre = nombre;
        this.unidades = new ArrayList<Unidad>();
    }
    private void reducirPuntos(int costo) {
        this.puntos -= costo;
        if(this.puntos < 0) throw new RuntimeException("No alcanzan los puntos");
    }

    public Unidad crearSoldadoEnPosicion(int fila,int columna){
        String nombre = this.nombre;
        Soldado unSoldado = new Soldado(fila,columna,nombre);
        this.reducirPuntos(unSoldado.getCosto());
        unidades.add(unSoldado);
        return unSoldado;
    }



    public Unidad crearJineteEnPosicion(int fila,int columna){
        String nombreEjercito = this.nombre;
        Jinete unJinete = new Jinete(fila,columna,nombreEjercito);
        this.reducirPuntos(unJinete.getCosto());
        unidades.add(unJinete);
        return unJinete;
    }
    public Unidad crearCatapultaEnPosicion(int fila,int columna){
        String nombreEjercito = this.nombre;
        Catapulta unaCatapulta = new Catapulta(fila, columna, nombreEjercito);
        this.reducirPuntos(unaCatapulta.getCosto());
        unidades.add(unaCatapulta);
        return unaCatapulta;
    }
    public Unidad crearCuranderoEnPosicion(int fila, int columna){
        String nombreEjercito = this.nombre;
        Curandero unCurandero = new Curandero(fila,columna,nombreEjercito);
        this.reducirPuntos(unCurandero.getCosto());
        unidades.add(unCurandero);
        return unCurandero;
    }

    public void jugarTurno(){
       if(unidades.isEmpty()) throw new RuntimeException("Perdiste!");
    }

}
