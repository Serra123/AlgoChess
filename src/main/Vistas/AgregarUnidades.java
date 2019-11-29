package Vistas;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AgregarUnidades extends VBox {

    public AgregarUnidades(){
        Label opcionesIngreso = new Label("Clickee la posicion donde desea crear unidad \nY LUEGO la unidad que desee");
        ButtonCrearUnidad crearSoldado = new ButtonCrearUnidad("Soldado");
        ButtonCrearUnidad crearJinete = new ButtonCrearUnidad("Jinete");
        ButtonCrearUnidad crearCurandero = new ButtonCrearUnidad("Curandero");
        ButtonCrearUnidad crearCatapulta = new ButtonCrearUnidad("Catapulta");


        this.getChildren().addAll(opcionesIngreso,crearSoldado,crearJinete,crearCurandero,crearCatapulta);

    }
}

