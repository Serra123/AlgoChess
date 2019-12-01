package Vistas.FaseJuego;

import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;

public class LabelDatosJuego extends Label {
    public LabelDatosJuego(int x,int y,String texto) {
        this.setText(texto);
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
        this.setStyle("-fx-background-image: url('fondoTexto.jpg')");
        this.setTranslateX(x);
        this.setTranslateY(y);
    }
}
