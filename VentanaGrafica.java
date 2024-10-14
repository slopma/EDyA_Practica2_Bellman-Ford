import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGrafica extends JFrame {
    private Grafo grafo;

    public VentanaGrafica(Grafo grafo) {
        this.grafo = grafo;

        setTitle("Visualización del Grafo");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(new DibujoGrafo(grafo), BorderLayout.CENTER);

        JPanel panelOpciones = new JPanel();
        JLabel labelOrigen = new JLabel("Nodo Origen:");
        JTextField inputOrigen = new JTextField(5);
        JButton botonCalcular = new JButton("Calcular Bellman-Ford");

        panelOpciones.add(labelOrigen);
        panelOpciones.add(inputOrigen);
        panelOpciones.add(botonCalcular);

        panelPrincipal.add(panelOpciones, BorderLayout.SOUTH);

        botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int origen = Integer.parseInt(inputOrigen.getText());
                    mostrarResultados(origen);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un nodo válido.");
                }
            }
        });

        add(panelPrincipal);
        setVisible(true);
    }

    private void mostrarResultados(int origen) {
        int[] distancias = BellmanFord.ejecutar(grafo, origen);
        StringBuilder resultado = new StringBuilder("Distancias desde el nodo " + origen + ":\n");
        for (int i = 0; i < distancias.length; i++) {
            resultado.append("Nodo ").append(i).append(": ").append(distancias[i]).append("\n");
        }
        JOptionPane.showMessageDialog(this, resultado.toString());
    }
}
