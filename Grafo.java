import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grafo {
    private int numNodos;
    private List<Arista> aristas;

    public Grafo(int numNodos) {
        this.numNodos = numNodos;
        this.aristas = new ArrayList<>();
    }

    public void agregarArista(int origen, int destino, int peso) {
        aristas.add(new Arista(origen, destino, peso));
    }

    public List<Arista> getAristas() {
        return aristas;
    }

    public int getNumNodos() {
        return numNodos;
    }

    public static Grafo generarGrafoAleatorio() {
        Random rand = new Random();
        int numNodos = rand.nextInt(3) + 2;  // nodos
        Grafo grafo = new Grafo(numNodos);

        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                if (i != j && rand.nextBoolean()) {
                    int peso = rand.nextInt(11) - 5;  // pesos aceptando negativos
                    grafo.agregarArista(i, j, peso);
                }
            }
        }
        return grafo;
    }
}
