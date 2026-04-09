import java.util.Scanner;

// Simple stack using only a counter (no need to store elements)
class Stack {
    int topo;

    public Stack() {
        topo = 0;
    }

    // Simulates push
    public void push() {
        topo++;
    }

    // Simulates pop, returns true if successful
    public boolean pop() {
        if (topo > 0) {
            topo--;
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of test cases

        for (int i = 0; i < n; i++) {
            String string = sc.next(); // input string
            Stack stack = new Stack();
            int diamantes = 0;

            // iterate through the string
            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(j) == '<') {
                    stack.push(); // store opening
                } else if (string.charAt(j) == '>') {
                    // form a diamond if possible
                    if (stack.pop()) {
                        diamantes++;
                    }
                }
            }

            System.out.println(diamantes);
        }

        sc.close();
    }
}
