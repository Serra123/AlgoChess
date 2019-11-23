package Vistas;

import Tablero.Tablero;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class JuegoPrincipal {

    private Stage stage;
    String jugadorUno;
    String jugadorDos;
    Tablero tablero;

    public void iniciar(Stage stage,String jugadorUno,String jugadorDos) {

        this.stage = stage;
        this.jugadorUno = jugadorUno;
        this.jugadorDos = jugadorDos;
        this.tablero = new Tablero(20,20,jugadorUno,jugadorDos);

        VBox filas = new VBox(0);
        Label sectorDeJugador1 = new Label();
        sectorDeJugador1.setText("Sector de jugador 1: "+ jugadorUno);
        filas.getChildren().add(sectorDeJugador1);

        inicializarTablero(filas);

        Label sectorDeJugador2 = new Label();
        sectorDeJugador2.setText("Sector de jugador 2: "+ jugadorDos);
        filas.getChildren().add(sectorDeJugador2);


        //layoutJuego.setPadding(new Insets(20,20,20,10));
        //setLayoutJuego(layoutJuego);
        Scene tablero = new Scene(filas,1200,700);

        stage.setScene(tablero);

    }

    private void inicializarTablero(VBox filas) {

        filas.setPadding(new Insets(20,20,20,20));
        Button[][] celda = new Button[10][10];
        HBox [] fila = new HBox[10];

         for(int i=0;i<10;i++){
             fila[i] = new HBox(0);
             for(int j=0;j<10;j++){
                 celda[i][j] = new Button("");
                 fila[i].getChildren().add(celda[i][j]);
             }
             filas.getChildren().addAll(fila[i]);
        }

    }

    private void setLayoutJuego(VBox layoutJuego) {

        Label mensajeJuego = new Label();
        mensajeJuego.setText("mi primera cosa en el juego posta <3");
        layoutJuego.getChildren().addAll(mensajeJuego);

    }


}
