package Controller;

import Excepciones.ExcepcionCasilleroVacio;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
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


    public CasilleroEventHandler(Tablero tablero, Posicion unaPosicion, InfoCasillero infoCasillero, BotonCasillero botonCasillero) {
        this.posicion = unaPosicion;
        this.infoCasillero = infoCasillero;
        this.tablero = tablero;
        this.botonCasillero = botonCasillero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String infoCasillero;
        try {
            String tipoUnidad = tablero.getUnidad(posicion).getTipoUnidad();
            infoCasillero = "unidad:" + tipoUnidad + "(" + (posicion.getFila() + 1) + ";" + (posicion.getColumna() + 1) + ")";
            String textoCasillero = setearTextoCasillero(tipoUnidad);
            botonCasillero.setText(textoCasillero);
        } catch (ExcepcionCasilleroVacio e) {
            infoCasillero = "(" + (posicion.getFila() + 1) + ";" + (posicion.getColumna() + 1) + ")";
            botonCasillero.setText("");
        }

        this.infoCasillero.actualizarPosicionClickeada(infoCasillero);
    }

    private String setearTextoCasillero(String tipoUnidad) {
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

        return textoCasillero;
    }

}