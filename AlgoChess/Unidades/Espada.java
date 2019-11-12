package Unidades;

public class Espada extends Arma {

    private static int DANIO = 5;

    @Override
    public void atacar(Unidad enemigo) {
        enemigo.recibirAtaque(DANIO);
    }
}
