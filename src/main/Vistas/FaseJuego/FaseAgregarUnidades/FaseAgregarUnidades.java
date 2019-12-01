package Vistas.FaseJuego.FaseAgregarUnidades;

import Jugador.Jugador;
import Vistas.FaseJuego.JuegoPrincipal;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class FaseAgregarUnidades {


    private JuegoPrincipal juegoPrincipal;
    private VBox statusTablero;
    private Jugador jugadorActual;
    private BorderPane juegoView;

    public FaseAgregarUnidades(JuegoPrincipal juegoPrincipal) {
        this.juegoPrincipal = juegoPrincipal;
        this.statusTablero = new VBox();
        jugadorActual = juegoPrincipal.getJugadorActual();
        this.statusTablero.setPrefWidth(300);
        VBox statusTablero = crearLayoutFaseParaJugadorActual();

        this.juegoView = juegoPrincipal.getJuegoView();
        this.juegoView.setRight(statusTablero);
    }

    public void display(){
        Scene scene = new Scene(juegoView,1300,1300);
        juegoPrincipal.getVentana().setScene(scene);
        juegoPrincipal.getVentana().showAndWait();
    }

    public void cambiarJugador() {
        jugadorActual = juegoPrincipal.getJugadorDos();
        statusTablero.getChildren().clear();
        this.statusTablero = this.crearLayoutFaseParaJugadorActual();

    }

    public VBox crearLayoutFaseParaJugadorActual(){
        Label jugador = new Label(this.getJugadorActual().getNombre());
        Label puntosJugadorActual = new Label();
        Label opcionesIngreso = new Label("Clickee la posicion donde desea crear unidad \nY LUEGO la unidad que desee");
        Insets configBotonesOpcionesUnidades = new Insets(20,20,20,20);

        ButtonCrearUnidad crearSoldado = new ButtonCrearUnidad("Soldado",this.getJugadorActual(),juegoPrincipal, puntosJugadorActual);
        crearSoldado.setMinWidth(statusTablero.getPrefWidth());
        crearSoldado.setPadding(configBotonesOpcionesUnidades);

        ButtonCrearUnidad crearJinete = new ButtonCrearUnidad("Jinete",this.getJugadorActual(),juegoPrincipal,puntosJugadorActual);
        crearJinete.setMinWidth(statusTablero.getPrefWidth());
        crearJinete.setPadding(configBotonesOpcionesUnidades);

        ButtonCrearUnidad crearCurandero = new ButtonCrearUnidad("Curandero",this.getJugadorActual(),juegoPrincipal,puntosJugadorActual);
        crearCurandero.setMinWidth(statusTablero.getPrefWidth());
        crearCurandero.setPadding(configBotonesOpcionesUnidades);

        ButtonCrearUnidad crearCatapulta = new ButtonCrearUnidad("Catapulta",this.getJugadorActual(),juegoPrincipal,puntosJugadorActual);
        crearCatapulta.setMinWidth(statusTablero.getPrefWidth());
        crearCatapulta.setPadding(configBotonesOpcionesUnidades);

        BotonFrenarCreacionUnidades botonFrenarCreacionUnidades = new BotonFrenarCreacionUnidades("Listo",juegoPrincipal,this);
        botonFrenarCreacionUnidades.setStyle("-fx-background-color: #2FD00C;-fx-font-size: 2em");
        botonFrenarCreacionUnidades.setPadding( new Insets(15,15,15,15));


        statusTablero.getChildren().addAll(jugador,puntosJugadorActual,opcionesIngreso,crearSoldado,crearJinete,crearCurandero,crearCatapulta,botonFrenarCreacionUnidades,juegoPrincipal.getInfoCasilleroBox());

        return statusTablero;
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }
}

