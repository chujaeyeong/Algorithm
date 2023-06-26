class Solution {
    public int solution(int n, int k) {
        int total = n / 10;
        int answer = (n * 12000) + (k * 2000) - (total * 2000);
        return answer;
    }
}