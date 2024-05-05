import java.util.Scanner;

public class StringFunctionCalculation {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("please input a string to calculate the maximum value of among all the substrings based on the following formula ");
            System.out.println("f(s) = length of s × number of times s occurs in t " + "where t is the original string and s is the sub string ");
            String originalString = scanner.nextLine();
            scanner.close();
            if (originalString.isEmpty()) {
                System.out.println("please provide a valid string ");
            } else {
                System.out.println("maximum value of among all the substrings of the given string " + calculateMaxFunctionValue(originalString));
            }
        } catch (Exception e){
            System.err.println("an exception has occurred " + e.getMessage());
        }
    }

    public static int countSubstringOccurrences(String originalString, String subStr) {
        int count = 0;
        int length = subStr.length();
        int condition = originalString.length() - length;
        for (int i = 0; i <= condition ; i++) {
            if (originalString.substring(i, i + length).equals(subStr)) {
                count++;
            }
        }
        return count;
    }

    public static int calculateMaxFunctionValue(String originalString) {
        int maxFunctionValue = 0; //variable to hold the max

        for (int i = 0; i < originalString.length(); i++) { //outer loop to indicate original string (start of substring)
            for (int j = i + 1; j <= originalString.length(); j++) { //inner loop (end of substring)
                String substring = originalString.substring(i, j);
                int functionValue = calculateFormula(substring.length(),countSubstringOccurrences(originalString, substring));
                maxFunctionValue = Math.max(maxFunctionValue, functionValue); //math function to get the highest value if the previous one is higher keep it else the new value is the max
                //we can write logic for this as following
                                                                          /*
                                                                          if(functionValue > maxFunctionValue)
                                                                          {
                                                                             maxFunctionValue=functionValue
                                                                          }*/
            }
        }

        return maxFunctionValue;
    }

    public static int calculateFormula(int length, int occurrence){
        return length*occurrence; //f(s) = length of s × number of times s occurs in t
    }
}
