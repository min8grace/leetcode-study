// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

 

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:

// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:

// Input: nums = [3,3], target = 6
// Output: [0,1]

// time complexity: Object(N^2) -> O(N)
// space complexity: O(1) - constant -> O(N)

var twoSum = function(nums, target) {

    for(var i=0; i<nums.length; i++){
        for(var j=i+1; j<nums.length; j++){
            if(nums[i]+nums[j] === target) {
                return [i,j];
            }
        }
    }
};
//[1,2,3,6,11] 5
//{4:0, 3:1}

function twoSum (nums, target){

    let memory = {};
    for(let i=0; i< nums.length; i++){
        if(memory[nums[i]] === undefined){
            memory[target-nums[i]] = i
        }else {
            return [i,memory[nums[i]]]
        }
    }
}
