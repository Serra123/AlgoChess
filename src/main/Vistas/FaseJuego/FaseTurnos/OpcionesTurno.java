package Vistas.FaseJuego.FaseTurnos;

import Jugador.Jugador;
import Vistas.FaseJuego.JuegoPrincipal;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class OpcionesTurno extends VBox {

    private JuegoPrincipal juegoPrincipal; // referencia a la FaseJuego a la que pertenece
    private Jugador jugadorUno;
    private Jugador jugadorDos;
    private Jugador jugadorActual;

    public OpcionesTurno(JuegoPrincipal juegoPrincipal) {

        this.juegoPrincipal = juegoPrincipal;
        this.jugadorUno = juegoPrincipal.getJugadorUno();
        this.jugadorDos = juegoPrincipal.getJugadorDos();
        this.jugadorActual = juegoPrincipal.getJugadorActual();
        this.setTurno(false);
    }

    public void cambiarJugador(){
        if(jugadorUno.getNombre()==jugadorActual.getNombre()){
            jugadorActual=jugadorDos;
            this.setTurno(false);
        }else{
            jugadorActual=jugadorUno;
            this.setTurno(false);
        }
    }

    public void setTurno(boolean yaMovio) {
        this.getChildren().clear();

        Label jugador = new Label(jugadorActual.getNombre());
        Label opcionesDeTurno = new Label("Indique que accion desea realizar");

        BotonMover mover = new BotonMover(juegoPrincipal,this);

        BotonAtacar atacar = new BotonAtacar(juegoPrincipal,this);

        BotonCurar curar = new BotonCurar(juegoPrincipal,this);

        BotonCrearBatallon crearBatallon = new BotonCrearBatallon(juegoPrincipal,this);

        BotonPasar pasar = new BotonPasar(this);

        this.setSpacing(10);
        if(!yaMovio){
            this.getChildren().addAll(jugador,opcionesDeTurno,mover,crearBatallon,atacar,curar,pasar);
        }else {
            this.getChildren().addAll(jugador,opcionesDeTurno,atacar,curar,pasar);
        }
    }
}
