package Vistas;

import Jugador.Jugador;
import Vistas.FaseInicio.FaseInicio;
import Vistas.FaseJuego.FaseAgregarUnidades.FaseAgregarUnidades;
import Vistas.FaseJuego.JuegoPrincipal;
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

        FaseInicio faseInicio = new FaseInicio();
        String[] nombreJugadores = faseInicio.display();
        Jugador jugadorUno = new Jugador(nombreJugadores[POSICIONNOMBREJUGADORUNO]);
        Jugador jugadorDos = new Jugador(nombreJugadores[POSICIONNOMBREJUGADORDOS]);

        JuegoPrincipal juegoPrincipal = new JuegoPrincipal(jugadorUno,jugadorDos);

        FaseAgregarUnidades faseAgregarUnidades = new FaseAgregarUnidades(juegoPrincipal);
        faseAgregarUnidades.display();

    }

}