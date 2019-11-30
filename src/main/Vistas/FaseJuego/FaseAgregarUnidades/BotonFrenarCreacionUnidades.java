package Vistas.FaseJuego.FaseAgregarUnidades;

import Jugador.Jugador;
import Vistas.FaseJuego.FaseTurnos.FaseTurnos;
import Vistas.FaseJuego.JuegoPrincipal;
import javafx.scene.control.Button;

public class BotonFrenarCreacionUnidades extends Button {


    public BotonFrenarCreacionUnidades(String listo,JuegoPrincipal juegoPrincipal, FaseAgregarUnidades faseAgregarUnidades) {
        this.setText(listo);
        if(faseAgregarUnidades.getJugadorActual().getNombre() == juegoPrincipal.getJugadorUno().getNombre()){
            this.setOnAction(e-> faseAgregarUnidades.cambiarJugador());
        }else{
            this.setOnAction(e -> {
                FaseTurnos faseTurnos = new FaseTurnos(juegoPrincipal);
            });

        }
    }
}
