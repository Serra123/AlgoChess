package Vistas.FaseJuego.FaseAgregarUnidades;

import Jugador.Jugador;
import Vistas.FaseJuego.JuegoPrincipal;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class FaseAgregarUnidades {


    private JuegoPrincipal juegoPrincipal;
    private VBox statusTablero;
    private Jugador jugadorActual;
    private BorderPane juegoView;

    public FaseAgregarUnidades(JuegoPrincipal juegoPrincipal) {
        this.juegoPrincipal = juegoPrincipal;
        this.statusTablero = new VBox();
        jugadorActual = juegoPrincipal.getJugadorActual();
        this.statusTablero.setPrefWidth(500);
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
        Label jugador = new Label("Es el turno de: " + this.getJugadorActual().getNombre()+".");
        jugador.setTranslateX(30);
        jugador.setTranslateY(20);
        jugador.setFont(new Font("Arial",25));
        Label puntosJugadorActual = new Label();
        puntosJugadorActual.setTranslateY(50);
        Label opcionesIngreso = new Label("Clickee la posicion donde desea crear una unidad y luego el tipo de \nunidad que desee.");
        opcionesIngreso.setTranslateY(55);
        Insets configBotonesOpcionesUnidades = new Insets(20,20,20,20);

        ButtonCrearUnidad crearSoldado = new ButtonCrearUnidad("Soldado",this.getJugadorActual(),juegoPrincipal, puntosJugadorActual);
        crearSoldado.setMinWidth(statusTablero.getPrefWidth()/2);
        crearSoldado.setPadding(configBotonesOpcionesUnidades);

        ButtonCrearUnidad crearJinete = new ButtonCrearUnidad("Jinete",this.getJugadorActual(),juegoPrincipal,puntosJugadorActual);
        crearJinete.setMinWidth(statusTablero.getPrefWidth()/2);
        crearJinete.setPadding(configBotonesOpcionesUnidades);

        HBox cajaBotonesUno = new HBox();
        cajaBotonesUno.getChildren().addAll(crearSoldado,crearJinete);
        cajaBotonesUno.setTranslateY(75);

        ButtonCrearUnidad crearCurandero = new ButtonCrearUnidad("Curandero",this.getJugadorActual(),juegoPrincipal,puntosJugadorActual);
        crearCurandero.setMinWidth(statusTablero.getPrefWidth()/2);
        crearCurandero.setPadding(configBotonesOpcionesUnidades);

        ButtonCrearUnidad crearCatapulta = new ButtonCrearUnidad("Catapulta",this.getJugadorActual(),juegoPrincipal,puntosJugadorActual);
        crearCatapulta.setMinWidth(statusTablero.getPrefWidth()/2);
        crearCatapulta.setPadding(configBotonesOpcionesUnidades);

        HBox cajaBotonesDos = new HBox();
        cajaBotonesDos.getChildren().addAll(crearCurandero,crearCatapulta);
        cajaBotonesDos.setTranslateY(75);

        BotonFrenarCreacionUnidades botonFrenarCreacionUnidades = new BotonFrenarCreacionUnidades("Listo",juegoPrincipal,this);
        botonFrenarCreacionUnidades.setStyle("-fx-background-color: #2FD00C;-fx-font-size: 2em");
        botonFrenarCreacionUnidades.setPadding( new Insets(15,15,15,15));
        botonFrenarCreacionUnidades.setTranslateY(400);
        botonFrenarCreacionUnidades.setTranslateX(400);

        statusTablero.getChildren().addAll(jugador,puntosJugadorActual,opcionesIngreso,cajaBotonesUno,cajaBotonesDos,botonFrenarCreacionUnidades,juegoPrincipal.getInfoCasilleroBox());
        return statusTablero;
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }
}

