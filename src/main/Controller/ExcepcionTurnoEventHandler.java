package Controller;

import Vistas.FaseJuego.FaseTurnos.FaseTurnos;
import Vistas.FaseJuego.TableroView;
import javafx.scene.control.Alert;

public class ExcepcionTurnoEventHandler extends Alert {
    public ExcepcionTurnoEventHandler(String cabecera, String contenido, TableroView tableroView, FaseTurnos faseTurnos, boolean yaMovio) {
        super(Alert.AlertType.INFORMATION);
        this.setTitle("ERROR");
        this.setHeaderText(cabecera);
        this.setContentText(contenido);
        this.showAndWait();

        tableroView.actualizar();
        faseTurnos.crearLayoutFaseParaJugadorActual(yaMovio);
    }
}
