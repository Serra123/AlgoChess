package Controller;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionPuntosInsuficientes;
import Excepciones.ExcepcionSectorEnemigo;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Vistas.FaseJuego.FaseAgregarUnidades.FaseAgregarUnidades;
import Vistas.FaseJuego.InfoCasilleroBox;
import Vistas.FaseJuego.JuegoPrincipal;
import Vistas.FaseJuego.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CrearUnidadEventHandler implements EventHandler<ActionEvent> {

    private InfoCasilleroBox infoCasilleroBox;
    private String unidadACrear;
    private Tablero tablero;
    private Jugador jugadorActual;
    private TableroView tableroView;

    public CrearUnidadEventHandler(String unidadACrear, Jugador jugadorActual, JuegoPrincipal juegoPrincipal) {
        this.infoCasilleroBox = juegoPrincipal.getInfoCasilleroBox();
        this.unidadACrear = unidadACrear;
        this.tablero = juegoPrincipal.getTableroDeJuego();
        this.tableroView = juegoPrincipal.getTableroView();
        this.jugadorActual = jugadorActual;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Posicion unaPosicion = infoCasilleroBox.getPosicion();
        try {
            jugadorActual.crearUnidadEnPosicion(unaPosicion, unidadACrear, tablero);
            tableroView.actualizar(); //Actualiza el tablero entero
            tableroView.mostrar(unaPosicion); // Me muestra la ultima posicion creada
            // sin esto, me muestra siempre (20,20) automaticamente por ser la ultima en actualizarse
        } catch (ExcepcionSectorEnemigo e){
            infoCasilleroBox.setText("Este no es tu sector");
        } catch(ExcepcionCasilleroOcupado e){
            infoCasilleroBox.setText("Este casillero esta Ocupado!! ");
        }catch(ExcepcionPuntosInsuficientes e){
            infoCasilleroBox.setText("No te alcanzan los Puntos!");
        }
    }
}
