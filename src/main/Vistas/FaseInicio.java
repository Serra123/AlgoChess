package Vistas;

import Jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class FaseInicio extends VBox {
    public FaseInicio(Jugador jugadorUno, Jugador jugadorDos){
        Insets formatoFaseInicio = new Insets(20,20,20,20);
        Label ingreseNombreUsuarioUno = new Label();
        ingreseNombreUsuarioUno.setText("Ingrese nombre de usuario uno");
        ingreseNombreUsuarioUno.setPadding(formatoFaseInicio);

        TextField campoNombreUsuarioUno = new TextField();
        campoNombreUsuarioUno.setPadding(formatoFaseInicio);

        Label ingreseNombreUsuarioDos = new Label();
        ingreseNombreUsuarioDos.setText("Ingrese nombre de usuario dos");
        ingreseNombreUsuarioDos.setPadding(formatoFaseInicio);

        Button continuar = new Button("continuar");

        TextField campoNombreUsuarioDos = new TextField();
        campoNombreUsuarioDos.setPrefSize(20,20);

        this.getChildren().addAll(ingreseNombreUsuarioUno,campoNombreUsuarioUno,ingreseNombreUsuarioDos,campoNombreUsuarioDos,continuar);

        this.setSpacing(20);

    }
}
