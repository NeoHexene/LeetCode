class Solution {

    public int[] findEvenNumbers(int[] digits) {
        //create a hashset to keep the track of used indeces in the three digit number
        HashSet<Integer> usedIndices = new HashSet<>();

        //create another hashset to have the unique three digit even numbers
        HashSet<Integer> finalResult = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        Arrays.sort(digits);

        //let us call the helper function
        helper(digits, 0, sb, usedIndices, finalResult);

        List<Integer> list = new ArrayList<>(finalResult);
        Collections.sort(list);

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i); //  now .get() works
        }
        return result;
    }

    public void helper(int[] digits, int index, StringBuilder sb, HashSet<Integer> usedIndices,
            HashSet<Integer> finalResult) {
        //base case
        if (index == 3) {
            //add the element to the finalResult
            int number = Integer.parseInt(sb.toString());
            if (number % 2 == 0 && number >= 100 && number < 999) {
                finalResult.add(number);
            }
            return;
        }

        for (int j = 0; j < digits.length; j++) {

            if (usedIndices.contains(j))
                continue;
            if (j > 0 && digits[j] == digits[j - 1] && !usedIndices.contains(j - 1))
                continue;

            if (!usedIndices.contains(j)) {
                sb.append(digits[j]);
                usedIndices.add(j);
                helper(digits, index + 1, sb, usedIndices, finalResult);
                //backtrack
                sb.deleteCharAt(sb.length() - 1);
                usedIndices.remove(j);
            }

        }

    }
}
