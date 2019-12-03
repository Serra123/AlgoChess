package Modelo;
import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionMovimientoInvalido;
import Excepciones.ExcepcionSuperaLimitesDelTablero;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import java.util.ArrayList;

public class Batallon {
    private ArrayList<Soldado> soldados;
    private Soldado soldadoCentral;
    private Tablero unTablero;
    public Batallon(ArrayList<Posicion> posicionesTotales, Jugador jugador, Tablero tablero) {
        this.soldados =new VerificarCreacionDeBatallon().VerificarBatallon(posicionesTotales, jugador, tablero);
        this.soldadoCentral = this.getSoldadoCentral();
        this.unTablero = tablero;
    }
    private Soldado getSoldadoCentral(){
        double distanciaMin = 100;
        Soldado soldadoCentral = soldados.get(1);
        for(int i=0;i<soldados.size();i++){
            int finalI = i;
            int distanciaSoldado = (int) soldados.stream().filter(s -> s.distanciaA(soldados.get(finalI))>1.5).count();
            if(distanciaSoldado<distanciaMin){
                distanciaMin = distanciaSoldado;
                soldadoCentral=soldados.get(i);
            }
        }
        return soldadoCentral;
    }
    public void moverBatallon(Posicion posicionCentralNueva) {
        Posicion posicionCentralVieja = soldadoCentral.getPosicion();
        ArrayList<Posicion> nuevasPosiciones = calcularPosicionesNuevas(posicionCentralNueva,posicionCentralVieja);
        moverSoldados(nuevasPosiciones,0);
    }
    private ArrayList<Posicion> calcularPosicionesNuevas(Posicion posicionCentralNueva, Posicion posicionCentralVieja){
        ArrayList<Posicion> nuevasPosiciones = new ArrayList<>();
        for (Soldado soldado : soldados) {
            Posicion nuevaPosicion = soldado.getPosicion().calcularNuevaPosicionRespectoDe(posicionCentralNueva, posicionCentralVieja);
            nuevasPosiciones.add(nuevaPosicion);
        }
        return nuevasPosiciones;
    }
    private void moverSoldados(ArrayList<Posicion> nuevasPosiciones,int soldadoActual){
        boolean mismaPosicionConDos = nuevasPosiciones.get(soldadoActual).calcularDistancia(soldados.get(1).getPosicion()) == 0;
        boolean mismaPosicionConTres = nuevasPosiciones.get(soldadoActual).calcularDistancia(soldados.get(2).getPosicion()) == 0;
        if(mismaPosicionConDos && soldadoActual!=1){
            moverSoldados(nuevasPosiciones,1);
        }
        else if(mismaPosicionConTres && soldadoActual!=2){
            moverSoldados(nuevasPosiciones,2);
        }
        moverUnSoldado(nuevasPosiciones,soldadoActual);
        if(soldadoActual<2){
            moverSoldados(nuevasPosiciones,soldadoActual+1);
        }
    }
    private void moverUnSoldado(ArrayList<Posicion> nuevasPosiciones,int numeroSoldado) throws ExcepcionMovimientoInvalido {
        Soldado soldadoActual = soldados.get(numeroSoldado);
        Posicion posicionActual = soldadoActual.getPosicion();
        try{
            soldadoActual.mover(nuevasPosiciones.get(numeroSoldado),unTablero);
        }
        catch (ExcepcionCasilleroOcupado | ExcepcionSuperaLimitesDelTablero e){
            soldadoActual.mover(posicionActual,unTablero);
        }
    }
}