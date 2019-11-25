package Tablero;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionCasilleroVacio;
import Excepciones.ExcepcionFinDelTablero;
import Excepciones.ExcepcionSectorEnemigo;
import Unidades.Posicion.Posicion;
import Unidades.Unidad;
import Unidades.UnidadMovible;

import java.util.ArrayList;
import java.util.HashMap;

public class Tablero {

    private ArrayList<Fila> filas;
    private HashMap<String,Sector> sectores;

    public Tablero(int filas, int columnas, String nombreUnJugador, String nombreOtroJugador) {
        this.filas = new ArrayList<Fila>();
        this.sectores= new HashMap<String, Sector>();

        sectores.put(nombreUnJugador,new Sector(0 ,((filas/2)-1)));
        sectores.put(nombreOtroJugador,new Sector(filas/2 ,filas));

        for(int i=0; i < filas;i++){
            Fila nuevaFila = new Fila(columnas);
            this.filas.add(nuevaFila);

        }
    }

    public boolean estaEnSector(Unidad unaUnidad){

        Sector sector = sectores.get(unaUnidad.getEjercito());

        return (sector.estaEnSector(unaUnidad.getPosicion()));

    }

    public void colocarUnidad(Unidad unaUnidad) throws ExcepcionCasilleroOcupado, ExcepcionSectorEnemigo {
        if (this.estaEnSector(unaUnidad)) {
            Fila unaFila = filas.get(unaUnidad.getPosicion().getFila());
            unaFila.colocarUnidadEnColumna(unaUnidad, unaUnidad.getPosicion().getColumna());
        } else throw new ExcepcionSectorEnemigo();
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
        return unCasillero.contenido();
    }

    //Temporalmente está bien manejar la excepción de Fin de Tablero de esta forma pero en un futuro, no vamos a tener que throwear
    //la de Excepción Fin de Tablero sino solo hacer que se compruebe el tema de la distancia en los casilleros que
    //efectivamente se encuentran dentro del tablero. Pero por ahora está bien.
    public ArrayList obtenerUnidadesADistancia(Posicion posicionReferencia, int distancia){
        ArrayList unidadesCercanas;
        unidadesCercanas = obtenerUnidadesAlejadasA(posicionReferencia, distancia);

        return unidadesCercanas;
    }

    private ArrayList obtenerUnidadesAlejadasA(Posicion posicionReferencia, int distancia) {
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

    public void expandirDanio(Posicion unaPosicion,int unDanio){
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(unaPosicion);
        this.obtenerUnidadesAfectadasPorExpansion(unaPosicion,posiciones);
        posiciones.forEach((posicion) -> {
            boolean estaEnSectorAliado = this.estaEnSector(this.getUnidad(posicion));
            this.getUnidad(posicion).recibirAtaque(unDanio, estaEnSectorAliado);
        });

    }

    void obtenerUnidadesAfectadasPorExpansion(Posicion unaPosicion, ArrayList<Posicion> posiciones){
        int filaCentro = unaPosicion.getFila();
        int columnaCentro = unaPosicion.getColumna();
        Fila filaActual;

        for(int i = filaCentro -1; i <= filaCentro+1;i++) {
            try {
                filaActual = filas.get(i);
            }catch(IndexOutOfBoundsException e){
                continue;
            }
            for (int j = columnaCentro - 1; j <= columnaCentro + 1; j++) {
                if ((i != filaCentro) || (j != columnaCentro)) {
                    filaActual.agregarPosicionesAfectadasPorExpansion(j, posiciones, this);
                }
            }
        }
    }


    public boolean posicionValida(Posicion nuevaPosicion) {
        boolean filaValida = nuevaPosicion.getFila()>=0 && nuevaPosicion.getFila()<filas.size();
        boolean columnaValida = nuevaPosicion.getColumna()>=0 && nuevaPosicion.getFila()<filas.get(1).getCantidadColumnas();
        return (filaValida && columnaValida);
    }
}
