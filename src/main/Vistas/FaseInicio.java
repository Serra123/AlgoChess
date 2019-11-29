package Vistas;

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

    public static String[] display(){
        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("SELECCION DE NOMBRES");
        ventana.setMinWidth(300);

        VBox layoutGeneral = new VBox();
        layoutGeneral.setAlignment(Pos.CENTER);

        VBox seccionJugadorUno = new VBox();


        Label ingreseNombreUsuarioUno = new Label();
        ingreseNombreUsuarioUno.setText("Ingrese nombre de usuario uno");

        TextField campoNombreUsuarioUno = new TextField();
        campoNombreUsuarioUno.setAlignment(Pos.CENTER);
        campoNombreUsuarioUno.setMaxWidth(200);

        seccionJugadorUno.getChildren().addAll(ingreseNombreUsuarioUno,campoNombreUsuarioUno);
        seccionJugadorUno.setAlignment(Pos.CENTER);

        VBox seccionJugadorDos = new VBox();

        TextField campoNombreUsuarioDos = new TextField();
        campoNombreUsuarioDos.setAlignment(Pos.CENTER);
        campoNombreUsuarioDos.setMaxWidth(200);



        Label ingreseNombreUsuarioDos = new Label();

        ingreseNombreUsuarioDos.setText("Ingrese nombre de usuario dos");

        seccionJugadorDos.getChildren().addAll(ingreseNombreUsuarioDos,campoNombreUsuarioDos);
        seccionJugadorDos.setAlignment(Pos.CENTER);
        Button continuar = new Button("continuar");

        continuar.setOnAction(e -> {
            nombreJugadores[0] = campoNombreUsuarioUno.getText();

            nombreJugadores[1] = campoNombreUsuarioDos.getText();

            ventana.close();
        });

        layoutGeneral.getChildren().addAll(seccionJugadorUno,seccionJugadorDos,continuar);

        Insets formatoFaseInicio = new Insets(20,20,20,20);


        layoutGeneral.setSpacing(20);
        layoutGeneral.setPadding(formatoFaseInicio);

        Scene scene = new Scene(layoutGeneral);
        ventana.setScene(scene);
        ventana.showAndWait();




        return nombreJugadores;
    }
 }
