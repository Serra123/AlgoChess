package Vistas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.Text;

public class Main extends Application implements EventHandler<ActionEvent>{
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{

        JuegoPrincipal juegoPrincipal = new JuegoPrincipal();

        stage.setTitle("Algo Chess");

        String jugadorUno = "JugadorUno";
        String jugadorDos = "JugadorDos";

        Label mensajeIngresoUsuarioUno = new Label();
        mensajeIngresoUsuarioUno.setText("Ingrese el nombre del jugador 1");

        Label mensajeIngresoUsuarioDos = new Label();
        mensajeIngresoUsuarioDos.setText("Ingrese el nombre del jugador 2");

        Label usuariosYaIngresados = new Label();

        TextField ingresoUsuarioUno = new TextField();
        TextField ingresoUsuarioDos = new TextField();

        Button usuariosIngresados = new Button("listo");
        Button inicioJuego = new Button("continuar");

        usuariosIngresados.setOnAction(e->nombreIngresado(ingresoUsuarioUno.getText(),jugadorUno,ingresoUsuarioDos.getText(),jugadorDos,usuariosYaIngresados));

        VBox layoutInicio = new VBox(30);
        layoutInicio.setPadding(new Insets(20,20,20,10));
        layoutInicio.getChildren().addAll(mensajeIngresoUsuarioUno,ingresoUsuarioUno,mensajeIngresoUsuarioDos,ingresoUsuarioDos,usuariosIngresados,usuariosYaIngresados,inicioJuego);

        inicioJuego.setOnAction(e->juegoPrincipal.iniciar(stage,jugadorUno,jugadorDos));

        Scene scene = new Scene(layoutInicio,400,400);
        stage.setScene(scene);
        stage.show();
    }

    private void nombreIngresado(String usuarioUnoIngresado, String jugadorUno, String usuarioDosIngresado, String jugadorDos, Label usuariosYaIngresados) {
        jugadorUno=usuarioUnoIngresado;
        jugadorDos=usuarioDosIngresado;
        usuariosYaIngresados.setText("Usuarios ingresados correctamente,\ningrese continuar para iniciar juego");
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("sapeeeee");
    }
}