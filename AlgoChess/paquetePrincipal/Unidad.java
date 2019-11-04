package paquetePrincipal;

public class Unidad {
    protected int vida;
    protected int costo;
    protected Posicion posicion;

    public int getVida() {
        return vida;
    }

    protected void recibirAtaque(int valorDanio)
    {
        vida -= valorDanio;
    }

    protected void recibirCuracion(int valorCuracion) {

        vida+=valorCuracion;
    }
}
