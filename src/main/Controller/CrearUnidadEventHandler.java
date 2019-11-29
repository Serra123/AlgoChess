package Controller;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionPuntosInsuficientes;
import Excepciones.ExcepcionSectorEnemigo;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Vistas.InfoCasillero;
import Vistas.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CrearUnidadEventHandler implements EventHandler<ActionEvent> {

    private InfoCasillero infoCasillero;
    private String unidadACrear;
    private Tablero tablero;
    private Jugador jugadorActual;
    private TableroView tableroView;

    public CrearUnidadEventHandler(String unidadACrear, Tablero tablero, Jugador jugadorActual, InfoCasillero infoCasillero, TableroView tableroView) {
        this.infoCasillero = infoCasillero;
        this.unidadACrear = unidadACrear;
        this.tablero = tablero;
        this.jugadorActual = jugadorActual;
        this.tableroView = tableroView;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Posicion unaPosicion = infoCasillero.getPosicion();
        try {
            jugadorActual.crearUnidadEnPosicion(unaPosicion, unidadACrear, tablero);
            tableroView.actualizar(); //Actualiza el tablero entero
            tableroView.mostrar(unaPosicion); // Me muestra la ultima posicion creada
            // sin esto, me muestra siempre (20,20) automaticamente por ser la ultima en actualizarse
        } catch (ExcepcionSectorEnemigo e){
            infoCasillero.setText("Este no es tu sector");
        } catch(ExcepcionCasilleroOcupado e){
            infoCasillero.setText("Este casillero esta Ocupado!! ");
        }catch(ExcepcionPuntosInsuficientes e){
            infoCasillero.setText("No te alcanzan los Puntos!");
        }
    }
}
