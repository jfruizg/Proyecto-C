import java.util.Scanner;
// Jun Felipe Ruiz - Juan Daniel Niño
public class computadores {

    public int V;

    int minDistance(int dist[], Boolean sptSet[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }

    // A utility function to print the constructed distance array
    String printSolution(int dist[], int n, int nodoFinal) {
        String result = "";
        for (int i = 0; i < V; i++)
            if (i == nodoFinal) {
                return (dist[i]) + "";
            } else {
            }
        return result;
    }


    String operacionDijstrack(int graph[][], int src, int nodoFinal) {
        int dist[] = new int[V]; // The output array. dist[i] will hold

        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] = 0;


        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < V; v++)

                if (!sptSet[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
        return printSolution(dist, V, nodoFinal);
    }

    public static void main(String[] args) {
        int nodos, aux = 0, cantidadConexione = 0;
        int matriz[][];
        Scanner sr = new Scanner(System.in);
        int cont = sr.nextInt();

        sr.nextLine();
        while (aux < cont) {
            String cantidad = sr.nextLine();
            String splitOpcion1[] = cantidad.split(" ");
            nodos = Integer.parseInt(splitOpcion1[0]); // cantidad de computadores
            cantidadConexione = Integer.parseInt(splitOpcion1[1]);
            matriz = new int[nodos][nodos];
            computadores t = new computadores();

            for (int x = 0; x < cantidadConexione; x++) {
                String a = sr.nextLine();
                String[] spli = a.split(" ");
                matriz[Integer.parseInt(spli[0])][Integer.parseInt(spli[1])] = Integer.parseInt(spli[2]);
                matriz[Integer.parseInt(spli[1])][Integer.parseInt(spli[0])] = Integer.parseInt(spli[2]);
            }
            t.V = nodos;

            if (t.operacionDijstrack(matriz, Integer.parseInt(splitOpcion1[2]), Integer.parseInt(splitOpcion1[3])).equals("2147483647")) {
                System.out.println("Caso#" + (aux + 1) + "\n" + "Inalcanzable");
                aux++;
            } else {
                System.out.println("Caso#" + (aux + 1) + "\n" + t.operacionDijstrack(matriz, Integer.parseInt(splitOpcion1[2]), Integer.parseInt(splitOpcion1[3])));
                aux++;
            }
        }
    }
}

