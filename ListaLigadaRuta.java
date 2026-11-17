public class ListaLigadaRuta {
    private Nodo cabeza;
    private int tamano;

    public ListaLigadaRuta() {
        this.cabeza = null;
        this.tamano = 0;
    }

    public void agregarParada(Parada parada) {
        Nodo nuevoNodo = new Nodo(parada);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        tamano++;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getTamano() {
        return tamano;
    }

    public String obtenerRutaTexto() {
        StringBuilder sb = new StringBuilder();
        Nodo actual = cabeza;
        int i = 1;
        while (actual != null) {
            sb.append(i).append(". ").append(actual.getParada().toString()).append("\n");
            actual = actual.getSiguiente();
            i++;
        }
        return sb.toString();
    }
}