import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 친구 이름과 인덱스를 매핑하기 위한 HashMap 생성
        Map<String, Integer> map = new HashMap<>();
        // friends 배열을 순회하면서 각 친구의 이름과 인덱스를 매핑
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }
        // 각 친구들이 받은 선물의 수와 준 선물의 수의 차이를 저장하는 배열 생성
        int[] index = new int[friends.length];
        // 친구들 간에 주고 받은 선물의 기록을 저장하는 배열 생성 
        int[][] record = new int[friends.length][friends.length];

        // gifts 배열을 순회하면서 각 선물을 주고 받은 기록 처리
        for (String str : gifts) {
            String[] cur = str.split(" ");
            // 선물을 준 친구의 인덱스에 해당하는 index 값을 증가
            index[map.get(cur[0])]++;
            // 선물을 받은 친구의 인덱스에 해당하는 index 값을 감소
            index[map.get(cur[1])]--;
            // record 배열에 해당 친구들 간의 선물 수 기록
            record[map.get(cur[0])][map.get(cur[1])]++;
        }

        // 가장 많은 선물을 받을 친구를 예측하기 위한 count 변수
        int answer = 0;
        // 각 친구들에 대해 자신이 다른 친구들에게 선물을 더 많이 보냈는지 체크하여 count 값 계산
        for (int i = 0; i < friends.length; i++) { // i = 현재 선물을 받을 친구
            int cnt = 0;
            for (int j = 0; j < friends.length; j++) { // j = 비교할 친구
                // 같은 친구일 경우 continue
                if(i == j) {
                    continue;
                }
                // record 배열과 index 배열을 이용하여 선물 지수 비교
                if (record[i][j] > record[j][i]) {
                    cnt++;
                }
                else if (record[i][j] == record[j][i] && index[i] > index[j]) {
                    cnt++; 
                }
            }
            // count 값 중 가장 큰 값을 answer에 저장
            answer = Math.max(cnt, answer);
        }
        
        // 가장 많은 선물을 받을 친구의 선물 수 반환
        return answer;
    }
}
