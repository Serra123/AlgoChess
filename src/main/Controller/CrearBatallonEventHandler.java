package Controller;

import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Batallon;
import Unidades.Posicion.Posicion;
import Vistas.InfoCasillero;
import Vistas.TableroView;
import Vistas.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import Jugador.Ejercito;

import java.util.ArrayList;

public class CrearBatallonEventHandler implements EventHandler<ActionEvent> {

    private Jugador jugadorActual;
    private InfoCasillero infoCasillero;
    private Tablero tablero;
    private TableroView tableroView;
    private Turno turno;

    public CrearBatallonEventHandler(Tablero tablero, InfoCasillero infoCasillero, Jugador jugadorActual, TableroView tableroView, Turno turno) {
        this.jugadorActual = jugadorActual;
        this.tablero = tablero;
        this.tableroView = tableroView;
        this.infoCasillero = infoCasillero;
        this.turno = turno;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        ArrayList<Posicion> posiciones = new ArrayList();
        tableroView.agregarCasillerosClickeadosALista(posiciones);
        turno.getChildren().clear();
        Label seleccionSoldadosBatallon = new Label("Seleccione 3 soldados para formar un batallon");
        Button listo = new Button("listo");

        turno.getChildren().addAll(seleccionSoldadosBatallon,listo);
        listo.setOnAction(e->{
            turno.getChildren().clear();
            tableroView.resetearComportamientoDeCasilleros();

            Label cantidadPosiciones = new Label("tenes: "+posiciones.size()+"posiciones");
            turno.getChildren().add(cantidadPosiciones);
            for(int i=0;i<posiciones.size();i++){
                Label label = new Label(posiciones.get(i).getFila()+";"+posiciones.get(i).getColumna());
                turno.getChildren().add(label);
            }
            Ejercito ejercito = jugadorActual.getEjercito();
            try{
                Batallon batallon = ejercito.crearBatallon(posiciones);
                Label seleccionDirecion = new Label("Seleccione la direccion en la que desea mover el batallon");
                Button listoDos = new Button("listo");
                turno.getChildren().addAll(seleccionDirecion,listoDos);
                listoDos.setOnAction(f->{
                    Posicion nuevaPosicion = infoCasillero.getPosicion();
                    infoCasillero.setText(nuevaPosicion.getFila()+";"+nuevaPosicion.getColumna());

                    batallon.agregarTablero(tablero);
                    batallon.moverBatallon(nuevaPosicion);
                    tableroView.actualizar();
                    tableroView.mostrar(nuevaPosicion);
                    turno.setTurno(true);
                });
            }catch(Exception error){
                infoCasillero.setText("Algo salio mal");
                turno.setTurno(true);
            }
        });
    }
}
