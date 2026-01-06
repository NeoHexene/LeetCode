class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]<min){
                min = arr[i]-arr[i-1];
            }
        }
        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1] == min)
                result.add(Arrays.asList(arr[i-1],arr[i]));
        }
        return result;
    }
}