import java.util.Scanner;

public class q1259 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of elements
        int contPar = 0;      // count of even numbers

        int[] array = new int[n];

        // reading input
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }

        // first phase:
        // move even numbers to the front and sort them in ascending order
        for(int i = 0; i < n; i++){

            int menor = i;

            for(int j = i + 1; j < n; j++){

                // prioritize even numbers and sort evens ascending
                if(array[menor] % 2 == 1 && array[j] % 2 == 0 ||
                   array[menor] % 2 == 0 && array[j] % 2 == 0 && array[menor] > array[j]){
                    menor = j;
                }
            }

            // swap if needed
            if(array[i] % 2 == 1 && array[menor] % 2 == 0 ||
               array[i] % 2 == 0 && array[menor] % 2 == 0 && array[i] > array[menor]){
                int temp = array[i];
                array[i] = array[menor];
                array[menor] = temp;
            }

            // count evens
            if(array[i] % 2 == 0){
                contPar++;
            }
        }

        // second phase:
        // sort odd numbers (remaining part) in descending order
        for(int i = contPar; i < n; i++){

            int maior = i;

            for(int j = i + 1; j < n; j++){
                if(array[maior] < array[j]){
                    maior = j;
                }
            }

            int temp = array[i];
            array[i] = array[maior];
            array[maior] = temp;
        }

        // output result
        for(int i = 0; i < n; i++){
            System.out.println(array[i]);
        }
    }
}
