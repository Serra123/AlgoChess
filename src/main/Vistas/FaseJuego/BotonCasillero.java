package Vistas.FaseJuego;

import Controller.CasilleroEventHandler;
import Controller.CasilleroParaBatallonEventHandler;
import Unidades.Posicion.Posicion;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class BotonCasillero extends Button {

    private final String colorInicial;
    private JuegoPrincipal faseDeJuego;
    private Posicion posicion;


    BotonCasillero(JuegoPrincipal faseDeJuego, Posicion unaPosicion, String unColor){
        this.faseDeJuego = faseDeJuego;
        this.posicion = unaPosicion;
        this.colorInicial = unColor;
        this.setPrefSize(50,34);
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
        this.setStyle(unColor);
        this.setOnAction(new CasilleroEventHandler(faseDeJuego,unaPosicion,this));
    }

    public void cambiarEventHandlerParaCrearBatallon(ArrayList<Posicion> listaPosiciones) {
        this.setOnAction(new CasilleroParaBatallonEventHandler(faseDeJuego,posicion,this,listaPosiciones));
    }

    public void resetarEventHandler() {
        this.setOnAction(new CasilleroEventHandler(faseDeJuego,posicion,this));
    }

    public String getColorInicial() {
        return this.colorInicial;
    }
}
