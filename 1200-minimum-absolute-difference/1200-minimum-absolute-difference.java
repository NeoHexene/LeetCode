class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i + 1 < arr.length; i++) {
            int diff = Math.abs(arr[i] - arr[i+1]);
            if (minDiff >= diff) {
                List<List<Integer>> diffList = map.getOrDefault(diff, new ArrayList<>());
                diffList.add(List.of(arr[i], arr[i+1]));
                map.put(diff, diffList);
                minDiff = diff;
            }
        }
        return map.get(minDiff);
    }
}