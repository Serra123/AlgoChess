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

    private Stage stage;
    private Jugador jugadorUno;
    private Jugador jugadorDos;
    private Tablero tablero;

    public void iniciar(Stage stage,String jugadorUno,String jugadorDos) {

        this.stage = stage;
        this.jugadorUno = new Jugador(jugadorUno);
        this.jugadorDos = new Jugador(jugadorDos);
        this.tablero = new Tablero(20,20,jugadorUno,jugadorDos);


        VBox opcionesDeJuego = new VBox();
        Posicion posicionClickeada = new Posicion(0,0);

        Label espacioGenerado = new Label();
        espacioGenerado.setText("\n\n\n");
        Button agregarUnidadesJugadorUno = new Button("Agregar undades jugador uno");
        agregarUnidadesJugadorUno.setPadding(new Insets(20,20,20,20));
        Button agregarUnidadesJugadorDos = new Button("Agregar undades jugador dos");
        agregarUnidadesJugadorDos.setPadding(new Insets(20,20,20,20));

        VBox opcionesParaCrearUnidades = new VBox();

        agregarUnidadesJugadorUno.setOnAction(e->colocarUnidadesDe(this.jugadorUno,opcionesParaCrearUnidades,posicionClickeada));

        Label infoUsuarioClickeado = new Label();
        infoUsuarioClickeado.setText(" ");


        opcionesDeJuego.setSpacing(10);
        opcionesDeJuego.getChildren().addAll(espacioGenerado,agregarUnidadesJugadorUno,agregarUnidadesJugadorDos,opcionesParaCrearUnidades,infoUsuarioClickeado);


        Posicion posicion = new Posicion(2,2);
        Soldado soldado = new Soldado(posicion,jugadorUno);
        tablero.colocarUnidad(soldado);
        VBox vistaTablero = new VBox(0);
        Label sectorDeJugador1 = new Label();
        sectorDeJugador1.setText("Sector de jugador 1: "+ jugadorUno);
        vistaTablero.getChildren().add(sectorDeJugador1);

        inicializarTablero(vistaTablero,infoUsuarioClickeado,posicionClickeada);

        Label sectorDeJugador2 = new Label();
        sectorDeJugador2.setText("Sector de jugador 2: "+ jugadorDos);
        vistaTablero.getChildren().add(sectorDeJugador2);

        HBox pantalla = new HBox(0);

        pantalla.getChildren().addAll(vistaTablero,opcionesDeJuego);

        Scene tablero = new Scene(pantalla,1200,900);

        stage.setScene(tablero);
        stage.show();

    }

    private void colocarUnidadesDe(Jugador jugadorUno, VBox opcionesParaCrearUnidades,Posicion posicionClickeada) {

        Label inicioCreacionUnidades = new Label();
        inicioCreacionUnidades.setText("seleccione la unidad que quiera crear");
        opcionesParaCrearUnidades.getChildren().add(inicioCreacionUnidades);

        Button opcionSoldado = new Button("Soldado");
        CrearUnidadEventHandler elegirOpcionSoldado = new CrearUnidadEventHandler("Soldado",tablero,opcionesParaCrearUnidades,posicionClickeada);
        opcionSoldado.setOnAction(elegirOpcionSoldado);

        Button opcionCurandero = new Button("Curandero");
        CrearUnidadEventHandler elegirOpcionCurandero = new CrearUnidadEventHandler("Curandero",tablero,opcionesParaCrearUnidades,posicionClickeada);
        opcionCurandero.setOnAction(elegirOpcionCurandero);

        Button opcionJinete = new Button("Jinete");
        CrearUnidadEventHandler elegirOpcionJinete = new CrearUnidadEventHandler("Jinete",tablero,opcionesParaCrearUnidades,posicionClickeada);
        opcionJinete.setOnAction(elegirOpcionJinete);

        Button opcionCatapulta = new Button("Catapulta");
        CrearUnidadEventHandler elegirOpcionCatapulta = new CrearUnidadEventHandler("Catapulta",tablero,opcionesParaCrearUnidades,posicionClickeada);
        opcionSoldado.setOnAction(elegirOpcionCatapulta);

        HBox opcionesSoldadoOCurandero = new HBox();
        opcionesSoldadoOCurandero.getChildren().addAll(opcionSoldado,opcionCurandero);
        HBox opcionesJineteOCatapulta = new HBox();
        opcionesJineteOCatapulta.getChildren().addAll(opcionJinete,opcionCatapulta);

        opcionesParaCrearUnidades.getChildren().addAll(opcionesSoldadoOCurandero,opcionesJineteOCatapulta);

    }

    private void inicializarTablero(VBox vistaTablero,Label infoUsuarioClickeado,Posicion posicionClickeada) {

        vistaTablero.setPadding(new Insets(20,20,20,20));
        Button[][] casillero = new Button[20][20];
        ClickearCasilleroEventHandler[][] clickearCasilleroEventHandler = new ClickearCasilleroEventHandler[20][20];
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

                 //clickearCasilleroEventHandler[i][j] = new ClickearCasilleroEventHandler((Posicion) casillero[finalI][finalJ].getUserData(),infoUsuarioClickeado,posicionClickeada);

                 casillero[i][j].setOnAction(e->informacionCasillero(casillero[finalI][finalJ],(Posicion) casillero[finalI][finalJ].getUserData(),infoUsuarioClickeado,posicionClickeada));
                 fila[i].getChildren().add(casillero[i][j]);
             }
             vistaTablero.getChildren().addAll(fila[i]);
        }

    }
    private void informacionCasillero(Button boton,Posicion posicion,Label infousuarioClickeado,Posicion posicionClickeada) {
        Unidad unidad;
        posicionClickeada=posicion;
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
            infousuarioClickeado.setText("\n\n\nNo hay una unidad acá");
        }
    }

    private String setearTextoCasillero(String tipoUnidad, String ejercito) {
        String textoCasillero;
        switch (tipoUnidad){
            case "soldado": textoCasillero="s"+"1";
                break;
            case "curandero": textoCasillero="cu"+"1";
                break;
            case "catapulta": textoCasillero="ca"+"1";
                break;
            case "jinete": textoCasillero="j"+"1";
                break;
            default: textoCasillero="Nan"+"1";
        }
        return textoCasillero;
    }

    private void setLayoutJuego(VBox layoutJuego) {

        Label mensajeJuego = new Label();
        mensajeJuego.setText("mi primera cosa en el juego posta <3");
        layoutJuego.getChildren().addAll(mensajeJuego);

    }


}
