import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 1. 중복을 제거한다 
        HashSet<String> reportSet = new HashSet<String>();
        for (String rep : report) {
            reportSet.add(rep);
        }
        
        // 2. notifyListHash (신고한 사람과 신고된 사람의 Hash 목록) 을 만들어준다 
        HashMap<String, ArrayList<String>> notifyListHash = new HashMap<>();
        for (String rep : reportSet) {
            int blankIdx = rep.indexOf(" ");
            String reporter = rep.substring(0, blankIdx);
            String reportee = rep.substring(blankIdx + 1);
            
            ArrayList<String> reporterList = notifyListHash.getOrDefault(reportee, null);
            if (reporterList == null) {
                reporterList = new ArrayList<>();
            }
            reporterList.add(reporter);
            notifyListHash.put(reportee, reporterList);
        }
        
        // 3. notifyListHash 를 기반으로 reporterHash (신고된 사람과 신고 횟수 Hash 목록) 을 만든다 
        HashMap<String, Integer> reporterHash = new HashMap<>();
        for (ArrayList<String> notifyList : notifyListHash.values()) {
            if (notifyList.size() >= k) {
                for (String reporter : notifyList) {
                    reporterHash.put(reporter, reporterHash.getOrDefault(reporter, 0) + 1);
                }
            }
        }
        
        // 4. reporterHash 를 기반으로 answer 목록을 채운다 
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = reporterHash.getOrDefault(id_list[i], 0);
        }

        return answer;
    }
}