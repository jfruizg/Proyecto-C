import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int casos = in.nextInt();
        int cont = 0;


        while (cont < casos) {
            int cantidadMatriz = in.nextInt();
            int matriz[][] = new int[cantidadMatriz][cantidadMatriz];
            String ma = "";
            int cont2 = 0;

           in.nextLine();
           for(int x = 0; x< cantidadMatriz; x++){
               String a = in.nextLine();
               String [] spli = a.split(" ");

             for(int z = 0; z < spli.length;z++) {
                 matriz[x][z] = Integer.parseInt(spli[z]);
             }
           }
           int num = 0;
           for (int i = 0; i< matriz.length; i++){
               for(int j = 0; j< matriz.length; j++){
                   if((j+1) == matriz.length || (i+1) == matriz.length){
                   }else {
                       for(int z = 0; z< matriz.length; z++) {
                           if (matriz[i][j] == matriz[i][j + 1] || matriz[i][j] ==matriz[i + 1][j]){
                               System.out.println("Caso" + cont + matriz.length);
                               System.out.println("Si");
                           } else {
                               System.out.println("Caso" + cont + "" + matriz.length);
                               System.out.println("No");
                           }
                       }
                   }
               }
           }

            cont++;
        }


    }
}
