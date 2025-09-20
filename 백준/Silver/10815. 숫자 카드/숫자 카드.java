import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        // 버퍼를 활용한 입력
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        // System.out.println(N);

        // 토크나이저를 활용한 입력값 분리
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // 해시 선언
        Set<Integer> set = new HashSet<>();

        // 상근이의 숫자 카드를 해시에 입력
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());
            set.add(number);
        }

        int M = Integer.parseInt(bufferedReader.readLine());
        // System.out.println(M);

        StringBuilder stringBuilder = new StringBuilder();

        // 비교 카드 입력
        StringTokenizer compareTokenizer = new StringTokenizer(bufferedReader.readLine());
        // 주어진 카드로 비교
        for (int i = 0; i < M; i++) {
            int comparisonNumber = Integer.parseInt(compareTokenizer.nextToken());

            // 셋 해쉬에 비교 정수가 있는지 확인
            boolean exists = set.contains(comparisonNumber);

            if (exists) {
                stringBuilder.append(1);
                stringBuilder.append(" ");
                // System.out.println("값 존재, 1추가");

            } else {
                stringBuilder.append(0);
                stringBuilder.append(" ");
                // System.out.println("값 없음, 0추가");
            }

        }

        // 출력
        System.out.println(stringBuilder.toString());

    }
}
