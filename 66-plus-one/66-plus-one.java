class Solution {
    public int[] plusOne(int[] digits) {
		// Init and declare index
        int index = digits.length - 1;
        
		// If the last digit is not 9, simply add 1 to it
        if(digits[index] != 9) {
            digits[index] += 1;
            return digits;
        } else { 
			// If the last digit is 9, look for the closest non-9 element. 
			// If not found, change the 9 to 0
			// If found, add 1 and break the loop
            while(index >= 0) {
                if(digits[index] == 9) digits[index] = 0;
                else {
                    digits[index] += 1;
                    break;
                }
                index--;
            }
        }
        
        if(index < 0) { // If index is -1 OR < 0, it means the whole array is 9, then make a new array with new length
            int []result = new int [digits.length + 1];
            Arrays.fill(result, 0); // fill the array with '0'
            result[0] = 1; // set the first element as 1
            return result;
        }
        
        return digits;
    }
}