package paquetePrincipal;

public class Curandero extends UnidadMovible{

    private int valorCuracion;

    Curandero(int fila, int columna){
        vida = 75;
        valorCuracion= 15;
        this.posicion = new Posicion(fila,columna);
    }

    public void curar(Unidad unidadAliada) {

        unidadAliada.recibirCuracion(valorCuracion);
    }
}
