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


}
