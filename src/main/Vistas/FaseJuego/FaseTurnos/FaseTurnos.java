package Vistas.FaseJuego.FaseTurnos;

import Jugador.Jugador;
import Vistas.FaseJuego.JuegoPrincipal;
import Vistas.FaseJuego.LabelDatosJuego;
import Vistas.FaseJuego.LabelNombreJugador;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class FaseTurnos {

    private JuegoPrincipal juegoPrincipal;
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
        LabelNombreJugador jugador = new LabelNombreJugador(50,20,"Es el turno del jugador: " + juegoPrincipal.getJugadorActual().getNombre());
        LabelDatosJuego opcionesDeTurno = new LabelDatosJuego(0,50,"Indique que accion desea realizar");

        BotonMover mover = new BotonMover(juegoPrincipal,this);
        mover.setMinWidth(500);
        mover.setTranslateY(80);

        BotonAtacar atacar = new BotonAtacar(juegoPrincipal,this);
        atacar.setMinWidth(500);
        atacar.setTranslateY(80);

        BotonCurar curar = new BotonCurar(juegoPrincipal,this);
        curar.setMinWidth(500);
        curar.setTranslateY(80);

        BotonCrearBatallon crearBatallon = new BotonCrearBatallon(juegoPrincipal,this);
        crearBatallon.setMinWidth(500);
        crearBatallon.setTranslateY(80);

        BotonPasar pasar = new BotonPasar(this);
        pasar.setMinWidth(500);
        pasar.setTranslateY(80);

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




