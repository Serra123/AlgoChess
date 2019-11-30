package Vistas.FaseJuego.FaseTurnos;

import Vistas.FaseJuego.JuegoPrincipal;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class FaseTurnos {

    private JuegoPrincipal juegoPrincipal; //referencia a la FaseJuego
    private BorderPane juegoView;
    private OpcionesTurno statusTablero;



    public FaseTurnos(JuegoPrincipal juegoPrincipal){
        this.juegoPrincipal = juegoPrincipal;
        this.juegoView = juegoPrincipal.getJuegoView();
        this.statusTablero = new OpcionesTurno(juegoPrincipal);
        this.juegoView.setRight(statusTablero);

    }
}
