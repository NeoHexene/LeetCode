class Solution {
    public int minimumSum(int num) {
        int[] temp = new int[4];
        int count = 4;
        int i = 0;
        while (count != 0) {
            temp[i++] = num % 10;
            num /= 10;
            count--;
        }
        Arrays.sort(temp);
        int pair1 = temp[0] * 10 + temp[3];
        int pair2 = temp[1] * 10 + temp[2];

        return pair1 + pair2;
    }
}