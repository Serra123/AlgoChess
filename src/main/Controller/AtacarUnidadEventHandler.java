package Controller;

import Excepciones.*;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.Unidad;
import Vistas.FaseJuego.*;
import Vistas.FaseJuego.FaseTurnos.FaseTurnos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AtacarUnidadEventHandler implements EventHandler<ActionEvent> {


    private final JuegoPrincipal juegoPrincipal;
    private Jugador jugadorActual;
    private InfoCasilleroBox infoCasilleroBox;
    private Tablero tablero;
    private TableroView tableroView;
    private FaseTurnos faseTurnos;

    public AtacarUnidadEventHandler(JuegoPrincipal juegoPrincipal, FaseTurnos faseTurnos) {

        this.jugadorActual = juegoPrincipal.getJugadorActual();
        this.tablero = juegoPrincipal.getTableroDeJuego();
        this.tableroView = juegoPrincipal.getTableroView();
        this.infoCasilleroBox = juegoPrincipal.getInfoCasilleroBox();
        this.juegoPrincipal = juegoPrincipal;
        this.faseTurnos = faseTurnos;

    }

    @Override
    public void handle(ActionEvent actionEvent)  {
        VBox statusTablero = faseTurnos.getStatusTablero();
        statusTablero.getChildren().clear();

        LabelNombreJugador jugador = new LabelNombreJugador(-250,0,jugadorActual.getNombre());
        LabelDatosJuego instrucciones = new LabelDatosJuego(-250,0,"Seleccione con que unidad desea \natacar y luego listo");
        Button listo = new Button ("listo");
        listo.setTranslateX(-250);
        infoCasilleroBox.setText("");
        infoCasilleroBox.setTranslateX(-250);
        statusTablero.getChildren().addAll(jugador,instrucciones,listo,infoCasilleroBox);

        listo.setOnAction(f-> {
            Posicion posicionAMover = infoCasilleroBox.getPosicion();
            instrucciones.setText("Seleccione a que unidad que desea \natacar y luego listo");

            listo.setOnAction(e -> {
                Posicion nuevaPosicion = infoCasilleroBox.getPosicion();
                infoCasilleroBox.setTranslateX(0);
                try {
                    Unidad unidadAtacante =tablero.getUnidadDe(posicionAMover,jugadorActual);
                    Unidad unidadAtacada =tablero.getUnidad(nuevaPosicion);
                    unidadAtacante.atacar(unidadAtacada, tablero);
                    if(unidadAtacada.getVida() <= 0 ){
                        if(unidadAtacada.getEjercito().equals(juegoPrincipal.getJugadorUno().getNombre())){
                            juegoPrincipal.getJugadorUno().getEjercito().eliminarUnidad(unidadAtacada);
                        }else{
                            juegoPrincipal.getJugadorDos().getEjercito().eliminarUnidad(unidadAtacada);
                        }
                    }
                    tableroView.actualizar();
                    tableroView.mostrar(nuevaPosicion);
                    verificarSiTerminoJuego();
                    faseTurnos.cambiarJugador();
                } catch (ExcepcionCasilleroVacio error) {
                    String cabecera = "Esta posicion esta vacia";
                    String contenido = "Selecciona una posicion con unidad";
                    new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,true);
                } catch (ExcepcionUnidadNoPerteneceATuEjercito error) {
                    String cabecera = "No podes atacar con una unidad que no pertenece a tu ejercito";
                    String contenido = "Selecciona una unidad propia e intenta nuevamente";
                    new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,true);
                } catch(ExcepcionAtaqueAAliado error){
                    String cabecera = "No podes atacar a un aliado";
                    String contenido = "Selecciona una unidad enemiga e intenta nuevamente";
                    new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,true);
                } catch(ExcepcionCuranderoNoAtaca error){
                    String cabecera = "No podes con un curandero";
                    String contenido = "Selecciona una unidad que sí ataque";
                    new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,true);
                }
                catch (ExcepcionDistanciaAtaqueInvalida error){
                    String cabecera = "La unidad a atacar esta fuera de rango";
                    String contenido = "Selecciona una unidad dentro del rango de ataque";
                    new ExcepcionTurnoEventHandler(cabecera,contenido,tableroView,faseTurnos,true);
                }
            });
        });
    }

    private void verificarSiTerminoJuego() {
        if(juegoPrincipal.getJugadorUno().getNombre().equals(jugadorActual.getNombre())){
           if(juegoPrincipal.getJugadorDos().getEjercito().ejercitoVacio()){
               new ExcepcionFinDeJuegoEventHandler(juegoPrincipal.getJugadorUno().getNombre());
           }
        }else if(juegoPrincipal.getJugadorDos().getNombre().equals(jugadorActual.getNombre())){
            if(juegoPrincipal.getJugadorUno().getEjercito().ejercitoVacio()){
                new ExcepcionFinDeJuegoEventHandler(juegoPrincipal.getJugadorDos().getNombre());
            }
        }


    }
}
