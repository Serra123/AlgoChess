package paquetePrincipal;

public class Soldado extends UnidadMovible{

    private int danioCuerpoACuerpo;

    public Soldado(int fila, int columna) {
        danioCuerpoACuerpo = 10;
        vida = 100;
        costo = 1;
        this.posicion = new Posicion(fila,columna);
    }

    public void atacar(Unidad unidadEnemiga){
        unidadEnemiga.recibirAtaque(danioCuerpoACuerpo);
    }
}
