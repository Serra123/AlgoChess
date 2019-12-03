package Controller;

import Excepciones.ExcepcionCasilleroVacio;
import Tablero.Tablero;
import Unidades.Posicion.Posicion;
import Unidades.Unidad;
import Vistas.FaseJuego.BotonCasillero;
import Vistas.FaseJuego.JuegoPrincipal;
import Vistas.FaseJuego.InfoCasilleroBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class CasilleroEventHandler implements EventHandler<ActionEvent> {


    protected Posicion posicion;
    protected JuegoPrincipal juegoPrincipal;
    protected InfoCasilleroBox infoCasilleroBox;
    protected Tablero tablero;
    protected BotonCasillero botonCasillero;

    public CasilleroEventHandler(JuegoPrincipal faseDeJuego, Posicion unaPosicion, BotonCasillero unBoton) {

        this.posicion = unaPosicion;
        this.infoCasilleroBox = faseDeJuego.getInfoCasilleroBox() ;
        this.tablero = faseDeJuego.getTableroDeJuego();
        this.juegoPrincipal = faseDeJuego;
        this.botonCasillero = unBoton;

    }

    @Override
    public void handle(ActionEvent actionEvent) {

        try {
            Unidad unidad = tablero.getUnidad(posicion);
            setearImagenCasillero(unidad,botonCasillero);
        } catch (ExcepcionCasilleroVacio e) {
            botonCasillero.getStyleClass().removeAll("botonConSoldado1","botonConJinete1","botonConCurandero1","botonConCatapulta1");
            botonCasillero.getStyleClass().removeAll("botonConSoldado2","botonConJinete2","botonConCurandero2","botonConCatapulta2");
        }
        this.infoCasilleroBox.actualizarPosicionClickeada(posicion);
    }

    private void setearImagenCasillero(Unidad unaUnidad, BotonCasillero botonCasillero) {
        String nombreEjercito;
        if(unaUnidad.getNombreJugador() == juegoPrincipal.getJugadorUno().getNombre()){
            nombreEjercito = "1";
        }else nombreEjercito = "2";

        switch (unaUnidad.getTipoUnidad()) {
            case "soldado":
                botonCasillero.getStyleClass().add("botonConSoldado"+ nombreEjercito);
                break;
            case "curandero":
                botonCasillero.getStyleClass().add("botonConCurandero"+ nombreEjercito);
                break;
            case "catapulta":
                botonCasillero.getStyleClass().add("botonConCatapulta"+ nombreEjercito);
                break;
            case "jinete":
                botonCasillero.getStyleClass().add("botonConJinete" + nombreEjercito);
                break;
            default:
                break;
        }
    }

}
