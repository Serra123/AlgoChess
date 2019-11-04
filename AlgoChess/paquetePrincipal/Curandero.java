package paquetePrincipal;

public class Curandero extends UnidadMovible{

    private int valorCuracion;

    Curandero(){
        vida = 75;
        valorCuracion= 15;
    }

    public void curar(Unidad unidadAliada) {

        unidadAliada.recibirCuracion(valorCuracion);
    }
}
