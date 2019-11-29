package Controller;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionPuntosInsuficientes;
import Excepciones.ExcepcionSectorEnemigo;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Vistas.InfoCasillero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CrearUnidadEventHandler implements EventHandler<ActionEvent> {

    private InfoCasillero infoCasillero;
    private String unidadACrear;
    private Tablero tablero;
    private Jugador jugadorActual;

    public CrearUnidadEventHandler(String unidadACrear, Tablero tablero, Jugador jugadorActual, InfoCasillero infoCasillero) {
        this.infoCasillero = infoCasillero;
        this.unidadACrear = unidadACrear;
        this.tablero = tablero;
        this.jugadorActual = jugadorActual;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            Posicion unaPosicion = infoCasillero.getPosicion();
            jugadorActual.crearUnidadEnPosicion(unaPosicion, unidadACrear, tablero);
        } catch (ExcepcionSectorEnemigo e){
            infoCasillero.setText("Este no es tu sector");
        } catch(ExcepcionCasilleroOcupado e){
            infoCasillero.setText("Este casillero esta Ocupado!! ");
        }catch(ExcepcionPuntosInsuficientes e){
            infoCasillero.setText("No te alcanzan los Puntos!");
        }
    }
}
