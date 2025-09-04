import java.util.*;

class Solution {

    // 교점을 표현하는 클래스
    private static class Point {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    // 정수인 교점만 반환하는 함수
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {

        double x = (double) (b1 * c2 - c1 * b2) / (a1 * b2 - b1 * a2);
        double y = (double) (c1 * a2 - a1 * c2) / (a1 * b2 - b1 * a2);
        if (x % 1 != 0 || y % 1 != 0)
            return null;

        return new Point((long) x, (long) y);
    }

    // Solution 함수
    public   String[] solution(int[][] line) {

        // 1. 유효한 접점들을 담을 리스트
        List<Point> points = new ArrayList<>();

        // 2. 모든 직선을 반복하여 비교하며 유효한 접점 추출 + 리스트에 저장
        for (int i = 0; i < line.length; i++) {
            for (int j = 1; j < line.length; j++) {

                Point point = intersection(
                        line[i][0], line[i][1], line[i][2],
                        line[j][0], line[j][1], line[j][2]);

                // 접점이 유효하면(null값이 아니면) 리스트에 저장
                if (point != null)
                    points.add(point);

            }
        }

        // 3. X,Y에 대해 최대/최소 좌표 구하기기
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;

        for (Point point : points) {
            if (point.x < minX)
                minX = point.x;
            if (point.x > maxX)
                maxX = point.x;
            if (point.y < minY)
                minY = point.y;
            if (point.y > maxY)
                maxY = point.y;
        }

        // 4. 배열 생성
        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);
        char[][] grap = new char[height][width];
        for (char[] row : grap)
            Arrays.fill(row, '.'); // 모든 행(row)를 순환하며 '.'으로 초기화

        // 5. (0,0)을 기준으로 '*' 찍기
        // (0,0) 은 (minX, maxY)값이다.
        for (Point p : points) {
            int col = (int) (p.x - minX); // X → 열
            int row = (int) (maxY - p.y); // Y → 행 (위쪽이 0)
            grap[row][col] = '*';
        }

        // 6. 각 행별 String으로 반환
        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(grap[i]);
        }

        for (String lin : answer) {
            // System.out.println(lin);
        }
        return answer;
    }

    // ---------------- 테스트용 main ----------------

//     public static void main(String[] args) {
//         Solution solution = new Solution();
//         int[][] input = { { 2, -1, 4 }, { -2, -1, 4 }, { 0, -1, 1 }, { 5, -8, -12 }, { 5, 8, 12 } };

//         String[] result = solution.solution(input);

//         // for (String line : result) {
//         //     System.out.println(line);
//         // }

//     }
}