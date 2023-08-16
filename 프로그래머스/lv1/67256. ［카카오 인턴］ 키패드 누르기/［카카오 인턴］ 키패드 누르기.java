class Solution {
    
    // 왼손과 오른손의 위치를 계속 관리해야되니까 
    // 멤버 변수로 Position left, Position Right를 정의해주고,
    // 숫자의 위치를 담기 위한 PositionPos도 같이 멤버 변수로 정의 
    Position left;
    Position right;
    Position numPos;
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        // 1. 왼손 오른손 위치를 초기화하자 
        left = new Position(3,0);
        right = new Position(3,2);
        
        for (int num : numbers) {
            // 2. 숫자를 누를 손가락을 정하자 
            numPos = new Position((num - 1) / 3, (num - 1) % 3);
            if (num == 0) {
                numPos = new Position(3,1);
            }
            String finger = numPos.getFinger(hand);
            
            // 3. 정해진 손가락을 answer에 담고 손가락 위치를 이동시킨다 
            answer += finger;
            if (finger.equals("L")) {
                left = numPos;
            } else {
                right = numPos;
            }
        }
        
        return answer;
    }
    
    // 손가락 위치를 Position 이라는 class로 정의해주자 
    class Position {
        int row;
        int col;
        
        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        public String getFinger(String hand) {
            String finger = hand.equals("right")?"R":"L";
            // 주로 쓰는 손이 right와 일치하면 R, 아니면 L
            
            if(this.col == 0) {
                finger = "L";
            } else if (this.col == 2) {
                finger = "R";
            } else {
                // col값이 1이면 (2, 5, 8, 0) 이면 최적의 위치를 계산해야된다 
                int leftDist = left.getDistance(this);
                int rightDist = right.getDistance(this);
                
                if (leftDist < rightDist) {
                    finger = "L";
                } else if (rightDist < leftDist) {
                    finger = "R";
                }
            }
            
            return finger;
            
        }
        
        public int getDistance(Position p) {
            // Math.abs 메소드 사용으로 위치 절대값을 구해주자 
            return Math.abs(this.row - p.row) + Math.abs(this.col - p.col);
        }
        
    }
}