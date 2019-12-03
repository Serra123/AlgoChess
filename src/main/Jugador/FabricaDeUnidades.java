package Jugador;

import Excepciones.ExcepcionTipoUnidadInvalida;
import Tablero.Tablero;
import Unidades.*;
import Unidades.Posicion.Posicion;

class FabricaDeUnidades {

    private Ejercito ejercito;

    FabricaDeUnidades(Ejercito unEjercito){
        ejercito = unEjercito;
    }

    Unidad crearUnidad(Posicion unaPosicion, String tipoUnidad, Tablero unTablero){
        Unidad unaUnidad;
        switch (tipoUnidad){

            case "Soldado": unaUnidad = new Soldado(unaPosicion,this.ejercito); break;

            case "Catapulta": unaUnidad = new Catapulta(unaPosicion,this.ejercito); break;

            case "Jinete": unaUnidad = new Jinete(unaPosicion,this.ejercito); break;

            case "Curandero": unaUnidad = new Curandero(unaPosicion,this.ejercito); break;

            default: throw new ExcepcionTipoUnidadInvalida();

        }

        unTablero.colocarUnidad(unaUnidad);

        return unaUnidad;
    }

}
