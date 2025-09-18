import java.util.*;

class Main {

    public static void main(String[] args) {

        // 값 입력
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] orderArray = new int[N];

        // 순서 배열에 우선 주어진 순서대로 값을 넣어서 배열을 만들어준다.
        for (int i = 0; i < N; i++) {
            orderArray[i] = scanner.nextInt();
        }
        scanner.close();

        // 중간 점검
        // System.out.println(Arrays.toString(orderArray));

        // 오름 차순 정렬
        int[] sortedOrderArray = sort(orderArray);

        // 계산
        int answer = calculateTime(N, sortedOrderArray);

        // 반환
        System.out.println(answer);

    }

    /* 오름 차순 정렬 함수 */
    private static int[] sort(int[] orderArray) {

        // 배열 복사
        int[] sortedOrderArray = orderArray.clone();

        // 오름차순 정렬
        Arrays.sort(sortedOrderArray);

        // 중간 점검
        // System.out.println(Arrays.toString(sortedOrderArray));

        return sortedOrderArray;
    }

    /* 시간 합 계산 */
    private static int calculateTime(int N, int[] sortedOrderArray) {

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (N - i) * sortedOrderArray[i];
        }

        return sum;
    }

}
