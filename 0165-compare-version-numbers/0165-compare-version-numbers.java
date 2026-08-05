class Solution {

    public int compareVersion(String version1, String version2) {

        int i = 0, j = 0;
        int m = version1.length(), n = version2.length();

        while (i < m || j < n) {

            int d1 = 0;

            while (i < m && version1.charAt(i) != '.') {
                d1 = d1 * 10 + (version1.charAt(i) - '0');
                i++;
            }

            int d2 = 0;

            while (j < n && version2.charAt(j) != '.') {
                d2 = d2 * 10 + (version2.charAt(j) - '0');
                j++;
            }

            if (d1 < d2) {
                return -1;
            }
            if (d2 < d1) {
                return 1;
            }

            i++;
            j++;
        }

        return 0;
    }
}