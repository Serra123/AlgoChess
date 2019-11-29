package Controller;

import Excepciones.ExcepcionCasilleroVacio;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.Unidad;
import Vistas.BotonCasillero;
import Vistas.InfoCasillero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CasilleroEventHandler implements EventHandler<ActionEvent> {

    private Posicion posicion;
    private InfoCasillero infoCasillero;
    private Tablero tablero;
    private BotonCasillero botonCasillero;
    private Jugador jugadorUno;


    public CasilleroEventHandler(Tablero tablero, Posicion unaPosicion, InfoCasillero infoCasillero, BotonCasillero botonCasillero, Jugador jugadorUno) {

        this.posicion = unaPosicion;
        this.infoCasillero = infoCasillero;
        this.tablero = tablero;
        this.botonCasillero = botonCasillero;
        this.jugadorUno = jugadorUno;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String estadisticasCasillero;
        try {
            Unidad unidad = tablero.getUnidad(posicion);
            String tipoUnidad = unidad.getTipoUnidad();
            estadisticasCasillero = "Unidad: " + tipoUnidad + " ( " + (posicion.getFila() + 1) + " ; " +
                            (posicion.getColumna() + 1) + " ). Vida: "+ unidad.getVida();
            String textoEnCasillero = setearTextoCasillero(tipoUnidad,unidad.getEjercito());
            botonCasillero.setText(textoEnCasillero);
        } catch (ExcepcionCasilleroVacio e) {
            estadisticasCasillero = "( " + (posicion.getFila() + 1) + " ; " + (posicion.getColumna() + 1) + " )";
            botonCasillero.setText("");
        }

        this.infoCasillero.actualizarPosicionClickeada(estadisticasCasillero,posicion);
    }

    private String setearTextoCasillero(String tipoUnidad, String ejercito) {
        String textoCasillero;
        switch (tipoUnidad) {
            case "soldado":
                textoCasillero = "S";
                break;
            case "curandero":
                textoCasillero = "Cu";
                break;
            case "catapulta":
                textoCasillero = "Ca";
                break;
            case "jinete":
                textoCasillero = "J";
                break;
            default:
                textoCasillero = "Nan";
        }
        if(ejercito.equals(this.jugadorUno.getNombre())){
            textoCasillero = textoCasillero + "1";
        }
        else{
            textoCasillero= textoCasillero + "2";
        }

        return textoCasillero;
    }

}