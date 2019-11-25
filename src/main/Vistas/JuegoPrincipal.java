package Vistas;

import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.Soldado;
import Unidades.Unidad;
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

    public void iniciar(Stage stage,String jugadorUno,String jugadorDos) {



        nombreJugadorUno = jugadorUno;
        nombreJugadorDos = jugadorDos;

        this.jugadorUno = new Jugador(nombreJugadorUno);
        this.jugadorDos = new Jugador(nombreJugadorDos);

        this.tablero = new Tablero(20,20,jugadorUno,jugadorDos);

        this.casillero = new Button[20][20];

        VBox opcionesDeJuego = new VBox();

        Label espacioGenerado = new Label();
        espacioGenerado.setText("\n\n\n");
        //Button agregarUnidadesJugadorUno = new Button("Agregar undades jugador uno");
        //agregarUnidadesJugadorUno.setPadding(new Insets(20,20,20,20));
        //Button agregarUnidadesJugadorDos = new Button("Agregar undades jugador dos");
        //agregarUnidadesJugadorDos.setPadding(new Insets(20,20,20,20));

        VBox opcionesParaCrearUnidades = new VBox();
        opcionesParaCrearUnidades.setPrefWidth(200);
        opcionesParaCrearUnidades.setSpacing(10);
        Label infoTablero = new Label();
        //infoTablero.setText(" ");

        colocarUnidadesDe(this.jugadorUno,opcionesParaCrearUnidades,infoTablero);
        opcionesDeJuego.setSpacing(10);
        opcionesDeJuego.getChildren().addAll(espacioGenerado,opcionesParaCrearUnidades,infoTablero);

        VBox vistaTablero = new VBox(0);
        Label sectorDeJugador1 = new Label();
        sectorDeJugador1.setText("Sector de jugador 1: "+ jugadorUno);
        vistaTablero.getChildren().add(sectorDeJugador1);

        inicializarTablero(vistaTablero,infoTablero);

        Label sectorDeJugador2 = new Label();
        sectorDeJugador2.setText("Sector de jugador 2: "+ jugadorDos);
        vistaTablero.getChildren().add(sectorDeJugador2);

        HBox pantalla = new HBox(0);

        pantalla.getChildren().addAll(vistaTablero,opcionesDeJuego);

        Scene tablero = new Scene(pantalla,1500,800);

        stage.setScene(tablero);
        stage.show();

    }

    private void colocarUnidadesDe(Jugador jugadorRecibido, VBox opcionesParaCrearUnidades,Label infoPosicionClickeada) {

        opcionesParaCrearUnidades.getChildren().clear();

        Label inicioCreacionUnidades = new Label();
        inicioCreacionUnidades.setText(jugadorRecibido.getNombre()+"\n seleccione la posicion \n Y LUEGO la unidad que quiera crear");
        opcionesParaCrearUnidades.getChildren().add(inicioCreacionUnidades);

        Insets configBotonesOpcionesUnidades = new Insets(20,20,20,20);

        Button opcionSoldado = new Button("Soldado");
        opcionSoldado.setMinWidth(opcionesParaCrearUnidades.getPrefWidth());
        opcionSoldado.setPadding(configBotonesOpcionesUnidades);
        opcionSoldado.setOnAction(e->crearUnidad("Soldado",opcionesParaCrearUnidades,jugadorRecibido,infoPosicionClickeada));

        Button opcionCurandero = new Button("Curandero");
        opcionCurandero.setMinWidth(opcionesParaCrearUnidades.getPrefWidth());
        opcionCurandero.setPadding(configBotonesOpcionesUnidades);
        opcionCurandero.setOnAction(e->crearUnidad("Curandero",opcionesParaCrearUnidades,jugadorRecibido,infoPosicionClickeada));

        Button opcionJinete = new Button("Jinete");
        opcionJinete.setMinWidth(opcionesParaCrearUnidades.getPrefWidth());
        opcionJinete.setPadding(configBotonesOpcionesUnidades);
        opcionJinete.setOnAction(e->crearUnidad("Jinete",opcionesParaCrearUnidades,jugadorRecibido,infoPosicionClickeada));

        Button opcionCatapulta = new Button("Catapulta");
        opcionCatapulta.setMinWidth(opcionesParaCrearUnidades.getPrefWidth());
        opcionCatapulta.setPadding(configBotonesOpcionesUnidades);
        opcionCatapulta.setOnAction(e->crearUnidad("Catapulta",opcionesParaCrearUnidades,jugadorRecibido,infoPosicionClickeada));

        Button continuar = new Button("Continuar");
        continuar.setPadding( new Insets(15,15,15,15));

        opcionesParaCrearUnidades.getChildren().addAll(opcionCatapulta,opcionCurandero,opcionJinete,opcionSoldado);

        if( jugadorRecibido.getNombre() == nombreJugadorUno ){
            continuar.setOnAction( e-> colocarUnidadesDe(jugadorDos, opcionesParaCrearUnidades,infoPosicionClickeada));
        }
        else {
            continuar.setOnAction( e-> JugadorUnoAtacar(jugadorUno,opcionesParaCrearUnidades,infoPosicionClickeada));
        }
    }

    private void JugadorUnoAtacar(Jugador jugadorDos, VBox opcionesParaCrearUnidades,Label infoPosicionClickeada){

        opcionesParaCrearUnidades.getChildren().clear();
        Label inicioCreacionUnidades = new Label("aaaaaaaaaaaaa");
        opcionesParaCrearUnidades.getChildren().add(inicioCreacionUnidades);

    }



    private void crearUnidad(String unidadElegida, VBox opcionesParaCrearUnidades, Jugador jugadorRecibido,Label infoTablero) {

        Label opcionElegida = new Label();
        opcionesParaCrearUnidades.getChildren().add(opcionElegida);

        try {
            jugadorRecibido.crearUnidadEnPosicion(posicionClickeada, unidadElegida, tablero);
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
                 casillero[i][j].setUserData(posicion);
                 int finalI = i;
                 int finalJ = j;

                 casillero[i][j].setOnAction(e->informacionCasillero(casillero[finalI][finalJ],(Posicion) casillero[finalI][finalJ].getUserData(),infoUsuarioClickeado));
                 informacionCasillero(casillero[finalI][finalJ],(Posicion) casillero[finalI][finalJ].getUserData(),infoUsuarioClickeado);
                 fila[i].getChildren().add(casillero[i][j]);
             }
             vistaTablero.getChildren().addAll(fila[i]);
        }

    }
    private void informacionCasillero(Button boton,Posicion posicion,Label infousuarioClickeado) {
        Unidad unidad;
        posicionClickeada= posicion;
        int fila = posicion.getFila()+1;
        int columna = posicion.getColumna()+1;
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
