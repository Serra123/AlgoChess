package Controller;

import Excepciones.ExcepcionCasilleroVacio;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.Unidad;
import Vistas.BotonCasillero;
import Vistas.ButtonCrearUnidad;
import Vistas.InfoCasillero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class CasilleroEventHandler implements EventHandler<ActionEvent> {
    private Posicion posicion;
    private InfoCasillero infoCasillero;
    private Tablero tablero;
    private BotonCasillero botonCasillero;
    private Jugador jugadorUno;
    private Jugador jugadorDos;


    public CasilleroEventHandler(Tablero tablero, Posicion unaPosicion, InfoCasillero infoCasillero, BotonCasillero botonCasillero, Jugador jugadorUno, Jugador jugadorDos) {

        this.posicion = unaPosicion;
        this.infoCasillero = infoCasillero;
        this.tablero = tablero;
        this.botonCasillero = botonCasillero;
        this.jugadorUno = jugadorUno;
        this.jugadorDos = jugadorDos;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String infoCasillero;
        try {
            Unidad unidad= tablero.getUnidad(posicion);
            String tipoUnidad = unidad.getTipoUnidad();
            infoCasillero = "unidad:" + tipoUnidad + "(" + (posicion.getFila() + 1) + ";" + (posicion.getColumna() + 1) + "). Vida:"+unidad.getVida();
            String textoCasillero = setearTextoCasillero(tipoUnidad,unidad.getEjercito());
            botonCasillero.setText(textoCasillero);
        } catch (ExcepcionCasilleroVacio e) {
            infoCasillero = "(" + (posicion.getFila() + 1) + ";" + (posicion.getColumna() + 1) + ")";
            botonCasillero.setText("");
        }

        this.infoCasillero.actualizarPosicionClickeada(infoCasillero,posicion);
    }

    private String setearTextoCasillero(String tipoUnidad, String ejercito) {
        String textoCasillero;
        switch (tipoUnidad) {
            case "soldado":
                textoCasillero = "s";
                break;
            case "curandero":
                textoCasillero = "cu";
                break;
            case "catapulta":
                textoCasillero = "ca";
                break;
            case "jinete":
                textoCasillero = "j";
                break;
            default:
                textoCasillero = "Nan";
        }
        if(ejercito== this.jugadorUno.getNombre()){
            textoCasillero=textoCasillero+"1";
        }
        else{
            textoCasillero=textoCasillero+"2";
        }

        return textoCasillero;
    }

}