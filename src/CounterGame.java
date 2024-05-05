import java.util.Scanner;

public class CounterGame {


    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the initial value for the game: ");
            int input = scanner.nextInt();
            scanner.close();

            String winner = counterGameTwosComplementSolution(input);
            System.out.println("The winner of the game is: " + winner);
        } catch (Exception e){
            System.err.println("an exception has occurred " + e.getMessage());
        }
    }

    private static String counterGameTwosComplementSolution(int n) { // The solution is based on two's complement
        //an int is 32-bit
        //if the initial counter is 1, Ali wins
        if(n <= 0 ){
            throw new IllegalArgumentException("sorry we only play with positive numbers ");
        }
        if (n == 1) {
            return "Ali";
        }

        int count = 0;

        //count the number of set bits in n-1
        while (n > 1) {
            int temp = n - 1;
            while ((temp & 1) == 0) {
                temp >>= 1; //right shifting which is equivalent to division by 2
                count++;   //example 4 in binary representation is 100 and 2 representation 10 so by shifting 1 to the right we omit the 0 effectively diving by 2
            }
            n = temp;
        }

        //if the count is even, Naser wins, otherwise Ali wins
        return (count % 2 == 0) ? "Naser" : "Ali";
    }

    //Time Complexity: The time complexity of this approach is O(log^2 n). It involves two nested loops, where the outer loop iterates logarithmically over the input n, and the inner loop counts the set bits in n-1, which also takes logarithmic time.
    //Space Complexity: The space complexity of this approach is O(1), as it doesn't use any additional space that grows with the input size.

}