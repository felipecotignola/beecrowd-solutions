import java.util.Scanner;
class Queue{
    int[] queue;
    int inicio,fim,tamanho,capacidade;
    public Queue(int capacidade){
        this.capacidade=capacidade;
        queue=new int[capacidade];
        inicio=fim=tamanho=0;
    }
    public void enqueue(int x){
        if(tamanho<capacidade){
            queue[fim]=x;
            tamanho++;
            fim=(fim+1)%capacidade;
        }
    }
    public int dequeue(){
        if(tamanho>0){
            int descartado=queue[inicio];
            inicio=(inicio+1)%capacidade;
            tamanho--;
            return descartado;
        }
        return -1 ;
    }
    public int check(){
        return tamanho;
    }
    public void printRemaining(){
        System.out.print(queue[inicio]);
    }
   
}
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
            while(n>0){
                int[] descartados=new int[n-1];
                int tam=0;
                Queue fila= new Queue(n);
            for(int i=1;i<=n;i++){
                fila.enqueue(i);
            }
            while(fila.check()>=2){
                descartados[tam]=fila.dequeue();
                fila.enqueue(fila.dequeue());
                tam++;
            }
            System.out.print("Discarded cards: ");
            for(int i=0;i<tam;i++){
                System.out.print(descartados[i]);
                if(i<tam-1){
                    System.out.print(", ");
                }
            }
            System.out.println();
            System.out.print("Remaining card: ");
            fila.printRemaining();
            System.out.println();
            n=sc.nextInt();
        }
        

    }

}
