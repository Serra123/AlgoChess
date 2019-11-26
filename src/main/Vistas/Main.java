package Vistas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage){

        JuegoPrincipal juegoPrincipal = new JuegoPrincipal();

        stage.setTitle("Algo Chess");

        String jugadorUno = "JugadorUno";
        String jugadorDos = "JugadorDos";


        Label mensajeIngresoUsuarioUno = new Label();
        mensajeIngresoUsuarioUno.setText("Ingrese el nombre del jugador 1");

        Label mensajeIngresoUsuarioDos = new Label();
        mensajeIngresoUsuarioDos.setText("Ingrese el nombre del jugador 2");

        TextField ingresoUsuarioUno = new TextField();
        TextField ingresoUsuarioDos = new TextField();

        Button inicioJuego = new Button("Continuar");

        VBox layoutInicio = new VBox(30);
        layoutInicio.setPadding(new Insets(20,20,20,10));
        layoutInicio.getChildren().addAll(mensajeIngresoUsuarioUno,ingresoUsuarioUno,mensajeIngresoUsuarioDos,ingresoUsuarioDos,inicioJuego);

        Scene scene = new Scene(layoutInicio,400,400);
        stage.setScene(scene);
        stage.show();

        inicioJuego.setOnAction(e->juegoPrincipal.iniciar(stage,jugadorUno,jugadorDos));
    }

}