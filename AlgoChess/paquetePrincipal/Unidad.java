package paquetePrincipal;

public class Unidad {
    protected int vida;
    protected int costo;

    public int getVida() {
        return vida;
    }

    protected void recibirAtaque(int valorDanio){
        vida -= valorDanio;
    }
}
