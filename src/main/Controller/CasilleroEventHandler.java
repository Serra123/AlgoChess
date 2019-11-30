package Controller;

import Excepciones.ExcepcionCasilleroVacio;
import Jugador.Jugador;
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
    protected Jugador jugadorUno;
    protected Jugador jugadorDos;


    public CasilleroEventHandler(JuegoPrincipal faseDeJuego, Posicion unaPosicion, BotonCasillero unBoton) {

        this.posicion = unaPosicion;
        this.infoCasilleroBox = faseDeJuego.getInfoCasilleroBox() ;
        this.tablero = faseDeJuego.getTableroDeJuego();
        this.botonCasillero = unBoton;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String estadisticasCasillero;
        try {
            Unidad unidad = tablero.getUnidad(posicion);
            String tipoUnidad = unidad.getTipoUnidad();
            setearTextoCasillero(tipoUnidad,unidad.getEjercito(),botonCasillero);
        } catch (ExcepcionCasilleroVacio e) {
            botonCasillero.setText("");
        }
        botonCasillero.setStyle("-fx-background-image: url('fondoCasillero.jpg')");
        this.infoCasilleroBox.actualizarPosicionClickeada(posicion);
    }

    private void setearTextoCasillero(String tipoUnidad, String ejercito, BotonCasillero botonCasillero) {
        String textoCasillero;
        switch (tipoUnidad) {
            case "soldado":
                textoCasillero = "S";
                break;
            case "curandero":
                textoCasillero = "Cu";
                break;
            case "catapulta":
                textoCasillero = "Ca";
                break;
            case "jinete":
                textoCasillero = "J";
                break;
            default:
                textoCasillero = "Nan";
        }
        textoCasillero = textoCasillero + ejercito;

        botonCasillero.setText(textoCasillero);
    }

}
