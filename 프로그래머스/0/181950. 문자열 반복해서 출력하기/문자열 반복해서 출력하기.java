import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        
         // StringBuilder를 사용해 문자열 반복
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        
        System.out.println(sb.toString());
    }
}