package paquetePrincipal;

public class Jinete extends UnidadMovible{

    private Arma armaDeAtaque;


    public Jinete() {

        armaDeAtaque = new Espada();
    }

    public void atacar(Unidad enemigo){

        armaDeAtaque.atacar(enemigo);
    }

    public void cambiarArmaAEspada(){
        armaDeAtaque = new Espada();
    }

    public void cambiarArmaAArcoYFlecha(){
        armaDeAtaque = new ArcoYFlecha();
    }
}
