package Vistas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FaseJuego extends Application{

    private static int FILAS = 20;
    private static int COLUMNAS = 20;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage){

        BorderPane faseJuego = new BorderPane();

        Label tituloJuego = new Label("AlgoChess");
        faseJuego.setTop(tituloJuego);


        InfoCasillero infoCasillero = new InfoCasillero("aaaaa");

        TableroView tableroView = new TableroView(infoCasillero);
        faseJuego.setLeft(tableroView);
        faseJuego.setRight(infoCasillero);

        Scene scene = new Scene(faseJuego,1300,800);
        stage.setScene(scene);
        stage.show();
    }

    //private void inicializarJuego()

}