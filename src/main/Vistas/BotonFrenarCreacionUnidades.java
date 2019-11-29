package Vistas;

import Jugador.Jugador;
import javafx.scene.control.Button;

public class BotonFrenarCreacionUnidades extends Button {


    public BotonFrenarCreacionUnidades(String listo, Jugador jugadorUno,Jugador jugadorActual , AgregarUnidades agregarUnidades,OpcionesView opcionesView) {
        this.setText(listo);
        if(jugadorActual.getNombre() == jugadorUno.getNombre()){
            this.setOnAction(e->agregarUnidades.cambiarJugador());
        }else{
            this.setOnAction(e->opcionesView.iniciarTurno());
            //en este caso tengo que llamar al opciones view y que deje de mostrar las opciones de creacion
            //y empiece con los turnos posta
        }
    }
}
