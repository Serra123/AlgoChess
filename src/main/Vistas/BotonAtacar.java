package Vistas;

import Controller.AtacarUnidadEventHandler;
import Controller.MoverUnidadEventHandler;
import Jugador.Jugador;
import Tablero.Tablero;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonAtacar extends Button {

    public BotonAtacar(Tablero tablero, InfoCasillero infoCasillero, Jugador jugadorActual, TableroView tableroView, Turno turno) {
        this.setPadding( new Insets(20,20,20,20));
        this.setText("Atacar");


        /*Image playI=new Image("casilleroApretado.jpg");
        ImageView iv1=new ImageView(playI);

        iv1.setScaleX(this.getScaleX());
        iv1.setScaleY(this.getScaleY());

        this.setGraphic(iv1);*/
        this.setStyle("-fx-background-image: url('imagenBotonAtacar.jpg')");
        this.setOnAction(new AtacarUnidadEventHandler(tablero,infoCasillero,jugadorActual,tableroView,turno));
    }
}
