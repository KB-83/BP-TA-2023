package hw4.q1;

import java.util.Scanner;

public class Solution {
    static int n;
    static String[][] input;
    static int[][] output;
    public static void main(String[] args) {
        getInput(new Scanner(System.in));
        for (int i = 0 ; i < n; i++) {
            for(int j = 0 ; j < n; j++) {
                if (i == j) {
                    output[i][j] = 0;
                    continue;
                }
                if(findCheat(input[i][1], input[j][1])) {
                    output[i][j] = 1;
                }
                else{
                    output[i][j] = 0;
                }
            }
        }
        printOutput();
    }
    public static boolean findCheat(String s1,String s2) {
        int sameChars=0;
        if (s1.length() == 0 || s2.length() == 0) {
            return false;
        }
        a:for (int i = 0;i <s1.length();i++) {
            for (int j = 0; j < s2.length() ; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    sameChars++;
                    continue a;
                }
            }
        }
        if (sameChars > (s1.length() + s2.length()) /4 ) {
            return true;
        }
        return false;
    }

    public static void getInput (Scanner scanner) {
        n = scanner.nextInt();
        if (n > 0) {
            scanner.nextLine();
        }
        input = new String[n][2];
        output = new int[n][n];
        for (int i = 0; i < n ;i++) {
            String[] line = scanner.nextLine().split(" ");
            input[i][0] = line[0];
            if (line.length  == 1) {
                input[i][1] = "";
            }
            else {
                input[i][1] = line[1];
            }
        }
    }
    public static void printOutput() {
        for (int i = 0; i < output.length; i++) {
            boolean isICheater = false;
            for (int j = 0; j < output[i].length ; j++) {
                if(output[i][j] == 1) {
                    System.out.print(input[j][0]+" ");
                    isICheater = true;
                }
            }
            if (isICheater) {
                System.out.println();
            }
            else {
                System.out.println("no cheat for "+input[i][0]);
            }
        }
    }
}
