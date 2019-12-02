package Jugador;

import Excepciones.*;
import Unidades.Batallon;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import Unidades.Unidad;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class Ejercito {

    private ArrayList<Unidad> unidades;
    private int puntos;
    private static final int PUNTOSINICIALES = 200;

    public Ejercito(){
        this.unidades = new ArrayList<>();
        this.puntos = PUNTOSINICIALES;
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


    public Batallon crearBatallon(ArrayList<Posicion> posicionesTotales){

        ArrayList<Posicion> posiciones = getTresPosiciones(posicionesTotales);
        posicionesEstanContiguas(posiciones);
        ArrayList<Soldado> SoldadosDeBatallon =  getSoldadosDePosiciones(posiciones);
        return new Batallon(SoldadosDeBatallon);
    }

    private ArrayList<Posicion> getTresPosiciones(ArrayList<Posicion> posicionesTotales)throws ExcepcionCantidadInsuficienteDePosiciones{

        LinkedHashSet<Posicion> hashSet = new LinkedHashSet<>(posicionesTotales);
        ArrayList <Posicion> posiciones = new ArrayList<>(hashSet);
        if(posiciones.size()<3){
            throw new ExcepcionCantidadInsuficienteDePosiciones();
        }
        ArrayList<Posicion> tresPosiciones = new ArrayList<>();

        tresPosiciones.add(posicionesTotales.get(0));
        tresPosiciones.add(posicionesTotales.get(1));
        tresPosiciones.add(posicionesTotales.get(2));

        return tresPosiciones;

    }

    private void posicionesEstanContiguas(ArrayList<Posicion> posiciones)throws ExcepcionLasUnidadesEstanSeparadas {
        for(int i=0;i<posiciones.size();i++){
            int finalI = i;
            int cantidadPosicionesSeparadas = (int) posiciones.stream().filter(p->posiciones.get(finalI).calcularDistancia(p)>=2).count();
            if (cantidadPosicionesSeparadas>1) {
                throw new ExcepcionLasUnidadesEstanSeparadas();
            }
        }
    }

    private ArrayList<Soldado> getSoldadosDePosiciones(ArrayList<Posicion> posiciones)throws ExcepcionPosicionInvalida {

        ArrayList<Soldado> soldadosDeBatallon = new ArrayList<>();

        for (Unidad unidad : unidades) {
            for(Posicion posicion : posiciones){
                if(unidad.candidatoABatallonEn(posicion)){
                    soldadosDeBatallon.add((Soldado) unidad);
                }
            }
        }
        if(soldadosDeBatallon.size()<3){
            throw new ExcepcionPosicionInvalida();
        }
        return soldadosDeBatallon;
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
}
