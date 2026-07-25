class Solution {
    public String[] findOcurrences(String s, String first, String second) {

        String[] parts = s.split(" ");

        if (parts.length < 3) {
            return new String[] {};
        }

        List<String> resList = new ArrayList<>();

        for (int i = 0; i < parts.length - 2; i++) {
            if (parts[i].equals(first) && parts[i + 1].equals(second)) {
                resList.add(parts[i + 2]);
            }
        }

        String[] res = new String[resList.size()];

        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }

        return res;

    }
}