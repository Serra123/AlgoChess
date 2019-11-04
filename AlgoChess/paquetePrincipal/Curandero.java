package paquetePrincipal;

public class Curandero extends Unidad{

    private int valorCuracion;

    Curandero(){
        vida = 75;
        valorCuracion= 15;
    }

    public void curar(Unidad unidadAliada) {
        unidadAliada.recibirCuracion(valorCuracion);
    }
}
