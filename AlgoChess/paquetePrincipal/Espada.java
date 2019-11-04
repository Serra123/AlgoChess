package paquetePrincipal;

public class Espada extends Arma {

    private int danio;

    public Espada() {
        danio = 5;
    }

    @Override
    public void atacar(Unidad enemigo) {
        enemigo.recibirAtaque(danio);
    }
}
