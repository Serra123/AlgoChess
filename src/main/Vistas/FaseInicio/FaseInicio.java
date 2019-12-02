package Vistas.FaseInicio;

import Controller.AlertaErrorNombreDeJugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FaseInicio{

    private static String[] nombreJugadores = new String[2];

    public String[] display(){

        Stage unaVentana = new Stage();

        unaVentana.initModality(Modality.APPLICATION_MODAL);
        unaVentana.setTitle("AlgoChess: Seleccion de nombres");
        unaVentana.setMinWidth(400);

        VBox layoutGeneral = new VBox();
        layoutGeneral.setAlignment(Pos.CENTER);

        VBox seccionJugadorUno = new VBox();
        Label ingreseNombreUsuarioUno = new Label();
        ingreseNombreUsuarioUno.setText("Ingrese el nombre del jugador uno:");
        TextField campoNombreUsuarioUno = new TextField();
        campoNombreUsuarioUno.setPromptText("Jugador uno");
        campoNombreUsuarioUno.setAlignment(Pos.CENTER);
        campoNombreUsuarioUno.setMaxWidth(200);
        seccionJugadorUno.getChildren().addAll(ingreseNombreUsuarioUno,campoNombreUsuarioUno);
        seccionJugadorUno.setSpacing(10);
        seccionJugadorUno.setAlignment(Pos.CENTER);

        VBox seccionJugadorDos = new VBox();
        TextField campoNombreUsuarioDos = new TextField();
        campoNombreUsuarioDos.setAlignment(Pos.CENTER);
        campoNombreUsuarioDos.setPromptText("Jugador dos");
        campoNombreUsuarioDos.setMaxWidth(200);
        Label ingreseNombreUsuarioDos = new Label();
        ingreseNombreUsuarioDos.setText("Ingrese el nombre del jugador dos:");
        seccionJugadorDos.getChildren().addAll(ingreseNombreUsuarioDos,campoNombreUsuarioDos);
        seccionJugadorDos.setSpacing(10);
        seccionJugadorDos.setAlignment(Pos.CENTER);

        Button continuar = new Button("Continuar");
        continuar.setOnAction(e -> {
            Boolean nombreVacio = (campoNombreUsuarioDos.getText().isEmpty() ||
                    campoNombreUsuarioUno.getText().isEmpty());
            Boolean nombresIguales = (campoNombreUsuarioDos.getText().equals(campoNombreUsuarioUno.getText()));
            if(nombreVacio || nombresIguales) {
                new AlertaErrorNombreDeJugador();

            }else {
                nombreJugadores[0] = campoNombreUsuarioUno.getText();

                nombreJugadores[1] = campoNombreUsuarioDos.getText();

                unaVentana.close();
            }



        });

        layoutGeneral.getChildren().addAll(seccionJugadorUno,seccionJugadorDos,continuar);

        Insets formatoFaseInicio = new Insets(20,20,20,20);

        layoutGeneral.setSpacing(20);
        layoutGeneral.setPadding(formatoFaseInicio);

        Scene scene = new Scene(layoutGeneral);
        unaVentana.setScene(scene);
        unaVentana.showAndWait();

        return nombreJugadores;
    }

 }
