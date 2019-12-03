package Tablero;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionCasilleroVacio;
import Excepciones.ExcepcionSectorEnemigo;
import Excepciones.ExcepcionUnidadNoPerteneceATuEjercito;
import Jugador.Jugador;
import Unidades.Posicion.Posicion;
import Unidades.Unidad;
import Unidades.UnidadMovible;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tablero {

    private static final int FILACUALQUIERA = 1;
    private static final int DISTANCIACONTIGUA = 1;
    private List<Fila> filas;
    private HashMap<String,Sector> sectores;

    public Tablero(int cantidadFilas, int cantidadColumnas, String nombreUnJugador, String nombreOtroJugador) {

        this.sectores= new HashMap<String, Sector>();

        sectores.put(nombreUnJugador,new Sector(0 ,((cantidadFilas/2)-1)));
        sectores.put(nombreOtroJugador,new Sector(cantidadFilas/2 ,cantidadFilas));

        this.filas= IntStream.range(0, cantidadFilas).mapToObj(x -> new Fila(cantidadColumnas)).collect(Collectors.toList());
    }

    public boolean estaEnSector(Unidad unaUnidad){

        Sector sector = sectores.get(unaUnidad.getNombreJugador());

        return (sector.estaEnSector(unaUnidad.getPosicion()));

    }

    public void colocarUnidad(Unidad unaUnidad) throws ExcepcionCasilleroOcupado, ExcepcionSectorEnemigo {
        if (this.estaEnSector(unaUnidad)) {
            Fila unaFila = filas.get(unaUnidad.getPosicion().getFila());
            unaFila.colocarUnidadEnColumna(unaUnidad, unaUnidad.getPosicion().getColumna());
        } else throw new ExcepcionSectorEnemigo();
    }

    public void vaciarCasillero(Posicion unaPosicion){
        Fila unaFila = filas.get(unaPosicion.getFila());
        unaFila.vaciarUnidad(unaPosicion.getColumna());
    }

    public void moverUnidad(UnidadMovible unaUnidadMovible,Posicion posicionNueva) throws ExcepcionCasilleroOcupado,
                                                                                          ExcepcionCasilleroVacio {
        Posicion unaPosicion = unaUnidadMovible.getPosicion();
        Fila filaAnterior = filas.get(unaPosicion.getFila());
        Fila filaNueva = filas.get(posicionNueva.getFila());
        filaAnterior.vaciarUnidad(unaPosicion.getColumna());
        filaNueva.recibirUnidad(unaUnidadMovible,posicionNueva.getColumna());
    }

    public Unidad getUnidad(Posicion unaPosicion){
        Fila unaFila = filas.get(unaPosicion.getFila());
        Casillero unCasillero = unaFila.getCasillero(unaPosicion.getColumna());
        Unidad unaUnidad = unCasillero.contenido();
        if(unaUnidad.getVida() <= 0){
            this.vaciarCasillero(unaUnidad.getPosicion());
        }
        return unCasillero.contenido();
    }

    public ArrayList<Unidad> obtenerUnidadesAlejadasA(Posicion posicionReferencia, int distancia) {
        ArrayList<Unidad> unidadesCercanas = new ArrayList<>();
        int filaReferencia = posicionReferencia.getFila();
        int columnaReferencia = posicionReferencia.getColumna();

        for (int i = filaReferencia - distancia; i <= filaReferencia + distancia; i++) {
            for (int j = columnaReferencia - distancia; j <= columnaReferencia + distancia; j++) {
                boolean esUnidadReferencia = (i == filaReferencia && j == columnaReferencia);
                try {
                    Unidad unidadActual = this.filas.get(i).getCasillero(j).contenido();
                    if (posicionReferencia.calcularDistancia(unidadActual.getPosicion()) <= distancia
                            && !esUnidadReferencia) {
                        unidadesCercanas.add(unidadActual);
                    }
                } catch (ExcepcionCasilleroVacio e) {
                    //No se debería de hacer nada en el manejo de esta excepción.
                } catch (IndexOutOfBoundsException e){
                    //No tenemos que hacer nada en el manejo de esta excepción.
                }
            }
        }

        return unidadesCercanas;
    }

    public boolean esPosicionValida(Posicion nuevaPosicion) {
        boolean filaValida = nuevaPosicion.getFila()>=0 && nuevaPosicion.getFila()<filas.size();
        boolean columnaValida = nuevaPosicion.getColumna()>=0 && nuevaPosicion.getColumna()<filas.get(FILACUALQUIERA).getCantidadColumnas();
        return (filaValida && columnaValida);
    }

    public void obtenerUnidadesDeExpansion(ArrayList<Unidad>unidadesTotal,Posicion unaPosicion){

        ArrayList<Unidad> unidadesParcial;
        unidadesParcial = this.obtenerUnidadesAlejadasA(unaPosicion,DISTANCIACONTIGUA);
        unidadesParcial.add(this.getUnidad(unaPosicion));

        /*for(Iterator<Unidad> iterator = unidadesParcial.iterator();iterator.hasNext();){
            Unidad unaUnidad = iterator.next();
            if (!(unidadesTotal.contains(unaUnidad))) {
                unidadesTotal.add(unaUnidad);
            }else iterator.remove();
        }*/

        ArrayList<Unidad> unidadesARemover =new ArrayList<>();
        unidadesParcial.stream().forEach(u -> {
            if(this.yaEstaEnUnidadesTotales(unidadesTotal,u)){
                unidadesTotal.add(u);
            }else{
                unidadesARemover.add(u);
            }
        }
        );

        unidadesParcial.stream().filter(p->!unidadesARemover.contains(p)).peek(x -> this.obtenerUnidadesDeExpansion(unidadesTotal, x.getPosicion())).toArray();

    }

    public boolean yaEstaEnUnidadesTotales(ArrayList<Unidad>unidadesTotal,Unidad unaUnidad){
        return !unidadesTotal.contains(unaUnidad);
    }

    public Unidad getUnidadDe(Posicion unaPosicion, Jugador unJugador)throws ExcepcionUnidadNoPerteneceATuEjercito {
        Unidad unidad= getUnidad(unaPosicion);
        if(!unidad.getNombreJugador().equals(unJugador.getNombre())){
            throw new ExcepcionUnidadNoPerteneceATuEjercito();
        }
        else{
            return unidad;
        }

    }

}
