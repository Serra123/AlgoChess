package Jugadores;

import Tablero.Tablero;
import Unidades.*;
import Unidades.Posicion.Posicion;

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

    public Unidad crearSoldadoEnPosicion(Posicion unaPosicion, Tablero unTablero){
        String nombre = this.nombre;
        Soldado unSoldado = new Soldado(unaPosicion,nombre);
        this.reducirPuntos(unSoldado.getCosto());
        unidades.add(unSoldado);
        return unSoldado;
    }


    public Unidad crearJineteEnPosicion(Posicion unaPosicion,Tablero unTablero){
        String nombreEjercito = this.nombre;
        Jinete unJinete = new Jinete(unaPosicion,nombreEjercito);
        this.reducirPuntos(unJinete.getCosto());
        unidades.add(unJinete);
        return unJinete;
    }
    public Unidad crearCatapultaEnPosicion(Posicion unaPosicion,Tablero unTablero){
        String nombreEjercito = this.nombre;
        Catapulta unaCatapulta = new Catapulta(unaPosicion, nombreEjercito);
        this.reducirPuntos(unaCatapulta.getCosto());
        unidades.add(unaCatapulta);
        return unaCatapulta;
    }
    public Unidad crearCuranderoEnPosicion(Posicion unaPosicion,Tablero unTablero){
        String nombreEjercito = this.nombre;
        Curandero unCurandero = new Curandero(unaPosicion,nombreEjercito);
        this.reducirPuntos(unCurandero.getCosto());
        unidades.add(unCurandero);
        return unCurandero;
    }

    public void jugarTurno(){
        for(int i=0;i< unidades.size();i++){
            if(unidades.get(i).getEstaMuerto()){
                unidades.remove(i);
            }
        }
       if(unidades.isEmpty()) throw new RuntimeException("Perdiste!");
    }

}
