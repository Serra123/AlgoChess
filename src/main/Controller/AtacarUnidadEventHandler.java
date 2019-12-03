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
import javafx.scene.layout.VBox;

public class AtacarUnidadEventHandler implements EventHandler<ActionEvent> {


    private final JuegoPrincipal juegoPrincipal;
    private Jugador jugadorAtacado;
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
        this.jugadorAtacado = obtenerJugadorAtacado();

    }

    @Override
    public void handle(ActionEvent actionEvent)  {
        VBox statusTablero = faseTurnos.getStatusTablero();
        statusTablero.getChildren().clear();

        Posicion posicionAMover = infoCasilleroBox.getPosicion();
        LabelNombreJugador jugador = new LabelNombreJugador(-270,0,jugadorActual.getNombre());
        LabelDatosJuego instrucciones = new LabelDatosJuego(-270,0,"Seleccione con que unidad desea \natacar y luego listo");
        Button listo = new Button ("listo");
        listo.setTranslateX(-270);
        infoCasilleroBox.setText("");
        infoCasilleroBox.setTranslateX(-270);
        statusTablero.getChildren().addAll(jugador,instrucciones,listo,infoCasilleroBox);
        listo.setOnAction(e -> {
            Posicion nuevaPosicion = infoCasilleroBox.getPosicion();
            infoCasilleroBox.setTranslateX(0);
            try {
                Unidad unidadAtacante =tablero.getUnidadDe(posicionAMover,jugadorActual);
                Unidad unidadAtacada =tablero.getUnidad(nuevaPosicion);
                unidadAtacante.atacar(unidadAtacada, tablero);
                tableroView.actualizar();
                tableroView.mostrar(nuevaPosicion);
                jugadorAtacado.verificarSiPierde();
                faseTurnos.cambiarJugador();
            } catch (ExcepcionCasilleroVacio error) {
                String cabecera = "Esta posicion esta vacia";
                String contenido = "Selecciona una posicion con unidad";
                new AlertaErrorEnTurno(cabecera,contenido,tableroView,faseTurnos);
            } catch (ExcepcionUnidadNoPerteneceATuEjercito error) {
                String cabecera = "No podes atacar con una unidad que no pertenece a tu ejercito";
                String contenido = "Selecciona una unidad propia e intenta nuevamente";
                new AlertaErrorEnTurno(cabecera,contenido,tableroView,faseTurnos);
            } catch(ExcepcionAtaqueAAliado error){
                String cabecera = "No podes atacar a un aliado";
                String contenido = "Selecciona una unidad enemiga e intenta nuevamente";
                new AlertaErrorEnTurno(cabecera,contenido,tableroView,faseTurnos);
            } catch(ExcepcionCuranderoNoAtaca error){
                String cabecera = "No podes atacar con un curandero";
                String contenido = "Selecciona una unidad que sí ataque";
                new AlertaErrorEnTurno(cabecera,contenido,tableroView,faseTurnos);
            }
            catch (ExcepcionDistanciaAtaqueInvalida error){
                String cabecera = "La unidad a atacar esta fuera de rango";
                String contenido = "Selecciona una unidad dentro del rango de ataque";
                new AlertaErrorEnTurno(cabecera,contenido,tableroView,faseTurnos);
            } catch(ExcepcionCatapultaNoAtacaAliados error){
                String cabecera = "La catapulta no puede atacar directamente a un aliado";
                String contenido = "Selecciona una unidad enemiga a la cual atacar";
                new AlertaErrorEnTurno(cabecera,contenido,tableroView,faseTurnos);
            }
            catch (ExcepcionFinDeJuego error){
                new AlertaFinDeJuego(jugadorActual.getNombre(),juegoPrincipal.getVentana());
            }
        });
    }

    private Jugador obtenerJugadorAtacado() {
        if(this.juegoPrincipal.getJugadorUno()==jugadorActual){
            return juegoPrincipal.getJugadorDos();
        }
        else{
            return juegoPrincipal.getJugadorUno();
        }
    }
}
