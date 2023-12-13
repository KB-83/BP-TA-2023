package hw4.q3;

import java.util.Scanner;

public class Solution {
    static int row;
    static int col;
    static int num;
    static String redName;
    static String blueName;
    static char[][] gameBoard;// 'r','b','n'

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        getInputs(scanner);
        char a = searchHorizontally();
        char b = searchVertically();
        char c = searchBiasRightward();
        char d = searchBiasLeftward();
        char outPut = 'n';
        if (a != outPut) {
            outPut = a;
        }
        else if(b != outPut) {
            outPut = b;
        }
        else if(c != outPut) {
            outPut = c;
        }
        else if(d != outPut) {
            outPut = d;
        }
        printOutPut(outPut);
    }
    public static void printOutPut(char output) {
        if (output == 'r') {
            System.out.println(redName);
        }
        else if(output == 'b') {
            System.out.println(blueName);
        }
        else {
            System.out.println("Tie!");
        }
    }
    public static void getInputs(Scanner scanner) {
        redName = scanner.nextLine();
        blueName = scanner.nextLine();
        row = scanner.nextInt();
        col = scanner.nextInt();
        num = scanner.nextInt();
        if (row > 0) {
            scanner.nextLine();
        }
        gameBoard = new char[row][col];
        String[] line;
        for(int i = 0; i < row ; i++) {
            line = scanner.nextLine().split(" ");
            for(int j = 0; j < col; j++) {
                gameBoard[i][j] = line[j].charAt(0);
            }
        }
    }
    public static char searchBiasLeftward() {
        for(int i = 2 * col; i>=0 ;i--) {
            int flag = i;
            int rCount = 0;
            int bCount = 0;
            for(int j = 0; j< row;j++){
                if (flag < col && flag > -1) {
                    if (gameBoard[j][flag] == 'r') {
                        rCount++;
                        bCount = 0;
                    } else if (gameBoard[j][flag] == 'b') {
                        bCount++;
                        rCount = 0;
                    } else {
                        bCount = 0;
                        rCount = 0;
                    }
                }
                flag = flag-1;
                if(rCount >= num){
                    return 'r';
                }
                else if(bCount >= num){
                    return 'b';
                }
            }
        }
        return 'n';
    }
    public static char searchBiasRightward() {
        for(int i = - col;i<col;i++) {
            int flag = i;
            int rCount = 0;
            int bCount = 0;
            for(int j = 0; j< row;j++){
                if (flag < col && flag > -1) {
                    if (gameBoard[j][flag] == 'r') {
                        rCount++;
                        bCount = 0;
                    } else if (gameBoard[j][flag] == 'b') {
                        bCount++;
                        rCount = 0;
                    } else {
                        bCount = 0;
                        rCount = 0;
                    }
                }
                flag = flag + 1;
                if(rCount >= num){
                    return 'r';
                }
                else if(bCount >= num){
                    return 'b';
                }
            }
        }
        return 'n';
    }
    public static char searchHorizontally() {
        for(int i = 0; i < row; i++) {
            int rCount = 0;
            int bCount = 0;
            for(int j = 0; j < col ; j++) {
                if(gameBoard[i][j] == 'r') {
                    rCount++;
                    bCount = 0;
                }
                else if(gameBoard[i][j] == 'b') {
                    bCount++;
                    rCount = 0;
                }
                else {
                    bCount = 0;
                    rCount = 0;
                }
                if(rCount >= num){
                    return 'r';
                }
                else if(bCount >= num){
                    return 'b';
                }
            }
        }
        return 'n';
    }
    public static char searchVertically() {
        for(int i = 0; i < col; i++) {
            int rCount = 0;
            int bCount = 0;
            for(int j = 0; j < row ; j++) {
                if(gameBoard[j][i] == 'r') {
                    rCount++;
                    bCount = 0;
                }
                else if(gameBoard[j][i] == 'b') {
                    bCount++;
                    rCount = 0;
                }
                else {
                    bCount = 0;
                    rCount = 0;
                }

                if(rCount >= num){
                    return 'r';
                }
                else if(bCount >= num){
                    return 'b';
                }
            }
        }
        return 'n';
    }
}
