package Vistas;

import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import Unidades.Unidad;
import Unidades.UnidadMovible;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JuegoPrincipal {

    private Jugador jugadorUno;
    private Jugador jugadorDos;
    private String nombreJugadorUno;
    private String nombreJugadorDos;
    private Tablero tablero;
    private Posicion posicionClickeada;
    private Button[][] casillero;
    private VBox opcionesDeJuego;

    public void iniciar(Stage stage,String jugadorUno,String jugadorDos) {



        nombreJugadorUno = jugadorUno;
        nombreJugadorDos = jugadorDos;

        this.jugadorUno = new Jugador(nombreJugadorUno);
        this.jugadorDos = new Jugador(nombreJugadorDos);

        this.tablero = new Tablero(20,20,jugadorUno,jugadorDos);

        this.casillero = new Button[20][20];

        VBox infoTablero = new VBox();

        Label espacioGenerado = new Label();
        espacioGenerado.setText("\n\n\n");


        opcionesDeJuego = new VBox();
        opcionesDeJuego.setPrefWidth(200);
        opcionesDeJuego.setSpacing(10);
        Label infoUnidad = new Label();

        colocarUnidadesDe(this.jugadorUno,infoUnidad);
        infoTablero.setSpacing(10);
        infoTablero.getChildren().addAll(espacioGenerado,opcionesDeJuego,infoUnidad);

        VBox vistaTablero = new VBox(0);
        Label sectorDeJugador1 = new Label();
        sectorDeJugador1.setText("Sector de jugador 1: "+ jugadorUno);
        vistaTablero.getChildren().add(sectorDeJugador1);

        inicializarTablero(vistaTablero,infoUnidad);

        Label sectorDeJugador2 = new Label();
        sectorDeJugador2.setText("Sector de jugador 2: "+ jugadorDos);
        vistaTablero.getChildren().add(sectorDeJugador2);

        HBox pantalla = new HBox(0);

        pantalla.getChildren().addAll(vistaTablero,infoTablero);

        Scene tablero = new Scene(pantalla,1500,800);

        stage.setScene(tablero);
        stage.show();

    }

    private void colocarUnidadesDe(Jugador jugadorRecibido,Label infoTablero) {

        opcionesDeJuego.getChildren().clear();

        Label inicioCreacionUnidades = new Label();
        inicioCreacionUnidades.setText(jugadorRecibido.getNombre()+"\n\n seleccione la posicion \n Y LUEGO \n la unidad que quiera crear");
        opcionesDeJuego.getChildren().add(inicioCreacionUnidades);

        Insets configBotonesOpcionesUnidades = new Insets(20,20,20,20);

        Button opcionSoldado = new Button("Soldado");
        opcionSoldado.setMinWidth(opcionesDeJuego.getPrefWidth());
        opcionSoldado.setPadding(configBotonesOpcionesUnidades);
        opcionSoldado.setOnAction(e->crearUnidad("Soldado",jugadorRecibido,infoTablero));

        Button opcionCurandero = new Button("Curandero");
        opcionCurandero.setMinWidth(opcionesDeJuego.getPrefWidth());
        opcionCurandero.setPadding(configBotonesOpcionesUnidades);
        opcionCurandero.setOnAction(e->crearUnidad("Curandero",jugadorRecibido,infoTablero));

        Button opcionJinete = new Button("Jinete");
        opcionJinete.setMinWidth(opcionesDeJuego.getPrefWidth());
        opcionJinete.setPadding(configBotonesOpcionesUnidades);
        opcionJinete.setOnAction(e->crearUnidad("Jinete",jugadorRecibido,infoTablero));

        Button opcionCatapulta = new Button("Catapulta");
        opcionCatapulta.setMinWidth(opcionesDeJuego.getPrefWidth());
        opcionCatapulta.setPadding(configBotonesOpcionesUnidades);
        opcionCatapulta.setOnAction(e->crearUnidad("Catapulta",jugadorRecibido,infoTablero));

        Button continuar = new Button("Continuar");
        continuar.setStyle("-fx-background-color: #2FD00C;-fx-font-size: 2em");
        continuar.setPadding( new Insets(15,15,15,15));

        opcionesDeJuego.getChildren().addAll(opcionCatapulta,opcionCurandero,opcionJinete,opcionSoldado,continuar);


        if( jugadorRecibido.getNombre() == nombreJugadorUno ){
            continuar.setOnAction( e-> colocarUnidadesDe(jugadorDos,infoTablero));
        }
        else {
            continuar.setOnAction( e-> turno(jugadorUno,false));
        }
    }

    private void turno(Jugador jugadorRecibido,boolean movio){

        opcionesDeJuego.getChildren().clear();
        Label OpcionesDeTurno = new Label("Opciones de turno:" );

        Button mover = new Button("Mover");
        mover.setPadding( new Insets(15,15,15,15));
        mover.setOnAction(e->elegirUnidadAMover(jugadorRecibido));

        Button atacar = new Button("Atacar");
        atacar.setPadding( new Insets(15,15,15,15));
        atacar.setOnAction( e-> atacar(jugadorUno));

        if(movio) {
            opcionesDeJuego.getChildren().addAll(OpcionesDeTurno, mover, atacar);
        } else{
            opcionesDeJuego.getChildren().addAll(OpcionesDeTurno, atacar);
        }

    }

    private void elegirUnidadAMover(Jugador jugadorRecibido) {

        Label seleccioneUnidadAMover = new Label("seleccione la unidad que desee mover");

        Button unidadAMoverSelecionada = new Button();
        unidadAMoverSelecionada.setText("Listo");

        unidadAMoverSelecionada.setOnAction(e->eleginuevaPosicion(jugadorRecibido));

        opcionesDeJuego.getChildren().addAll(seleccioneUnidadAMover,unidadAMoverSelecionada);
    }

    private void eleginuevaPosicion(Jugador jugadorRecibido){

        //opcionesParaCrearUnidades.getChildren().clear();

        Posicion posicionAnterior = new Posicion(posicionClickeada);

        Label seleccioneUnidadAMover = new Label("seleccione la posicion a donde la desea mover");

        Button unidadAMoverSelecionada = new Button();
        unidadAMoverSelecionada.setText("Listo");

        unidadAMoverSelecionada.setOnAction(e->moverUnidad(jugadorRecibido,posicionAnterior));

        opcionesDeJuego.getChildren().addAll(seleccioneUnidadAMover,unidadAMoverSelecionada);

    }

    private void moverUnidad(Jugador jugadorRecibido, Posicion posicionAnterior) {
        Posicion posicionNueva = new Posicion(posicionClickeada);
        try{
            UnidadMovible unidad= (UnidadMovible) tablero.getUnidad(posicionAnterior);
            unidad.mover(posicionNueva,tablero);
            actualizarCasillero(casillero[posicionClickeada.getFila()][posicionClickeada.getColumna()],posicionClickeada);
            actualizarCasillero(casillero[posicionAnterior.getFila()][posicionAnterior.getColumna()],posicionAnterior);
            turno(jugadorRecibido,true);
        } catch(RuntimeException e){
            turno(jugadorRecibido,false);
        }

        //get unidad de jugador recibido en la posicion anterior
        //unidad.mover(nuevaPosicion)

    }


    private void atacar(Jugador jugadorRecibido){

        Button continuar = new Button("Continuar");
        continuar.setPadding( new Insets(15,15,15,15));

        if( jugadorRecibido.getNombre() == nombreJugadorUno ){
            continuar.setOnAction( e-> turno(jugadorDos,true));
        }
        else {
            continuar.setOnAction( e-> turno(jugadorUno,true));
        }

    }



    private void crearUnidad(String unidadElegida, Jugador jugadorRecibido,Label infoTablero) {

        Label opcionElegida = new Label();
        opcionesDeJuego.getChildren().add(opcionElegida);

        try {
            jugadorRecibido.crearUnidadEnPosicion(posicionClickeada, unidadElegida, tablero);
            informacionCasillero(casillero[posicionClickeada.getFila()][posicionClickeada.getColumna()],posicionClickeada,infoTablero);
            informacionCasillero(casillero[posicionClickeada.getFila()][posicionClickeada.getColumna()],posicionClickeada,infoTablero);
        } catch (RuntimeException e){
            infoTablero.setText("No podes crear esa unidad ahí");
        }

    }


    private void inicializarTablero(VBox vistaTablero,Label infoUsuarioClickeado) {

        vistaTablero.setPadding(new Insets(20,20,20,20));
        //Si uso la clase event handler,no puedo depender luego de la posicion a la que haga click porque ya lo inicialice con otra
        //ClickearCasilleroEventHandler[][] clickearCasilleroEventHandler = new ClickearCasilleroEventHandler[20][20];
        HBox [] fila = new HBox[20];

         for(int i=0;i<20;i++){
             fila[i] = new HBox(0);
             for(int j=0;j<20;j++){
                 Posicion posicion = new Posicion(i,j);
                 casillero[i][j] = new Button(" ");
                 casillero[i][j].setPrefSize(50,30);
                 //casillero[i][j].setUserData(posicion);
                 int finalI = i;
                 int finalJ = j;

                 casillero[i][j].setOnAction(e->informacionCasillero(casillero[finalI][finalJ],posicion,infoUsuarioClickeado));
                 informacionCasillero(casillero[finalI][finalJ],posicion,infoUsuarioClickeado);
                 fila[i].getChildren().add(casillero[i][j]);
             }
             vistaTablero.getChildren().addAll(fila[i]);
        }

    }
    private void actualizarCasillero(Button boton,Posicion posicion){
        Unidad unidad;
        posicionClickeada= new Posicion(posicion);
        try {
            unidad = tablero.getUnidad(posicion);
            String textoCasillero =setearTextoCasillero(unidad.getTipoUnidad(),unidad.getEjercito());
            boton.setText(textoCasillero);
        }
        catch (RuntimeException e){
            boton.setText(" ");
        }
    }

    private void informacionCasillero(Button boton,Posicion posicion,Label infousuarioClickeado) {
        Unidad unidad;
        posicionClickeada= new Posicion(posicion);
        int fila = posicionClickeada.getFila()+1;
        int columna = posicionClickeada.getColumna()+1;
        try {
            unidad = tablero.getUnidad(posicion);
            infousuarioClickeado.setText("\n\n\nPosicion: ("+fila+";"+columna+")\nUnidad: "+unidad.getTipoUnidad()+"\nVida:"+unidad.getVida());
            String textoCasillero =setearTextoCasillero(unidad.getTipoUnidad(),unidad.getEjercito());
            boton.setText(textoCasillero);
        }
        catch (RuntimeException e){
            boton.setText(" ");
            infousuarioClickeado.setText("\n\n\nPosicion: ("+fila+";"+columna+")\nNo hay una unidad acá");
        }
    }

    private String setearTextoCasillero(String tipoUnidad, String ejercito) {
        String textoCasillero;
        switch (tipoUnidad){
            case "soldado": textoCasillero="s";
                break;
            case "curandero": textoCasillero="cu";
                break;
            case "catapulta": textoCasillero="ca";
                break;
            case "jinete": textoCasillero="j";
                break;
            default: textoCasillero="Nan";
        }
        if(ejercito==nombreJugadorUno){
            textoCasillero=textoCasillero+"1";
        }
        else{
            textoCasillero=textoCasillero+"2";
        }

        return textoCasillero;
    }

    private void setLayoutJuego(VBox layoutJuego) {

        Label mensajeJuego = new Label();
        mensajeJuego.setText("mi primera cosa en el juego posta <3");
        layoutJuego.getChildren().addAll(mensajeJuego);

    }


}
