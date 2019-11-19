package Jugador;

import Excepciones.*;
import Tablero.Tablero;
import Unidades.*;
import Unidades.Posicion.Posicion;

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

    public void moverBatallon(ArrayList<UnidadMovible> soldados, Posicion nuevaPosicionCentral, Tablero tablero){
        verificarPosicionesDeBatallon(soldados);
        verificarEjercitoDeBatallon(soldados);
        verificarUnidadesSonSoldados(soldados);
        Batallon batallon= new Batallon(soldados,tablero);
        batallon.moverA(nuevaPosicionCentral);
    }

    private void verificarPosicionesDeBatallon(ArrayList<UnidadMovible> soldados) throws ExcepcionLasUnidadesEstanSeparadas {
        for(int i=0;i<soldados.size();i++){
            int cantidadPosicionesSeparadas = 0;
            for(int j=0;j<soldados.size();j++) {
                double distanciaAPosicionActual = soldados.get(i).getPosicion().calcularDistancia(soldados.get(1).getPosicion());
                if (distanciaAPosicionActual>=2){
                    cantidadPosicionesSeparadas++;
                }
            }
            if (cantidadPosicionesSeparadas>1) {
                throw new ExcepcionLasUnidadesEstanSeparadas();
            }
        }
    }

    private void verificarEjercitoDeBatallon(ArrayList<UnidadMovible> soldados) throws ExcepcionSoldadosNoPerteneceATuEjercito {
        if( !(soldados.get(0).esAliado(soldados.get(1)) & soldados.get(1).esAliado(soldados.get(2))) ){
            throw new ExcepcionSoldadosNoPerteneceATuEjercito();
        }
    }

    private void verificarUnidadesSonSoldados(ArrayList<UnidadMovible> soldados) throws ExcepcionTipoUnidadInvalida {
        for (UnidadMovible soldado : soldados) {
            if (!(soldado instanceof Soldado)) {
                throw new ExcepcionTipoUnidadInvalida();
            }
        }
    }

    public int getPuntos(){
        return this.puntos;
    }


}
