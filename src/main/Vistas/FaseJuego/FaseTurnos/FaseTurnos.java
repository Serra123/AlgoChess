package Vistas.FaseJuego.FaseTurnos;

import Controller.AlertaFinDeJuego;
import Excepciones.ExcepcionFinDeJuego;
import Jugador.Jugador;
import Vistas.FaseJuego.JuegoPrincipal;
import Vistas.FaseJuego.LabelDatosJuego;
import Vistas.FaseJuego.LabelNombreJugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class FaseTurnos {

    private JuegoPrincipal juegoPrincipal;
    private BorderPane juegoView;
    private VBox statusTablero;
    private Boolean yaMovio;



    public FaseTurnos(JuegoPrincipal juegoPrincipal){
        this.juegoPrincipal = juegoPrincipal;
        this.juegoView = juegoPrincipal.getJuegoView();
        this.statusTablero = new VBox();
        this.statusTablero.setPadding(new Insets(0,0,0,0));
        this.yaMovio = false;
        this.mostrarLayoutFaseParaJugadorActual();
        this.juegoView.setRight(statusTablero);


    }

    public void cambiarJugador(){

        juegoPrincipal.cambiarJugador();
        try{
            juegoPrincipal.getJugadorActual().verificarSiPierde();
        }catch (ExcepcionFinDeJuego error){
            Jugador jugadorQueGana = this.getJugadorGanador();
            new AlertaFinDeJuego(jugadorQueGana.getNombre(),juegoPrincipal.getVentana());
        }
        yaMovio = false;
        this.mostrarLayoutFaseParaJugadorActual();
    }

    private Jugador getJugadorGanador() {
        if(juegoPrincipal.getJugadorActual() == juegoPrincipal.getJugadorUno()){
            return juegoPrincipal.getJugadorDos();
        }else return juegoPrincipal.getJugadorUno();
    }


    public void jugadorYaMovio(){
        yaMovio = true;
        this.mostrarLayoutFaseParaJugadorActual();
    }


    public void mostrarLayoutFaseParaJugadorActual(){

        this.statusTablero.getChildren().clear();
        LabelNombreJugador jugador = new LabelNombreJugador(0,0,"Es el turno de: " + juegoPrincipal.getJugadorActual().getNombre()+".");
        LabelDatosJuego opcionesDeTurno = new LabelDatosJuego(0,50,"Indique la posicion que desee utilizar, \no para crear un batallon");

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


}




