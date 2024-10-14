import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DibujoGrafo extends JPanel {
    private Grafo grafo;

    public DibujoGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random rand = new Random();
        int V = grafo.getNumNodos();
        int[][] posiciones = new int[V][2];

        // lugares aleatorios para los nodos
        for (int i = 0; i < V; i++) {
            posiciones[i][0] = rand.nextInt(getWidth() - 50) + 25;
            posiciones[i][1] = rand.nextInt(getHeight() - 50) + 25;
            g.fillOval(posiciones[i][0], posiciones[i][1], 20, 20);
            g.drawString("Nodo " + i, posiciones[i][0] - 10, posiciones[i][1] - 10);
        }

        // hacer las aristas y los pesos
        for (Arista arista : grafo.getAristas()) {
            int x1 = posiciones[arista.origen][0];
            int y1 = posiciones[arista.origen][1];
            int x2 = posiciones[arista.destino][0];
            int y2 = posiciones[arista.destino][1];
            g.drawLine(x1, y1, x2, y2);

            // dibujar peso en el punto medio de la arista
            int pesoX = (x1 + x2) / 2;
            int pesoY = (y1 + y2) / 2;
            g.setColor(Color.RED);
            g.drawString(String.valueOf(arista.peso), pesoX, pesoY);
            g.setColor(Color.BLACK);
        }
    }
}