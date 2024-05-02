class Solution {
    public int solution(int balls, int share) {
        return combination(balls, share);
    }
    
    // 3개의 구슬을 뽑으려고 하면 -> 3C2 = 2C2 + 2C1 
    public static int combination(int balls, int share) {
        if (balls == share || share == 0) {
            return 1;
        }
        return combination((balls - 1), (share - 1)) + combination(balls - 1, share);
    }
}