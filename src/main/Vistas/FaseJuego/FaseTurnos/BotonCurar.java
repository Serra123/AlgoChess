package Vistas.FaseJuego.FaseTurnos;

import Controller.CurarUnidadEventHandler;
import Vistas.FaseJuego.JuegoPrincipal;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class BotonCurar extends Button {

    public BotonCurar(JuegoPrincipal juegoPrincipal, OpcionesTurno opcionesTurno){
        this.setPadding( new Insets(20,20,20,20));
        this.setText("Curar");
        this.setStyle("-fx-background-image: url('imagenBotonCurar.jpg')");
        this.setOnAction(new CurarUnidadEventHandler(juegoPrincipal, opcionesTurno));
    }

}
