import java.util.Scanner;

// Circular queue implementation
class Queue {
    int[] queue;
    int inicio, fim, tamanho, capacidade;

    public Queue(int capacidade) {
        this.capacidade = capacidade;
        queue = new int[capacidade];
        inicio = fim = tamanho = 0;
    }

    // Add element to the queue
    public void enqueue(int x) {
        if (tamanho < capacidade) {
            queue[fim] = x;
            fim = (fim + 1) % capacidade;
            tamanho++;
        }
    }

    // Remove and return front element
    public int dequeue() {
        if (tamanho > 0) {
            int descartado = queue[inicio];
            inicio = (inicio + 1) % capacidade;
            tamanho--;
            return descartado;
        }
        return -1;
    }

    // Current size of the queue
    public int check() {
        return tamanho;
    }

    // Print remaining element
    public void printRemaining() {
        System.out.print(queue[inicio]);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n > 0) {
            int[] descartados = new int[n - 1];
            int tam = 0;

            Queue fila = new Queue(n);

            // Fill queue from 1 to n
            for (int i = 1; i <= n; i++) {
                fila.enqueue(i);
            }

            // Simulate process
            while (fila.check() >= 2) {
                descartados[tam] = fila.dequeue(); // discard top
                fila.enqueue(fila.dequeue());      // move next to bottom
                tam++;
            }

            // Output discarded cards
            System.out.print("Discarded cards: ");
            for (int i = 0; i < tam; i++) {
                System.out.print(descartados[i]);
                if (i < tam - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();

            // Output remaining card
            System.out.print("Remaining card: ");
            fila.printRemaining();
            System.out.println();

            n = sc.nextInt();
        }

        sc.close();
    }
}
