package Controller;

import Excepciones.*;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Curandero;
import Unidades.Posicion.Posicion;
import Unidades.Unidad;
import Vistas.FaseJuego.*;
import Vistas.FaseJuego.FaseTurnos.FaseTurnos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class CurarUnidadEventHandler implements EventHandler<ActionEvent> {

    private Jugador jugadorActual;
    private InfoCasilleroBox infoCasilleroBox;
    private Tablero tablero;
    private TableroView tableroView;
    private FaseTurnos faseTurnos;

    public CurarUnidadEventHandler(JuegoPrincipal juegoPrincipal, FaseTurnos faseTurnos) {

        this.jugadorActual = juegoPrincipal.getJugadorActual();
        this.tablero = juegoPrincipal.getTableroDeJuego();
        this.tableroView = juegoPrincipal.getTableroView();
        this.infoCasilleroBox = juegoPrincipal.getInfoCasilleroBox();
        this.faseTurnos = faseTurnos;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VBox statusTablero = faseTurnos.getStatusTablero();
        statusTablero.getChildren().clear();

        Posicion posicionAMover = infoCasilleroBox.getPosicion();
        LabelNombreJugador jugador = new LabelNombreJugador(-260,0,jugadorActual.getNombre());
        LabelDatosJuego instrucciones = new LabelDatosJuego(-260,60,"Seleccione a que unidad que desea \ncurar y luego listo");
        Button listo = new Button ("listo");
        listo.setTranslateX(-260);
        listo.setTranslateY(80);
        infoCasilleroBox.setText("");
        infoCasilleroBox.setTranslateX(-260);
        statusTablero.getChildren().addAll(jugador,instrucciones,listo,infoCasilleroBox);

        listo.setOnAction(e -> {
            Posicion nuevaPosicion = infoCasilleroBox.getPosicion();
            infoCasilleroBox.setTranslateX(0);
            try {
                Curandero unidadCurandera =(Curandero) tablero.getUnidadDe(posicionAMover,jugadorActual);   //verifico que sea de mi ejercito
                Unidad unidadACurar =tablero.getUnidad(nuevaPosicion);
                unidadCurandera.curar(unidadACurar);

                tableroView.actualizar();
                tableroView.mostrar(nuevaPosicion);
                faseTurnos.cambiarJugador();
            } catch (ExcepcionCasilleroVacio error) {
                String cabecera = "Esta posicion esta vacia";
                String contenido = "Selecciona una posicion con unidad";
                new AlertaErrorEnTurno(cabecera,contenido,tableroView,faseTurnos);
            } catch (ClassCastException error) {
                String cabecera = "No podes curar con una unidad que no es Curandero";
                String contenido = "Selecciona una curandero o realiza otra accion";
                new AlertaErrorEnTurno(cabecera,contenido,tableroView,faseTurnos);
            } catch (ExcepcionCuracionAEnemigo error){
                String cabecera = "No podes curar a una unidad enemiga";
                String contenido = "Cura a una ajena o realiza otra accion";
                new AlertaErrorEnTurno(cabecera,contenido,tableroView,faseTurnos);
            } catch(ExcepcionDistanciaCuracionInvalida error){
                String cabecera = "No podes curar a una unidad que está tan lejos";
                String contenido = "Cura a una que esté más cerca o realiza otra acción";
                new AlertaErrorEnTurno(cabecera,contenido,tableroView,faseTurnos);
            } catch(ExcepcionUnidadNoPerteneceATuEjercito error){
                String cabecera = "No podes curar con una unidad enemeiga";
                String contenido = "Utiliza tu propio curandero";
                new AlertaErrorEnTurno(cabecera,contenido,tableroView,faseTurnos);
            }
        });
    }
}
