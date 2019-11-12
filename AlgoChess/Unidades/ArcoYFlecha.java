package Unidades;

public class ArcoYFlecha extends Arma {

    private static int DANIO = 15;

    @Override
    public void atacar(Unidad enemigo) {
        enemigo.recibirAtaque(DANIO);
    }
}
