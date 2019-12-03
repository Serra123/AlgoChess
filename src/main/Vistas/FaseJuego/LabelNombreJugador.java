package Vistas.FaseJuego;


import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LabelNombreJugador extends Label {
    public LabelNombreJugador(int x,int y,String texto) {
        this.setText(texto);
        this.setAlignment(Pos.CENTER);
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
        this.setStyle("-fx-background-image: url('fondoTexto.jpg')");
        this.setFont(new Font("Arial",25));
    }
}
