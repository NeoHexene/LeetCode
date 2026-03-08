# Simplest Java Solution || O(n) with Common Trap

# Approach
Calculate the prefix sum and suffix product for the elements in the array.
Strictly left sum will be prefix[i].
Strictly right product will be suffix[i+1].
Check if both are equal then return that index and -1 if we didn't find any such index.

# Common Pitfall
Beware of long overflow for the product as it grows astronomically. We can set limit for the product by checking if it has exceeded the total sum of the elements.

# Complexity
- Time complexity:O(n)
- Space complexity: O(n)

# Code
```java []
class Solution {
    public int smallestBalancedIndex(int[] nums) {
        long[] presum = new long[nums.length + 1];
        presum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }
        long[] sufprod = new long[nums.length + 1];
        sufprod[nums.length] = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (sufprod[i+1] > presum[nums.length]) {
                sufprod[i] = sufprod[i + 1];
            } else {
                sufprod[i] = sufprod[i + 1] * nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (presum[i] == sufprod[i+1]) {
                return i;
            }
        }
        return -1;
    }
}
```

Please Upvote