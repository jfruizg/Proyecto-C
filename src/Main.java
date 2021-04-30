import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int casos = in.nextInt();
        int cont = 0;


        while (cont < casos) {
            int cantidadMatriz = in.nextInt();
            String matriz[][] = new String[cantidadMatriz][cantidadMatriz];
            boolean visita[][] = new boolean[cantidadMatriz][cantidadMatriz];
            String ma = "";
            int cont2 = 0;

            in.nextLine();
            for (int x = 0; x < cantidadMatriz; x++) {
                String a = in.nextLine();
                String[] spli = a.split(" ");

                for (int z = 0; z < spli.length; z++) {
                    matriz[x][z] = spli[z];
                }
            }

            for (int i = 0; i < matriz.length; i++){
                for(int j =0 ; j< matriz.length; j++){
                    System.out.println(matriz[i][j]);
                }
            }


            for (int a = 1; a <= matriz.length; a++) {
                for (int j = 0; j < visita.length; j++) {
                    for (int j2 = 0; j2 < visita.length-1; j2++) {
                        Floodfill(j,j2,a, visita, matriz);
                    }
                }
            }
            boolean aux = false;
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    if (matriz[i][j] != "t") {
                        aux = false;
                    } else {
                        aux = true;
                    }
                }
            }
            if (aux == false) {
                System.out.print("Caso#" + (cont + 1) + "\n");
                System.out.print("No");
            } else {
                System.out.print("Caso#" + (cont + 1) + "\n");
                System.out.print("Si");
            }
            cont++;
        }
    }

    static void Floodfill(int fila, int columna, int siguiente, boolean marked[][], String[][] array) {
        if (array[fila][columna].equals(siguiente + "")) {
            array[fila][columna] = "t";
            if (columna < array.length - 1) {
                Floodfill(fila, columna + 1, siguiente, marked, array);
            }
            if (fila < array.length - 1) {
                Floodfill(fila + 1, columna, siguiente, marked, array);
            }
            if (columna != 0) {
                Floodfill(fila, columna - 1, siguiente, marked, array);
            }
            if (fila != 0) {
                Floodfill(fila - 1, columna, siguiente, marked, array);
            }
        }
    }
}
