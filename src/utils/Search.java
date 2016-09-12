package utils;

/**
 * Created by lafengnan on 16/9/11.
 */
public class Search {

    /**
     * Search data from array by using binary compare.
     * @param nums The input data to search
     * @param low The low index of input data
     * @param high The high index of input data
     * @param target The data to search
     * @return The index in nums if target exists other -1
     */
    public static int biSearch(int[] nums, int low, int high, int target) {
        int mid = (low + high) >> 1;
        while (low != high) {
            if (nums[mid] == target) return mid;
            if (target < nums[mid]) {
                return biSearch(nums, low, mid - 1, target);
            } else if (target > nums[mid]) {
                return biSearch(nums, mid + 1, high, target);
            }
        }
        return nums[mid] == target?low:-1;
    }
}
