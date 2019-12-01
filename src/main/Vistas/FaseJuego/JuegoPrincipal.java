package Vistas.FaseJuego;

import Jugador.Jugador;
import Tablero.Tablero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class JuegoPrincipal {

    private static final int LADO = 20;

    private Tablero tableroDeJuego;
    private Jugador jugadorActual;
    private Jugador jugadorUno;
    private Jugador jugadorDos;
    private InfoCasilleroBox infoCasilleroBox;
    private TableroView tableroView;
    private BorderPane juegoView;
    private Stage ventana;

    public JuegoPrincipal(Jugador jugadorUno, Jugador jugadorDos){
        this.jugadorUno = jugadorUno;
        this.jugadorDos = jugadorDos;
        this.tableroDeJuego = new Tablero(LADO,LADO,jugadorUno.getNombre(),jugadorDos.getNombre());
        this.jugadorActual = jugadorUno;
        this.infoCasilleroBox = new InfoCasilleroBox(this,"");
        this.tableroView = new TableroView(this);
        this.ventana = new Stage();
        this.juegoView = new BorderPane();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("AlgoChess - Agregar Unidades");
        ventana.setMinWidth(500);
        juegoView.setPadding(new Insets(10,200,0,0));
        Label tituloJuego = new Label("AlgoChess");
        BorderPane.setAlignment(tituloJuego, Pos.CENTER);
        juegoView.setTop(tituloJuego);
        juegoView.setLeft(tableroView);

    }

    public void cambiarJugador(){
        if(this.getJugadorUno().getNombre() == jugadorActual.getNombre()){
            this.jugadorActual = this.getJugadorDos();
        }else{
            this.jugadorActual = this.getJugadorUno();
        }
    }

    public Jugador getJugadorActual(){
        return this.jugadorActual;
    }
    public InfoCasilleroBox getInfoCasilleroBox(){
        return infoCasilleroBox;
    }
    public TableroView getTableroView(){
        return tableroView;
    }
    public Tablero getTableroDeJuego(){ return tableroDeJuego;}
    public Jugador getJugadorUno(){ return jugadorUno;}
    public Jugador getJugadorDos(){ return jugadorDos;}
    public BorderPane getJuegoView(){ return juegoView;}
    public Stage getVentana(){ return ventana;}

}