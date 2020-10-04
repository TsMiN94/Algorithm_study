package BackJun;

import java.util.Scanner;

public class BJ16430 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stolenAmount = sc.nextInt();
        int wholeAmount = sc.nextInt();
        int remainAmout = wholeAmount - stolenAmount;
        System.out.println(remainAmout + " " + wholeAmount);
    }
}
