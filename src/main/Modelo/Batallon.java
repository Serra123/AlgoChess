package Modelo;

import Excepciones.ExcepcionCantidadIncorrectaDePosiciones;
import Excepciones.ExcepcionLasUnidadesEstanSeparadas;
import Excepciones.ExcepcionPosicionInvalida;
import Jugador.Jugador;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import Unidades.Unidad;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Batallon {

    private ArrayList<Soldado> SoldadosDeBatallon;

    public Batallon(ArrayList<Posicion> posicionesTotales, Jugador jugador){

        ArrayList<Posicion> posiciones = getTresPosiciones(posicionesTotales);
        posicionesEstanContiguas(posiciones);
        SoldadosDeBatallon =  getSoldadosDePosiciones(posiciones,jugador);
    }

    private ArrayList<Posicion> getTresPosiciones(ArrayList<Posicion> posicionesTotales)throws ExcepcionCantidadIncorrectaDePosiciones {

        LinkedHashSet<Posicion> hashSet = new LinkedHashSet<>(posicionesTotales);
        ArrayList <Posicion> posiciones = new ArrayList<>(hashSet);
        if(posiciones.size()!=3){
            throw new ExcepcionCantidadIncorrectaDePosiciones();
        }
        ArrayList<Posicion> tresPosiciones = new ArrayList<>();

        tresPosiciones.add(posicionesTotales.get(0));
        tresPosiciones.add(posicionesTotales.get(1));
        tresPosiciones.add(posicionesTotales.get(2));

        return tresPosiciones;

    }

    private void posicionesEstanContiguas(ArrayList<Posicion> posiciones)throws ExcepcionLasUnidadesEstanSeparadas {
        for(int i = 0; i<posiciones.size(); i++){
            int finalI = i;
            int cantidadPosicionesSeparadas = (int) posiciones.stream().filter(p->posiciones.get(finalI).calcularDistancia(p)>=2).count();
            if (cantidadPosicionesSeparadas>1) {
                throw new ExcepcionLasUnidadesEstanSeparadas();
            }
        }
    }

    private ArrayList<Soldado> getSoldadosDePosiciones(ArrayList<Posicion> posiciones,Jugador jugador)throws ExcepcionPosicionInvalida {

        ArrayList<Soldado> soldadosDeBatallon = new ArrayList<>();

        /*for (Unidad unidad : unidades) {
            for(Posicion posicion : posiciones){
                if(unidad.candidatoABatallonEn(posicion)){
                    soldadosDeBatallon.add((Soldado) unidad);
                }
            }
        }*/
        //for(){

        /*}
        if(soldadosDeBatallon.size()<3){
            throw new ExcepcionPosicionInvalida();
        }*/
        return soldadosDeBatallon;
    }
}
