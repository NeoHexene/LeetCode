class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0, right = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int len = 0;
        for (; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left += 1;
            }
            len = Math.max(len, right - left + 1);
        }
        return len;
    }
}