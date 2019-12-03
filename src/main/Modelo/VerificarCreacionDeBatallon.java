package Modelo;
import Excepciones.ExcepcionCantidadIncorrectaDePosiciones;
import Excepciones.ExcepcionCasilleroVacio;
import Excepciones.ExcepcionLasUnidadesEstanSeparadas;
import Excepciones.ExcepcionPosicionInvalida;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import Unidades.Unidad;
import java.util.ArrayList;
import java.util.LinkedHashSet;
public class VerificarCreacionDeBatallon {
    private Jugador jugador;
    private Tablero tablero;
    public ArrayList<Soldado> VerificarBatallon(ArrayList<Posicion> posicionesTotales, Jugador jugador, Tablero tablero){
        ArrayList<Posicion> posiciones = getTresPosiciones(posicionesTotales);
        posicionesEstanContiguas(posiciones);
        this.jugador = jugador;
        this.tablero = tablero;
        return getSoldadosDePosiciones(posiciones);
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
        for(int i=0;i<posiciones.size();i++){
            int finalI = i;
            int cantidadPosicionesSeparadas = (int) posiciones.stream().filter(p->posiciones.get(finalI).calcularDistancia(p)>=2).count();
            if (cantidadPosicionesSeparadas>1) {
                throw new ExcepcionLasUnidadesEstanSeparadas();
            }
        }
    }
    private ArrayList<Soldado> getSoldadosDePosiciones(ArrayList<Posicion> posiciones)throws ExcepcionPosicionInvalida, ExcepcionCasilleroVacio {
        ArrayList<Soldado> soldadosDeBatallon = new ArrayList<>();
        //posiciones.stream().filter(p->tablero.getUnidadDe(p,jugador).candidatoABatallonEn(p)).peek(p->soldadosDeBatallon.add((Soldado)tablero.getUnidadDe(p,jugador)));
        for(int i=0;i<posiciones.size();i++){
            Unidad unidad=tablero.getUnidadDe(posiciones.get(i),jugador);
            if(unidad.candidatoABatallonEn(posiciones.get(i)));
            soldadosDeBatallon.add((Soldado) unidad);
        }
        if(soldadosDeBatallon.size()<3){
            throw new ExcepcionPosicionInvalida();
        }
        return soldadosDeBatallon;
    }
}