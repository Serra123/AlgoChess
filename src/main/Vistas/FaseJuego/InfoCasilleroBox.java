package Vistas.FaseJuego;

import Excepciones.ExcepcionCasilleroVacio;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.Unidad;
import javafx.scene.control.Label;

public class InfoCasilleroBox extends Label{

    private Tablero tablero;
    private Posicion posicion;

    public InfoCasilleroBox(JuegoPrincipal juegoPrincipal, String texto){
        this.tablero = juegoPrincipal.getTableroDeJuego();
        this.setText("Estadisticas del casillero: \n\n\n" + texto);
        this.setTranslateY(50);
    }

    public void actualizarPosicionClickeada(Posicion unaPosicion) {
        String estadisticasCasillero;
        this.posicion = unaPosicion;
        try{
            Unidad unaUnidad = this.tablero.getUnidad(posicion);
            String tipoUnidad = unaUnidad.getTipoUnidad();
            estadisticasCasillero = "Estadisticas del casillero: \n\n\nUnidad: " + tipoUnidad + " (" + (posicion.getFila() + 1) + " ; " +
                    (posicion.getColumna() + 1) + "). Vida: "+ unaUnidad.getVida();


        }catch(ExcepcionCasilleroVacio e){
            estadisticasCasillero = "Estadisticas del casillero: \n\n\n(" + (posicion.getFila() + 1) + " ; " + (posicion.getColumna() + 1) + ")";

        }
        this.setText(estadisticasCasillero);


    }

    public Posicion getPosicion(){
        return new Posicion(posicion);
    }
}
