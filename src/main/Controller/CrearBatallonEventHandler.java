package Controller;

import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Batallon;
import Unidades.Posicion.Posicion;
import Vistas.FaseJuego.FaseTurnos.FaseTurnos;
import Vistas.FaseJuego.JuegoPrincipal;
import Vistas.FaseJuego.InfoCasilleroBox;
import Vistas.FaseJuego.TableroView;
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
        Label seleccionSoldadosBatallon = new Label("Seleccione 3 soldados para formar un batallon");
        Button listo = new Button("listo");

        statusTablero.getChildren().addAll(seleccionSoldadosBatallon,listo);
        listo.setOnAction(e->{
            statusTablero.getChildren().clear();
            tableroView.resetearComportamientoDeCasilleros();

            Label cantidadPosiciones = new Label("tenes: "+posiciones.size()+"posiciones");
            statusTablero.getChildren().add(cantidadPosiciones);
            for (Posicion posicion : posiciones) {
                Label label = new Label(posicion.getFila() + ";" + posicion.getColumna());
                statusTablero.getChildren().add(label);
            }
            Ejercito ejercito = jugadorActual.getEjercito();
            try{
                Batallon batallon = ejercito.crearBatallon(posiciones);
                Label seleccionDirecion = new Label("Seleccione la direccion en la que desea mover el batallon");
                Button listoDos = new Button("listo");
                statusTablero.getChildren().addAll(seleccionDirecion,listoDos);
                listoDos.setOnAction(f->{
                    Posicion nuevaPosicion = infoCasilleroBox.getPosicion();
                    infoCasilleroBox.setText(nuevaPosicion.getFila()+";"+nuevaPosicion.getColumna());

                    batallon.agregarTablero(tablero);
                    batallon.moverBatallon(nuevaPosicion);
                    tableroView.actualizar();
                    tableroView.mostrar(nuevaPosicion);
                    faseTurnos.crearLayoutFaseParaJugadorActual(true);
                });
            }catch(Exception error){
                infoCasilleroBox.setText("Algo salio mal");
                faseTurnos.crearLayoutFaseParaJugadorActual(true);
            }
        });
    }
}
