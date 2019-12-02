package Controller;

import Excepciones.ExcepcionCantidadInsuficienteDePosiciones;
import Excepciones.ExcepcionLasUnidadesEstanSeparadas;
import Excepciones.ExcepcionPosicionInvalida;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Batallon;
import Unidades.Posicion.Posicion;
import Vistas.FaseJuego.*;
import Vistas.FaseJuego.FaseTurnos.FaseTurnos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import Jugador.Ejercito;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CrearBatallonEventHandler implements EventHandler<ActionEvent> {

    private Jugador jugadorActual;
    private InfoCasilleroBox infoCasilleroBox;
    private Tablero tablero;
    private TableroView tableroView;
    private FaseTurnos faseTurnos;

    public CrearBatallonEventHandler(JuegoPrincipal juegoPrincipal, FaseTurnos faseTurnos) {
        this.jugadorActual = juegoPrincipal.getJugadorActual();
        this.tablero = juegoPrincipal.getTableroDeJuego();
        this.tableroView = juegoPrincipal.getTableroView();
        this.infoCasilleroBox = juegoPrincipal.getInfoCasilleroBox();
        this.faseTurnos = faseTurnos;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        ArrayList<Posicion> posiciones = new ArrayList();
        tableroView.agregarCasillerosClickeadosALista(posiciones);
        VBox statusTablero = this.faseTurnos.getStatusTablero();
        statusTablero.getChildren().clear();

        LabelNombreJugador jugador = new LabelNombreJugador(-190,0,"Es el turno de: " + jugadorActual.getNombre());
        LabelDatosJuego instrucciones = new LabelDatosJuego(-190,60,"Seleccione 3 soldados para formar un batallon");
        Button listo = new Button ("listo");
        listo.setTranslateX(-190);
        listo.setTranslateY(80);
        infoCasilleroBox.setText("");
        infoCasilleroBox.setTranslateX(-190);;
        statusTablero.getChildren().addAll(jugador,instrucciones,listo,infoCasilleroBox);
        listo.setOnAction(e->{
            tableroView.resetearComportamientoDeCasilleros();

            Ejercito ejercito = jugadorActual.getEjercito();
            try{
                infoCasilleroBox.setTranslateX(0);
                Batallon batallon = ejercito.crearBatallon(posiciones);
                infoCasilleroBox.setTranslateX(-190);
                instrucciones.setText("Seleccione la direccion a la que desea mover \na la posicion central del batallon creado");
                listo.setOnAction(f->{
                    infoCasilleroBox.setTranslateX(0);
                    Posicion nuevaPosicion = infoCasilleroBox.getPosicion();
                    infoCasilleroBox.setText(nuevaPosicion.getFila()+";"+nuevaPosicion.getColumna());

                    batallon.agregarTablero(tablero);
                    batallon.moverBatallon(nuevaPosicion);
                    tableroView.actualizar();
                    tableroView.mostrar(nuevaPosicion);
                    faseTurnos.crearLayoutFaseParaJugadorActual(true);
                });
            }catch(ExcepcionCantidadInsuficienteDePosiciones error){
                String cabecera = "Tenes que elegir 3 posiciones!";
                String contenido = "Selecciona 3 posiciones e intenta nuevamente";
                new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,false);
            } catch(ExcepcionPosicionInvalida error){
                String cabecera = "Las posiciones no contienen soldados";
                String contenido = "Selecciona posiciones con soldados e intenta nuevamente";
                new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,false);
            } catch(ExcepcionLasUnidadesEstanSeparadas error) {
                String cabecera = "Las unidades estan separadas";
                String contenido = "Selecciona posiciones contiguas e intenta nuevamente";
                new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,false);
            }
            /*catch(Exception error){
                infoCasilleroBox.setText("Algo salio mal");
                tableroView.actualizar();
                faseTurnos.crearLayoutFaseParaJugadorActual(false);
            }*/
        });
    }
}
