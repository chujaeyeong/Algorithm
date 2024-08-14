class Solution {
    public int solution(int n) {
        // Math.sqrt(n) 은 무조건 float 라서 int 인지 체크해야됨
        if (Math.sqrt(n) % 1 == 0) {
            return 1;
        } else {
            return 2;
        }
    }
}