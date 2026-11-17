public class Nodo {
    private Parada parada;
    private Nodo siguiente;

    public Nodo(Parada parada) {
        this.parada = parada;
        this.siguiente = null;
    }

    public Parada getParada() {
        return parada;
    }

    public void setParada(Parada parada) {
        this.parada = parada;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}