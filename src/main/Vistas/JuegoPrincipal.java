package Vistas;

import Excepciones.ExcepcionCasilleroOcupado;
import Excepciones.ExcepcionCasilleroVacio;
import Excepciones.ExcepcionPuntosInsuficientes;
import Excepciones.ExcepcionSectorEnemigo;
import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.Unidad;
import Unidades.UnidadMovible;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JuegoPrincipal {

    private Jugador jugadorUno;
    private Jugador jugadorDos;
    private Tablero tablero;
    private Label infoCasilleroClickeado;
    private Button botonClickeado;
    private VBox opcionesDeJuego;

    public void iniciar(Stage stage,String jugadorUno,String jugadorDos) {


        this.jugadorUno = new Jugador(jugadorUno);
        this.jugadorDos = new Jugador(jugadorDos);

        this.tablero = new Tablero(20,20,jugadorUno,jugadorDos);
        infoCasilleroClickeado = new Label();
        VBox infoTablero = new VBox();
        infoTablero.setSpacing(100);


        VBox tableroConSectores = new VBox();

        Label sectorDeJugador1 = new Label();
        sectorDeJugador1.setText("Sector de jugador 1: "+ this.jugadorUno.getNombre());

        GridPane layoutTablero = new GridPane();



        Label sectorDeJugador2 = new Label();
        sectorDeJugador2.setText("Sector de jugador 2: "+ this.jugadorDos.getNombre());
        layoutTablero.getChildren().add(sectorDeJugador2);

        tableroConSectores.getChildren().addAll(sectorDeJugador1,layoutTablero,sectorDeJugador2);

        Label tituloDeInterfazJuego = new Label("ESTE ES EL TITULO DEL JUEGO");


        BorderPane layoutPrincipal = new BorderPane();
        layoutPrincipal.setTop(tituloDeInterfazJuego);
        layoutPrincipal.setCenter(tableroConSectores);
        layoutPrincipal.setRight(infoTablero);


        opcionesDeJuego = new VBox();
        opcionesDeJuego.setPrefWidth(200);
        opcionesDeJuego.setSpacing(10);


        colocarUnidadesDe(this.jugadorUno,infoCasilleroClickeado);
        infoTablero.getChildren().addAll(opcionesDeJuego,infoCasilleroClickeado);



        inicializarTablero(layoutTablero,infoCasilleroClickeado);



        HBox pantalla = new HBox(0);

        pantalla.getChildren().add(layoutPrincipal);

        Scene tablero = new Scene(pantalla,1500,800);

        stage.setScene(tablero);
        stage.show();

    }

    private void inicializarTablero(GridPane layoutTablero,Label infoCasilleroClickeado) {

        //Si uso la clase event handler,no puedo depender luego de la posicion a la que haga click porque ya lo inicialice con otra
        //ClickearCasilleroEventHandler[][] clickearCasilleroEventHandler = new ClickearCasilleroEventHandler[20][20];
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20;j++){
                Button unBoton = new Button();
                unBoton.setPrefSize(50,30);
                Posicion unaPosicion = new Posicion(i,j);
                unBoton.setUserData(unaPosicion);
                unBoton.setOnAction(e -> informacionCasillero(unBoton));
                informacionCasillero(unBoton);
                layoutTablero.add(unBoton,j,i);
            }
        }

    }

    private void informacionCasillero(Button boton) {

        Posicion unaPosicion = (Posicion) boton.getUserData();
        int fila = unaPosicion.getFila()+1;
        int columna = unaPosicion.getColumna()+1;

        //botonClickeado = new Button();
        //Posicion laMismaPosicion = new Posicion(unaPosicion);
        //botonClickeado.setUserData(laMismaPosicion);
        botonClickeado = boton;

        Unidad unidad;
        try {
            unidad = tablero.getUnidad(unaPosicion);
            infoCasilleroClickeado.setText("Posicion: ("+fila+";"+columna+")\nUnidad: "+unidad.getTipoUnidad()+"\nVida:"+unidad.getVida());
            String textoCasillero = setearTextoCasillero(unidad.getTipoUnidad(),unidad.getEjercito());
            boton.setText(textoCasillero);
        }
        catch (ExcepcionCasilleroVacio e){
            boton.setText("");
            infoCasilleroClickeado.setText("Posicion: ("+fila+";"+columna+")\nNo hay una unidad acá");
        }

    }


    private void crearUnidad(String unidadElegida, Jugador jugadorRecibido,Label infoTablero) {
        try {
            Posicion unaPosicion = (Posicion) botonClickeado.getUserData();
            jugadorRecibido.crearUnidadEnPosicion(unaPosicion, unidadElegida, tablero);
            informacionCasillero(botonClickeado);
        } catch (ExcepcionSectorEnemigo e){
            infoTablero.setText("Este no es tu sector");
        } catch(ExcepcionCasilleroOcupado e){
            infoTablero.setText("Este casillero esta Ocupado!! ");
        }catch(ExcepcionPuntosInsuficientes e){
            infoTablero.setText("No te alcanzan los Puntos!");
        }

    }

    private void colocarUnidadesDe(Jugador jugadorRecibido,Label infoTablero) {

        opcionesDeJuego.getChildren().clear();

        Label inicioCreacionUnidades = new Label();
        inicioCreacionUnidades.setText(jugadorRecibido.getNombre()+"\n\n Seleccione la posicion Y LUEGO la unidad que quiera crear");
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


        if( jugadorRecibido.getNombre() == this.jugadorUno.getNombre() ){
            continuar.setOnAction( e-> colocarUnidadesDe(jugadorDos,infoTablero));
        }
        else {
            continuar.setOnAction( e-> turno(jugadorUno,false));
        }
    }

    private void turno(Jugador jugadorDeTurno,Boolean yaMovio){
        opcionesDeJuego.getChildren().clear();
        Label opcionesDeTurno = new Label("Opciones de turno:");

        Button mover = new Button("OPCION Mover");
        mover.setPadding( new Insets(15,15,15,15));
        mover.setOnAction(e->moverUnidad(jugadorDeTurno));

        Button atacar = new Button("OPCION Atacar");
        atacar.setPadding( new Insets(15,15,15,15));
        atacar.setOnAction( e-> atacar(jugadorDeTurno));

        Button curar = new Button("OPCION Curar");
        curar.setPadding( new Insets(15,15,15,15));
        curar.setOnAction( e-> atacar(jugadorDeTurno));

        Button pasar = new Button("Pasar");
        pasar.setPadding( new Insets(15,15,15,15));
        pasar.setOnAction( e->{
            if(jugadorDeTurno.getNombre()==jugadorUno.getNombre()) {
                turno(jugadorDos,false);
            }else{
                turno(jugadorUno,false);
            }
        });

        opcionesDeJuego.getChildren().addAll(opcionesDeTurno,mover,atacar,curar,pasar);



    }
    private void moverUnidad(Jugador jugadorRecibido) {
        opcionesDeJuego.getChildren().clear();
        Button botonAnterior = botonClickeado;
        Posicion posicionAnterior = (Posicion) botonAnterior.getUserData();
        Posicion mismaPosicionAnterior = new Posicion(posicionAnterior);

        Label seleccionDeNuevaPosicion= new Label("seleccione la posicion a donde la desea mover");
        Button confirmarNuevaPosicion = new Button("MOVER");
        confirmarNuevaPosicion.setOnAction(e ->{
            Button botonNuevo = botonClickeado;
            Posicion nuevaPosicion = (Posicion) botonNuevo.getUserData();
            Posicion mismaPosicionNueva = new Posicion(nuevaPosicion);
            try{
                UnidadMovible unidad = (UnidadMovible) tablero.getUnidad(posicionAnterior);
                unidad.mover(nuevaPosicion,tablero);
                turno(jugadorRecibido,true);

                botonAnterior.setUserData(mismaPosicionAnterior);
                botonNuevo.setUserData(mismaPosicionNueva);
                informacionCasillero(botonAnterior);
                informacionCasillero(botonNuevo);
            } catch(ExcepcionCasilleroOcupado error){
                // Juan tenes que hacer la alerta
                infoCasilleroClickeado.setText("NOOOOOOOOOOO");
            } catch(ExcepcionCasilleroVacio error){
                infoCasilleroClickeado.setText(" Esa posicion esta VACIA");
            }
        });
        opcionesDeJuego.getChildren().addAll(seleccionDeNuevaPosicion,confirmarNuevaPosicion);


    }

    private void actualizarCasillero(Button boton){
        informacionCasillero(boton);
    }








    private void atacar(Jugador jugadorRecibido){

        Button continuar = new Button("Continuar");
        continuar.setPadding( new Insets(15,15,15,15));

        if( jugadorRecibido.getNombre() == this.jugadorUno.getNombre() ){
            continuar.setOnAction( e-> turno(jugadorDos,true));
        }
        else {
            continuar.setOnAction( e-> turno(jugadorUno,true));
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
        if(ejercito== this.jugadorUno.getNombre()){
            textoCasillero=textoCasillero+"1";
        }
        else{
            textoCasillero=textoCasillero+"2";
        }

        return textoCasillero;
    }

    private void setLayoutJuego(VBox layoutJuego) {
    }


}
