package Vistas;

import Jugador.Jugador;
import Tablero.Tablero;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AgregarUnidades extends VBox {

    private Jugador jugadorUno;
    private Jugador jugadorDos;
    private Jugador jugadorActual;
    private InfoCasillero infoCasillero;
    private Tablero tablero;
    private TableroView tableroView;
    private MenuDeOpciones opcionesView;

    public AgregarUnidades(TableroView tableroView, InfoCasillero infoCasillero, Tablero tablero, Jugador jugadorUno, Jugador jugadorDos, boolean jugadorUnoYaColoco, MenuDeOpciones opcionesView) {

        this.jugadorUno = jugadorUno;
        this.jugadorDos = jugadorDos;
        this.jugadorActual = jugadorUno;
        this.infoCasillero = infoCasillero;
        this.tablero = tablero;
        this.tableroView = tableroView;
        this.opcionesView = opcionesView;

        this.iniciar();

    }

    public void cambiarJugador() {
        jugadorActual = jugadorDos;
        this.iniciar();
    }

    public void iniciar(){
        this.getChildren().clear();

        Label jugador = new Label(jugadorActual.getNombre());
        Label opcionesIngreso = new Label("Clickee la posicion donde desea crear unidad \nY LUEGO la unidad que desee");
        Insets configBotonesOpcionesUnidades = new Insets(20,20,20,20);

        ButtonCrearUnidad crearSoldado = new ButtonCrearUnidad("Soldado",tablero,jugadorActual,infoCasillero,tableroView);
        crearSoldado.setMinWidth(this.getPrefWidth());
        crearSoldado.setPadding(configBotonesOpcionesUnidades);

        ButtonCrearUnidad crearJinete = new ButtonCrearUnidad("Jinete",tablero,jugadorActual,infoCasillero,tableroView);
        crearJinete.setMinWidth(this.getPrefWidth());
        crearJinete.setPadding(configBotonesOpcionesUnidades);

        ButtonCrearUnidad crearCurandero = new ButtonCrearUnidad("Curandero",tablero,jugadorActual,infoCasillero,tableroView);
        crearCurandero.setMinWidth(this.getPrefWidth());
        crearCurandero.setPadding(configBotonesOpcionesUnidades);

        ButtonCrearUnidad crearCatapulta = new ButtonCrearUnidad("Catapulta",tablero,jugadorActual,infoCasillero,tableroView);
        crearCatapulta.setMinWidth(this.getPrefWidth());
        crearCatapulta.setPadding(configBotonesOpcionesUnidades);

        BotonFrenarCreacionUnidades botonFrenarCreacionUnidades = new BotonFrenarCreacionUnidades("Listo",jugadorUno,jugadorActual,this,opcionesView);
        botonFrenarCreacionUnidades.setStyle("-fx-background-color: #2FD00C;-fx-font-size: 2em");
        botonFrenarCreacionUnidades.setPadding( new Insets(15,15,15,15));


        this.getChildren().addAll(jugador,opcionesIngreso,crearSoldado,crearJinete,crearCurandero,crearCatapulta,botonFrenarCreacionUnidades);

    }
}

