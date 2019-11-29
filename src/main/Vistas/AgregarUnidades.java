package Vistas;

import Jugador.Jugador;
import Tablero.Tablero;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AgregarUnidades extends VBox {


    public AgregarUnidades(InfoCasillero infoCasillero ,Tablero tablero, Jugador jugadorActual) {
        Label opcionesIngreso = new Label("Clickee la posicion donde desea crear unidad \nY LUEGO la unidad que desee");
        ButtonCrearUnidad crearSoldado = new ButtonCrearUnidad("Soldado",tablero,jugadorActual,infoCasillero);
        ButtonCrearUnidad crearJinete = new ButtonCrearUnidad("Jinete",tablero,jugadorActual,infoCasillero);
        ButtonCrearUnidad crearCurandero = new ButtonCrearUnidad("Curandero",tablero,jugadorActual,infoCasillero);
        ButtonCrearUnidad crearCatapulta = new ButtonCrearUnidad("Catapulta",tablero,jugadorActual,infoCasillero);


        this.getChildren().addAll(opcionesIngreso,crearSoldado,crearJinete,crearCurandero,crearCatapulta);


    }
}

