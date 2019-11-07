package Unidades;

public class ArcoYFlecha extends Arma {

    private int danio;

    public ArcoYFlecha() {
        danio = 15;
    }

    @Override
    public void atacar(Unidad enemigo) {
        enemigo.recibirAtaque(danio);
    }
}
