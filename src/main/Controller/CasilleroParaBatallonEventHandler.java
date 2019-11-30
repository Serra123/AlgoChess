package Controller;


import Unidades.Posicion.Posicion;
import Vistas.FaseJuego.BotonCasillero;
import Vistas.FaseJuego.JuegoPrincipal;
import javafx.event.ActionEvent;

import java.util.ArrayList;

public class CasilleroParaBatallonEventHandler extends CasilleroEventHandler {

    private ArrayList<Posicion> posiciones;

    public CasilleroParaBatallonEventHandler(JuegoPrincipal faseDeJuego, Posicion posicion, BotonCasillero boton, ArrayList<Posicion> posiciones) {
        super(faseDeJuego,posicion,boton);
        this.posiciones = posiciones;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        posiciones.add(posicion);
        }
}