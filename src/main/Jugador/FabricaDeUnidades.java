package Jugador;

import Excepciones.ExcepcionTipoUnidadInvalida;
import Unidades.*;
import Unidades.Posicion.Posicion;

public class FabricaDeUnidades {

    private String nombreEjercito;

    FabricaDeUnidades(String nombreEjercito){
        this.nombreEjercito = nombreEjercito;
    }

    public Unidad crearUnidad(Posicion unaPosicion, String tipoUnidad){
        Unidad unaUnidad;
        switch (tipoUnidad){

            case "Soldado": unaUnidad = new Soldado(unaPosicion,this.nombreEjercito); break;

            case "Catapulta": unaUnidad = new Catapulta(unaPosicion,this.nombreEjercito); break;

            case "Jinete": unaUnidad = new Jinete(unaPosicion,this.nombreEjercito); break;

            case "Curandero": unaUnidad = new Curandero(unaPosicion,this.nombreEjercito); break;

            default: throw new ExcepcionTipoUnidadInvalida();

        }

        return unaUnidad;
    }
}
