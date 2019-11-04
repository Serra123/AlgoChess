package paquetePrincipal;

public class Catapulta extends Unidad {

    private int danio;

    public void atacar(Soldado enemigo) {
        enemigo.recibirAtaque(this.danio);
    }

    Catapulta(int fila, int columna){
        this.vida = 50;
        this.costo = 5;
        this.danio = 20;
        this.posicion = new Posicion(fila,columna);
    }
    @Override
    public void recibirCuracion(int valorCuracion){
        throw new RuntimeException("No se puede curar una catapulta");
    }
}
