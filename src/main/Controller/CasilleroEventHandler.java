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
    protected InfoCasilleroBox infoCasilleroBox;
    protected Tablero tablero;
    protected BotonCasillero botonCasillero;

    public CasilleroEventHandler(JuegoPrincipal faseDeJuego, Posicion unaPosicion, BotonCasillero unBoton) {

        this.posicion = unaPosicion;
        this.infoCasilleroBox = faseDeJuego.getInfoCasilleroBox() ;
        this.tablero = faseDeJuego.getTableroDeJuego();
        this.botonCasillero = unBoton;

    }

    @Override
    public void handle(ActionEvent actionEvent) {

        try {
            Unidad unidad = tablero.getUnidad(posicion);
            setearImagenCasillero(unidad,botonCasillero);
        } catch (ExcepcionCasilleroVacio e) {
            botonCasillero.getStyleClass().removeAll("botonConSoldado");
        }
        this.infoCasilleroBox.actualizarPosicionClickeada(posicion);
    }

    private void setearImagenCasillero(Unidad unaUnidad, BotonCasillero botonCasillero) {

        switch (unaUnidad.getTipoUnidad()) {
            case "soldado":
                botonCasillero.getStyleClass().add("botonConSoldado");
                break;
            case "curandero":
                botonCasillero.getStyleClass().add("botonConCurandero");
                break;
            case "catapulta":
                break;
            case "jinete":
                botonCasillero.getStyleClass().add("botonConJinete");
                break;
            default:
                break;
        }
    }

}
