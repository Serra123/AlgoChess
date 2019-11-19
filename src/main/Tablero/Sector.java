package Tablero;

public class Sector {

    private int limiteInferior;
    private int limiteSuperior;

    Sector(int limiteInferior,int limiteSuperior){
        this.limiteInferior=limiteInferior;
        this.limiteSuperior=limiteSuperior;
    }

    public boolean estaEnSector(int posicionFila){
        return (posicionFila>=limiteInferior & posicionFila<=limiteSuperior);
    }
}
