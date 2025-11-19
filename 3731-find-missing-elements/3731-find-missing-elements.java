class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> input = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        Collections.sort(input);
        int low = input.get(0);
        int high = input.get(input.size() - 1);
        List<Integer> list = new ArrayList<>();
        while (low < high) {
            if (!input.contains(low)) {
                list.add(low);
            }
            low++;
        }
        Collections.sort(list);
        return list;
    }
}