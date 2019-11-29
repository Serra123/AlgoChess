package Vistas;

import Jugador.Jugador;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int POSICIONNOMBREJUGADORUNO = 0;
    private static final int POSICIONNOMBREJUGADORDOS = 1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        inicializarJuego();
    }

    private void inicializarJuego(){

        String[] nombreJugadores = FaseInicio.display();
        Jugador jugadorUno = new Jugador(nombreJugadores[POSICIONNOMBREJUGADORUNO]);
        Jugador jugadorDos = new Jugador(nombreJugadores[POSICIONNOMBREJUGADORDOS]);

        FaseJuego.display(jugadorUno, jugadorDos);

    }

}