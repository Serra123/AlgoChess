package Vistas;

import Jugador.Jugador;
import Tablero.Tablero;
import javafx.scene.layout.VBox;

public class MenuDeOpciones extends VBox {

    private TableroView tableroView;
    private InfoCasillero infoCasillero;
    private Tablero tablero;
    private Jugador jugadorUno;
    private Jugador jugadorDos;



    public MenuDeOpciones(TableroView tableroView , InfoCasillero infoCasillero,
                          Tablero tablero, Jugador jugadorUno, Jugador jugadorDos) {

        this.tableroView = tableroView;
        this.infoCasillero = infoCasillero;
        this.tablero = tablero;
        this.jugadorUno = jugadorUno;
        this.jugadorDos = jugadorDos;

        menuAgregarUnidades();
    }

    public void menuAgregarUnidades(){
        //this.getChildren().clear();
        this.getChildren().add(new AgregarUnidades(tableroView,infoCasillero,tablero,
                                jugadorUno,jugadorDos,false,this));
    }

    public void iniciarTurno() {
        this.getChildren().clear();
        this.getChildren().add(new Turno(tableroView, infoCasillero, tablero,
                                        jugadorUno,jugadorDos,this));
    }
}
