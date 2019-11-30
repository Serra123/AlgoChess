package Controller;

import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Batallon;
import Unidades.Posicion.Posicion;
import Vistas.FaseJuego.JuegoPrincipal;
import Vistas.FaseJuego.InfoCasilleroBox;
import Vistas.FaseJuego.TableroView;
import Vistas.FaseJuego.FaseTurnos.OpcionesTurno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import Jugador.Ejercito;

import java.util.ArrayList;

public class CrearBatallonEventHandler implements EventHandler<ActionEvent> {

    private Jugador jugadorActual;
    private InfoCasilleroBox infoCasilleroBox;
    private Tablero tablero;
    private TableroView tableroView;
    private OpcionesTurno opcionesTurno;

    public CrearBatallonEventHandler(JuegoPrincipal juegoPrincipal, OpcionesTurno opcionesTurno) {
        this.jugadorActual = juegoPrincipal.getJugadorActual();
        this.tablero = juegoPrincipal.getTableroDeJuego();
        this.tableroView = juegoPrincipal.getTableroView();
        this.infoCasilleroBox = juegoPrincipal.getInfoCasilleroBox();
        this.opcionesTurno = opcionesTurno;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        ArrayList<Posicion> posiciones = new ArrayList();
        tableroView.agregarCasillerosClickeadosALista(posiciones);
        opcionesTurno.getChildren().clear();
        Label seleccionSoldadosBatallon = new Label("Seleccione 3 soldados para formar un batallon");
        Button listo = new Button("listo");

        opcionesTurno.getChildren().addAll(seleccionSoldadosBatallon,listo);
        listo.setOnAction(e->{
            opcionesTurno.getChildren().clear();
            tableroView.resetearComportamientoDeCasilleros();

            Label cantidadPosiciones = new Label("tenes: "+posiciones.size()+"posiciones");
            opcionesTurno.getChildren().add(cantidadPosiciones);
            for (Posicion posicion : posiciones) {
                Label label = new Label(posicion.getFila() + ";" + posicion.getColumna());
                opcionesTurno.getChildren().add(label);
            }
            Ejercito ejercito = jugadorActual.getEjercito();
            try{
                Batallon batallon = ejercito.crearBatallon(posiciones);
                Label seleccionDirecion = new Label("Seleccione la direccion en la que desea mover el batallon");
                Button listoDos = new Button("listo");
                opcionesTurno.getChildren().addAll(seleccionDirecion,listoDos);
                listoDos.setOnAction(f->{
                    Posicion nuevaPosicion = infoCasilleroBox.getPosicion();
                    infoCasilleroBox.setText(nuevaPosicion.getFila()+";"+nuevaPosicion.getColumna());

                    batallon.agregarTablero(tablero);
                    batallon.moverBatallon(nuevaPosicion);
                    tableroView.actualizar();
                    tableroView.mostrar(nuevaPosicion);
                    opcionesTurno.setTurno(true);
                });
            }catch(Exception error){
                infoCasilleroBox.setText("Algo salio mal");
                opcionesTurno.setTurno(true);
            }
        });
    }
}
