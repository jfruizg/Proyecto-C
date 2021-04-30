import java.util.Scanner;

public class Dijkstra {

    public int[] distancia = new int[10];
    public int[][] costo = new int[10][10];

    public void calc(int n, int s) {

        int[] bandera = new int[n + 1];
        int i, minpos = 1, k, c, minima;

        for (i = 1; i <= n; i++) {
            bandera[i] = 0;
            this.distancia[i] = this.costo[s][i];
        }
        c = 2;
        while (c <= n) {
            minima = Integer.MAX_VALUE;
            for (k = 1; k <= n; k++) {
                if (this.distancia[k] < minima && bandera[k] != 1) {
                    minima = this.distancia[i];
                    minpos = k;
                }
            }
            bandera[minpos] = 1;
            c++;

            for (k = 1; k <= n; k++) {
                if (this.distancia[minpos] + this.costo[minpos][k] < this.distancia[k] && bandera[k] != 1) {
                    this.distancia[k] = this.distancia[minpos] + this.costo[minpos][k];
                }

            }
        }


    }

    public static void main(String[] args) {
        int nodos, posicion, i, j, destino, vminimno, aux = 0, cantidadConexione = 0;
        String matriz[][];
        Scanner sr = new Scanner(System.in);
        int cont = sr.nextInt();

        sr.nextLine();
        while (aux < cont) {
            String cantidad = sr.nextLine();

            String splitOpcion1[] = cantidad.split(" ");
            nodos = Integer.parseInt(splitOpcion1[0]); // cantidad de computadores
            cantidadConexione = Integer.parseInt(splitOpcion1[1]);
            matriz = new String[nodos][nodos];


            Dijkstra d= new Dijkstra();

            for (int x = 0; x < cantidadConexione; x++) {
                String a = sr.nextLine();
                String[] spli = a.split(" ");
                d.costo[Integer.parseInt(spli[0])][Integer.parseInt(spli[1])] = Integer.parseInt(spli[2]);
                d.costo[Integer.parseInt(spli[1])][Integer.parseInt(spli[0])] = Integer.parseInt(spli[2]);
            }


            d.calc(nodos - 1, Integer.parseInt(splitOpcion1[2]));
            vminimno = d.distancia[Integer.parseInt(splitOpcion1[3])];
            System.out.println("Caso#"+cont+"\n"+ vminimno);

        }
        cont++;
    }

}

