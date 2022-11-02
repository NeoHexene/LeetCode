/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    var newElement = 1;
    for (let i = 1; i<nums.length; i+=1) {
        if (nums [i-1] < nums[i]) {
            nums[newElement] = nums[i];
            newElement += 1;
        }
    }
    return newElement;
};