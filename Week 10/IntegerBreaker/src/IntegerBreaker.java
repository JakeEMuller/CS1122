import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class IntegerBreaker {
    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number to break down: ");
        int input = in.nextInt();
        int save = input;

        if(input != 0){

            while(input != 0){
                int temp = input % 10;
                numbers.add(temp);
                input = input - temp;
                input = input/10;
            }


            //prints the stack
            int size = numbers.size();
            System.out.println("Your number was " + save +":");
            for(int i = 0; i < size; i++){
                System.out.print(numbers.pop() + " ");
            }


        } else {
            System.out.println( 0 );
        }


    }

}
