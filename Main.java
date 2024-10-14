import java.util.Scanner;

public class Main {
    private static VentanaGrafica ventanaActual = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Generar Grafo Aleatorio");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    if (ventanaActual != null) {
                        ventanaActual.dispose();  // cerrar ventana anterior
                    }
                    Grafo grafo = Grafo.generarGrafoAleatorio();
                    ventanaActual = new VentanaGrafica(grafo);  // abrir nueva
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
