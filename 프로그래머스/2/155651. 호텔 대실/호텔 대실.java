import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        // 1. 예약 시간을 오름차순으로 정렬
        Arrays.sort(book_time, new Comparator<String[]>() {
           @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals(o2[0])) {
                    return o1[1].compareTo(o2[1]);
                } else {
                    return o1[0].compareTo(o2[0]);
                }
            }
        });
        
        // 2. 예약 시간을 정수로 변경 
        int[][] time = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            int start_time = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end_time = Integer.parseInt(book_time[i][1].replace(":", ""));
            
            end_time += 10;
            if (end_time % 100 >= 60) {
                end_time += 40;
            }
            
            time[i][0] = start_time;
            time[i][1] = end_time;
        }
        
        // 3. 예약 시간별로 객실 할당하기 
        ArrayList<Integer> rooms = new ArrayList<>();
        for (int i = 0; i < time.length; i++) {
            Collections.sort(rooms);
            
            boolean isAdd = false; // 객실 할당 유무
            
            // 4-1. 할당된 객실 중에 사용 가능한 객실 있다면 할당하기 
            for (int j = 0; j < rooms.size(); j++) {
                if (time[i][0] >= rooms.get(j)) {
                    rooms.set(j, time[i][1]);
                    isAdd = true;
                    break;
                }
            }
            
            // 4-2. 할당된 객실 중 현재 사용 가능한 객실이 없다면 새로 할당하기 
            if (!isAdd) {
                rooms.add(time[i][1]);
            }
            
        }
        
        return rooms.size();
    }
}