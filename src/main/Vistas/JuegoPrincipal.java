package Vistas;

import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import Unidades.Unidad;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
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


        VBox opcionesDeJuego = new VBox();

        Button agrearUnidadesJugadorUno = new Button("Agregar undades jugador uno");
        agrearUnidadesJugadorUno.setPadding(new Insets(20,20,20,20));
        Button agregarUnidadesJugadorDos = new Button("Agregar undades jugador dos");
        agregarUnidadesJugadorDos.setPadding(new Insets(20,20,20,20));

        Label infoUsuarioClickeado = new Label();
        infoUsuarioClickeado.setText(" ");


        opcionesDeJuego.getChildren().addAll(agrearUnidadesJugadorUno,agregarUnidadesJugadorDos,infoUsuarioClickeado);


        Posicion posicion = new Posicion(2,2);
        Soldado soldado = new Soldado(posicion,jugadorUno);
        tablero.colocarUnidad(soldado);
        VBox vistaTablero = new VBox(0);
        Label sectorDeJugador1 = new Label();
        sectorDeJugador1.setText("Sector de jugador 1: "+ jugadorUno);
        vistaTablero.getChildren().add(sectorDeJugador1);

        inicializarTablero(vistaTablero,infoUsuarioClickeado);

        Label sectorDeJugador2 = new Label();
        sectorDeJugador2.setText("Sector de jugador 2: "+ jugadorDos);
        vistaTablero.getChildren().add(sectorDeJugador2);

        HBox pantalla = new HBox(0);

        pantalla.getChildren().addAll(vistaTablero,opcionesDeJuego);

        Scene tablero = new Scene(pantalla,1200,900);

        stage.setScene(tablero);
        stage.show();

    }

    private void inicializarTablero(VBox vistaTablero,Label infoUsuarioClickeado) {

        vistaTablero.setPadding(new Insets(20,20,20,20));
        Button[][] celda = new Button[20][20];
        HBox [] fila = new HBox[20];

         for(int i=0;i<20;i++){
             fila[i] = new HBox(0);
             for(int j=0;j<20;j++){
                 Posicion posicion = new Posicion(i,j);
                 celda[i][j] = new Button(" ");
                 celda[i][j].setPrefSize(50,30);
                 celda[i][j].setUserData(posicion);
                 int finalI = i;
                 int finalJ = j;
                 celda[i][j].setOnAction(e->informacionCasillero((Posicion) celda[finalI][finalJ].getUserData(),infoUsuarioClickeado));
                 fila[i].getChildren().add(celda[i][j]);
             }
             vistaTablero.getChildren().addAll(fila[i]);
        }

    }
    private Unidad informacionCasillero(Posicion posicion,Label infousuarioClickeado) {
        Unidad unidad;
        int fila = posicion.getFila()+1;
        int columna = posicion.getColumna()+1;
        try {
            unidad = tablero.getUnidad(posicion);

            infousuarioClickeado.setText("\n\n\nPosicion: ("+fila+";"+columna+")\nUnidad: "+unidad.getTipoUnidad()+"\nVida:"+unidad.getVida());
            return unidad;
        }
        catch (RuntimeException e){
            infousuarioClickeado.setText("\n\n\nNo hay un soldado acá");
            return null;
        }
    }

    private void setLayoutJuego(VBox layoutJuego) {

        Label mensajeJuego = new Label();
        mensajeJuego.setText("mi primera cosa en el juego posta <3");
        layoutJuego.getChildren().addAll(mensajeJuego);

    }


}
