package paquetePrincipal;

public class Catapulta extends Unidad {

    private int danio;

    public void atacar(Soldado enemigo) {
        enemigo.recibirAtaque(this.danio);
    }

    Catapulta(){
        this.vida = 50;
        this.costo = 5;
        this.danio = 20;
    }
}
