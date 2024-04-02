class Solution {
    public int solution(int[] num_list) {
        String oddString = "";
        String evenString = "";
        
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 0) {
                evenString += Integer.toString(num_list[i]);
            } else {
                oddString += Integer.toString(num_list[i]);
            }
        }
        
        int oddSum = Integer.parseInt(oddString);
        int evenSum = Integer.parseInt(evenString);
        
        return oddSum + evenSum;
    }
}