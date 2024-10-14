import java.util.Arrays;
import javax.swing.JOptionPane;

public class BellmanFord {

    public static int[] ejecutar(Grafo grafo, int origen) {
        int V = grafo.getNumNodos();
        int[] dist = new int[V];

        // distancias a infinito excepto el origen
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[origen] = 0;

        // relajar aristas V-1 veces
        for (int i = 0; i < V - 1; i++) {
            boolean cambios = false;

            for (Arista arista : grafo.getAristas()) {
                if (dist[arista.origen] != Integer.MAX_VALUE &&
                        dist[arista.origen] + arista.peso < dist[arista.destino]) {

                    dist[arista.destino] = dist[arista.origen] + arista.peso;
                    cambios = true;
                }
            }

            // terminar temprano
            if (!cambios) {
                break;
            }
        }

        // comprobación ciclos negativos
        for (Arista arista : grafo.getAristas()) {
            if (dist[arista.origen] != Integer.MAX_VALUE &&
                    dist[arista.origen] + arista.peso < dist[arista.destino]) {
                JOptionPane.showMessageDialog(null, "El grafo contiene un ciclo negativo.");
                return dist;
            }
        }

        return dist;
    }
}
