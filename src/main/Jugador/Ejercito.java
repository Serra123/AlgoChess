package Jugador;

import Excepciones.*;
import Unidades.Posicion.Posicion;
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
    public ArrayList<Unidad> crearBatallon(ArrayList<Posicion> posicionesTotales){

        ArrayList<Posicion> posiciones = getTresPosiciones(posicionesTotales);
        posicionesEstanContiguas(posiciones);
        return getSoldadosDePosiciones(posiciones);
    }

    private ArrayList<Posicion> getTresPosiciones(ArrayList<Posicion> posicionesTotales)throws ExcepcionCantidadInsuficienteDePosiciones{
        if(posicionesTotales.size()<3){
            throw new ExcepcionCantidadInsuficienteDePosiciones();
        }

        return new ArrayList<>(posicionesTotales);

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

    private ArrayList<Unidad> getSoldadosDePosiciones(ArrayList<Posicion> posiciones)throws ExcepcionPosicionInvalida {

        ArrayList<Unidad> soldadosDeBatallon = new ArrayList<>();

        for (Unidad unidades : unidades) {
            if (unidades.candidatoABatallonEn(posiciones.get(0)) | unidades.candidatoABatallonEn(posiciones.get(1)) |
                                        unidades.candidatoABatallonEn(posiciones.get(2))) {
                soldadosDeBatallon.add(unidades);
            }
        }
        if(soldadosDeBatallon.size()<3){
            throw new ExcepcionPosicionInvalida();
        }
        return soldadosDeBatallon;
    }

}
