import java.util.Scanner;

public class q1259 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] pares = new int[n],impares = new int[n];
        int contPar = 0,contImpar = 0;

        // Separate input into even and odd arrays
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();

            if(x % 2 == 0){
                pares[contPar++] = x;
            } else {
                impares[contImpar++] = x;
            }
        }

        // Insertion sort for even numbers (ascending)
        for(int i = 1; i < contPar; i++){
            int chave = pares[i];
            int j = i - 1;

            while(j >= 0 && pares[j] > chave){
                pares[j + 1] = pares[j];
                j--;
            }

            pares[j + 1] = chave;
        }

        // Insertion sort for odd numbers (descending)
        for(int i = 1; i < contImpar; i++){
            int chave = impares[i];
            int j = i - 1;

            while(j >= 0 && impares[j] < chave){
                impares[j + 1] = impares[j];
                j--;
            }

            impares[j + 1] = chave;
        }

        // Output even numbers first, then odd numbers
        for(int i = 0; i < contPar; i++){
            System.out.println(pares[i]);
        }

        for(int i = 0; i < contImpar; i++){
            System.out.println(impares[i]);
        }

    }
}
