package paquetePrincipal;

public class Jinete extends UnidadMovible{

    private int danioCuerpoACuerpo;
    private int danioADistancia;


    public Jinete() {
        danioADistancia = 15;
        danioCuerpoACuerpo = 5;
    }

    public void atacar(Unidad enemigo){
        enemigo.recibirAtaque(danioCuerpoACuerpo);
    }
}
