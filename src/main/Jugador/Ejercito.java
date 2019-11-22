package Jugador;

import Excepciones.*;
import Unidades.Batallon;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
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


    //cambiar int por Batallon luego o algo asi
    public Batallon crearBatallon(ArrayList<Posicion> posicionesTotales){

        ArrayList<Posicion> posiciones = getTresPosiciones(posicionesTotales);
        posicionesEstanContiguas(posiciones);
        ArrayList<Soldado> SoldadosDeBatallon =  getSoldadosDePosiciones(posiciones);
        return new Batallon(SoldadosDeBatallon);
    }

    private ArrayList<Posicion> getTresPosiciones(ArrayList<Posicion> posicionesTotales)throws ExcepcionCantidadInsuficienteDePosiciones{
        if(posicionesTotales.size()<3){
            throw new ExcepcionCantidadInsuficienteDePosiciones();
        }
        ArrayList<Posicion> tresPosiciones = new ArrayList<>();
        for(int i=0;i<3;i++){
            tresPosiciones.add(posicionesTotales.get(i));
        }
        return tresPosiciones;

    }

    private void posicionesEstanContiguas(ArrayList<Posicion> posiciones)throws ExcepcionLasUnidadesEstanSeparadas {
        for(int i=0;i<posiciones.size();i++){
            int cantidadPosicionesSeparadas = 0;
            for (Posicion posicion : posiciones) {
                double distanciaAPosicionActual = posiciones.get(i).calcularDistancia(posicion);
                if (distanciaAPosicionActual >= 2) {
                    cantidadPosicionesSeparadas++;
                }
            }
            if (cantidadPosicionesSeparadas>1) {
                throw new ExcepcionLasUnidadesEstanSeparadas();
            }
        }
    }

    private ArrayList<Soldado> getSoldadosDePosiciones(ArrayList<Posicion> posiciones)throws ExcepcionPosicionInvalida {

        ArrayList<Soldado> soldadosDeBatallon = new ArrayList<>();

        for (Unidad unidades : unidades) {
            if (unidades.candidatoABatallonEn(posiciones.get(0)) | unidades.candidatoABatallonEn(posiciones.get(1)) |
                                        unidades.candidatoABatallonEn(posiciones.get(2))) {
                soldadosDeBatallon.add((Soldado) unidades);
            }
        }
        if(soldadosDeBatallon.size()<3){
            throw new ExcepcionPosicionInvalida();
        }
        return soldadosDeBatallon;
    }

}
