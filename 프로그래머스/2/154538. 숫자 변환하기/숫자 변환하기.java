class Solution {
    
    private static final int MAX = Integer.MAX_VALUE;

    public static int solution(int x, int y, int n) {
        int answer = 0;

        int[] dp = new int[y + 1]; // 각 숫자에 대한 최소 연산 횟수를 저장하는 배열

        for (int i = x + 1; i < y + 1; i++) { // x부터 y까지의 모든 숫자에 대해
            int a = MAX, b = MAX, c = MAX, d;

            // 2로 나누어 떨어지고, x보다 크거나 같은 숫자인 경우 해당 숫자를 만들기 위한 최소 연산 횟수를 가져옴
            if (isDivided(i, 2) && aboveX(x, i / 2)) {
                a = dp[i / 2];
            }
            
            // 3으로 나누어 떨어지고, x보다 크거나 같은 숫자인 경우 해당 숫자를 만들기 위한 최소 연산 횟수를 가져옴
            if (isDivided(i, 3) && aboveX(x, i / 3)) {
                b = dp[i / 3];
            }
            
            // 현재 숫자에서 n을 뺀 값이 x보다 크거나 같은 숫자인 경우 해당 숫자를 만들기 위한 최소 연산 횟수를 가져옴
            if (aboveX(x, i - n)) {
                c = dp[i - n];
            }

            // 숫자 i를 만들기 위한 최소 방법을 찾음
            d = Math.min(a, b);
            d = Math.min(d, c);

            // 만들 수 있으면 d+1 저장
            // 만들 수 없다면 MAX 저장
            dp[i] = (d < MAX) ? d + 1 : MAX;
        }

        // y를 만들 수 없다면 -1 반환
        answer = (dp[y] < MAX) ? dp[y] : -1;

        return answer;
    }
    
    
    // x 보다 작은 위치의 값을 비교하지 않게 함
    private static boolean aboveX(int x, int num) {
        return (num >= x);
    }

    //  (i / 2), (i / 3)의 연산 결과가 자연수인지 확인함
    private static boolean isDivided(int num, int divide) {
        return (num / divide > 0 && num % divide == 0);
    }
}
