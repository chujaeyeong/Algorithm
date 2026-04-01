class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        for (int k = 0; k < queries.length; k++) {
            int i = queries[k][0];
            int j = queries[k][1];
            
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
        return arr;
    }
}