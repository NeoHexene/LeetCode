class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int counts[] = new int[2];
        for (int i = 0; i < students.length; i++) {
            counts[students[i]] += 1;
        }
        int remaining = sandwiches.length;
        for (int i = 0; i < sandwiches.length; i++) {
            if (counts[sandwiches[i]] == 0) {
                break;
            }
            if (remaining == 0) {
                break;
            }
            remaining -= 1;
            counts[sandwiches[i]] -= 1;
        }
        return remaining;
    }
}