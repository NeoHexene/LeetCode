class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        List<Integer> res = new ArrayList<>();
        for (Integer bulb : bulbs) {
            int idx = res.indexOf(bulb);
            if (idx == -1) {
                res.add(bulb);
            } else {
                res.remove(idx);
            }
        }
        Collections.sort(res);
        return res;
    }
}