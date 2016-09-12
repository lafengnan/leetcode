package array;

import utils.Search;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lafengnan on 16/9/11.
 */
public class ArraySolution {

    /**
     * Given an array and a value, remove all instances of that value
     * in place and return the new length. The order of elements can
     * be changed. It does not mater what you leave beyond the new length.
     * @param nums Input array
     * @param e The element to remove
     * @return The length of new array
     */
    public int removeElement(int[] nums, int e) {
        int i = 0, j = 0;
        for (; i < nums.length; i++) {
            if (e == nums[i]) continue;
            nums[j++] = nums[i];
        }
        return j;
    }

    /**
     * Given a sorted array, remove the duplicates in place such that
     * each element appear only once and return the new length. Do not
     * allocate extra space for another array, you must do this in place
     * with constant memory. For example,
     * Given input array A = [1,1,2],
     * Your function should return length = 2, and A is now [1,2].
     *
     * @param nums input data
     * @return length of remains
     */
    public int removeDuplicatesFromSortedArray(int[] nums) {
        int i = 0, j = 0;

        for (; i < nums.length; i++) {
            if (nums[i] == nums[j]) continue;
            nums[++j] = nums[i];
        }
        return ++j;
    }

    /**
     * Follow up for ”Remove Duplicates”: What if duplicates are allowed
     * at most twice? For example, Given sorted array A = [1,1,1,2,2,3],
     * Your function should return length = 5, and A is now [1,1,2,2,3]
     * @param nums Input data
     * @param n How many duplicates are allowed
     * @return The length of remains
     */
    public int removeDuplicatesFromSortedArrayN(int[] nums, int n) {
        int i = 1, j = 0, occur = 1;

        for (; i < nums.length; i++) {
            if (nums[i] == nums[j]) {
                if (occur < n) {
                    j++;
                    occur++;
                }
            } else {
                nums[++j] = nums[i];
                occur = 1;
            }
        }
        return ++j;
    }

    /**
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * You are given a target value to search. If found in the array return its index,
     * otherwise return -1. You may assume no duplicate exists in the array.
     * @param nums Input data
     * @param target The target number to search
     * @return The index of target in nums if exists otherwise -1
     */
    public int searchInRotatedSortedArray(int[] nums, int target) {
        return Search.biSearch(nums, 0, nums.length - 1, target);
    }

    public int[] twoSum(int[] nums, int target) throws Exception {

        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        throw new Exception("No records");
    }
}
