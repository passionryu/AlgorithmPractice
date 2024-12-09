import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        int B = in.nextInt();

        int ones = B % 10;
        int tens = (B % 100) / 10;
        int hundreds = B / 100;

        int three = A * ones;
        int four = A * tens * 10;
        int five = A * hundreds * 100;

        System.out.println(A * ones);
        System.out.println(A * tens);
        System.out.println(A * hundreds);

        int total = three + four + five;
        System.out.println(total);

        in.close();
    }
}
