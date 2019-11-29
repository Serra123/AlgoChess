package Vistas;

import Jugador.Jugador;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        inicializarJuego(stage);
    }

    private void inicializarJuego(Stage stage){
        String[] nombreJugadores = FaseInicio.display();
        Jugador jugadorUno = new Jugador(nombreJugadores[0]);
        Jugador jugadorDos = new Jugador(nombreJugadores[1]);

        FaseJuego.display(jugadorUno, jugadorDos);



    }

}