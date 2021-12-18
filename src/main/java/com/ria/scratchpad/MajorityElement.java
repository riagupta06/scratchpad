package com.ria.scratchpad;

/**
 * Leetcode: 169
 */
public class MajorityElement {

    public int majority(int[] nums) {
        //Solution 1
        /*int length = nums.length;
        Map<Integer, Integer> counts = new HashMap<>();
        for(int num : nums) {
            int count = counts.getOrDefault(num, 0) + 1;
            if(count > length/2) {
                return num;
            }
            counts.put(num, count);
        }
        return -1;*/

        //Solution 2
        /*Arrays.sort(nums);
        return nums[nums.length/2];*/

        //Solution 3
        //The problem can be solved in O(1) space and O(n) time. The idea is that the majority element can negate all other element's count
        int candidate = -1;
        int votes = 0;
        for(int num : nums) {
            if(votes == 0) {
                candidate = num;
                votes = 1;
            } else if(candidate == num) {
                votes++;
            } else {
                votes --;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] arr1 = {3,2,3};
        int[] arr2 = {2,2,1,1,1,2,2};
        int majority1 = majorityElement.majority(arr1);
        int majority2 = majorityElement.majority(arr2);
        System.out.println(majority1 == 3 && majority2 == 2 ? "All tests passed" : "Failed");
    }
}
