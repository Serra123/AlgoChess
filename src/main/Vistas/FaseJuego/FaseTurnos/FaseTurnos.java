package Vistas.FaseJuego.FaseTurnos;

import Jugador.Jugador;
import Vistas.FaseJuego.JuegoPrincipal;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class FaseTurnos {

    private JuegoPrincipal juegoPrincipal; //referencia a la FaseJuego
    private BorderPane juegoView;
    private VBox statusTablero;
    private Jugador jugadorActual;



    public FaseTurnos(JuegoPrincipal juegoPrincipal){
        this.juegoPrincipal = juegoPrincipal;
        this.juegoView = juegoPrincipal.getJuegoView();
        this.jugadorActual = juegoPrincipal.getJugadorActual();
        this.statusTablero = new VBox();
        this.crearLayoutFaseParaJugadorActual(false);
        this.juegoView.setRight(statusTablero);


    }

    public void cambiarJugador(){

        juegoPrincipal.cambiarJugador();
        this.crearLayoutFaseParaJugadorActual(false);
    }



    public void crearLayoutFaseParaJugadorActual(boolean yaMovio){

        this.statusTablero.getChildren().clear();
        Label jugador = new Label(juegoPrincipal.getJugadorActual().getNombre());
        Label opcionesDeTurno = new Label("Indique que accion desea realizar");

        BotonMover mover = new BotonMover(juegoPrincipal,this);

        BotonAtacar atacar = new BotonAtacar(juegoPrincipal,this);

        BotonCurar curar = new BotonCurar(juegoPrincipal,this);

        BotonCrearBatallon crearBatallon = new BotonCrearBatallon(juegoPrincipal,this);

        BotonPasar pasar = new BotonPasar(this);

        this.statusTablero.setSpacing(10);
        if(!yaMovio){
            this.statusTablero.getChildren().addAll(jugador,opcionesDeTurno,mover,crearBatallon,atacar,curar,pasar);
        }else {
            this.statusTablero.getChildren().addAll(jugador,opcionesDeTurno,atacar,curar,pasar);
        }
        this.statusTablero.getChildren().add(juegoPrincipal.getInfoCasilleroBox());
    }
    public VBox getStatusTablero(){
        return this.statusTablero;
    }

    public Jugador getJugadorActual(){
        return jugadorActual;
    }

}




