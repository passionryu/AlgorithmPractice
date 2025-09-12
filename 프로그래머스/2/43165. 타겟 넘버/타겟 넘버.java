class Solution {

    /* 제한 사항 1 : 주어지는 숫자의 개수는 2개 이상 20개 이하입니다. */
    // 만약, 모든 경우의 수를 브루트 포스로 계산한다고 하면, 2의 20승이다 (+/-이니까)
    // 현대 컴퓨터에서는 충분히 완전 탐색(DFS, BFS)로 풀 수 있는 범위이다.

    /* 제한 사항 2 : 각 숫자는 1 이상 50 이하인 자연수입니다. */
    // 음수가 없다 → 누적 합 계산에서 예외처리를 따로 하지 않아도 된다.

    /* 제한 사항 3 : 타겟 넘버는 1 이상 1000 이하인 자연수입니다. */

    /* What we have */
    // numbers[], target

    /* What we have to do */
    // 각 숫자에 -/+를 붙혀서, target을 만드는 모든 경우의 수를 구하기

    // sum=0, index=0
    // / \
    // +1,index=1 -1,index=1
    // / \ / \
    // +1,index=2 -1,index=2 +1,index=2 -1,index=2
    // / \ / \ / \ / \
    // +1,idx3 -1,idx3 +1,idx3 -1,idx3 +1,idx3 -1,idx3 +1,idx3 -1,idx3
    // (sum=3) (sum=1) (sum=1) (sum=-1) (sum=1) (sum=-1) (sum=-1)(sum=-3)

    // -> 약간, 위 그림처럼 풀어보면 좋을 것 같다.
    // 기본적으로 DFS인데, 가장 깊이 있는 노드가 Target과 같은지 비교해보고,
    // 같으면 answer += 1을 한다.

    private int count = 0;

    public int solution(int[] numbers, int target) {

        // DFS 호출 (최초 인덱스와 합은 0이다.)
        dfs(numbers, target, 0, 0);

        return count;
    }

    private void dfs(int[] numbers, int target, int index, int sum) {

        // 재귀 함수 = 재귀 호출 + 종료 조건

        /* 종료 조건: 배열 끝까지 탐색 */
        if (index == numbers.length) {
            if (sum == target) {
                count++; // target과 일치하면 1 증가
            }
            return; // 재귀 종료
        }

        /* 재귀 호출 */
        dfs(numbers, target, index + 1, sum + numbers[index]); // 현재 숫자를 + 선택
        dfs(numbers, target, index + 1, sum - numbers[index]); // 현재 숫자를 - 선택

    }

}