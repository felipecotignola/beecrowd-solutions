import java.util.Scanner;

public class q1068 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Read input until EOF
        while(sc.hasNextLine()){
            String string = sc.nextLine();

            int cont = 0;   // counts open parentheses
            int erro = 0;   // flag for invalid cases

            // Iterate through each character
            for(int i = 0; i < string.length(); i++){

                // Closing parenthesis without a matching opening
                if(string.charAt(i) == ')' && cont == 0){
                    erro++;
                    i = string.length(); // force loop termination
                }
                // Opening parenthesis
                else if(string.charAt(i) == '('){
                    cont++;
                }
                // Valid closing parenthesis
                else if(string.charAt(i) == ')' && cont > 0){
                    cont--;
                }
            }

            // Output result
            if(erro > 0){
                System.out.println("incorrect");
            }
            else if(cont != 0){
                System.out.println("incorrect");
            }
            else{
                System.out.println("correct");
            }
        }
    }
}
