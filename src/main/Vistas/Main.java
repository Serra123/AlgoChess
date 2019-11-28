package Vistas;

import Jugador.Jugador;
import Tablero.Tablero;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Jugador jugadorUno;
    private Jugador jugadorDos;
    private Tablero tablero;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        inicializarJuego(stage);
    }

    private void inicializarJuego(Stage stage){
        Scene scene = new Scene(new FaseInicio(jugadorUno,jugadorDos),400,400);
        stage.setScene(scene);
        stage.show();

    }
}