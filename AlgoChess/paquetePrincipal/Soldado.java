package paquetePrincipal;

public class Soldado extends UnidadMovible{

    private int danioCuerpoACuerpo;

    public Soldado() {
        danioCuerpoACuerpo = 10;
        vida = 100;
        costo = 1;
    }

    public void atacar(Unidad unidadEnemiga){
        unidadEnemiga.recibirAtaque(danioCuerpoACuerpo);
    }
}
