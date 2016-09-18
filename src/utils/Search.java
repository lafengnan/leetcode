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
    public static int biSearchRecursive(int[] nums, int low, int high, int target) {
        int mid = (low + high) >> 1;
        while (low != high) {
            if (nums[mid] == target) return mid;
            if (target < nums[mid]) {
                return biSearchRecursive(nums, low, mid - 1, target);
            } else if (target > nums[mid]) {
                return biSearchRecursive(nums, mid + 1, high, target);
            }
        }
        return nums[mid] == target?low:-1;
    }

    /**
     * Search target with binary search non-recursively.
     * @param nums The source data for searching
     * @param target The data to search
     * @return position of target in nums if exists, otherwise -1
     */
    public static int biSearch(int[] nums, int target) {
        int low = 0, last = nums.length - 1;
        while (low <= last) {
            int mid = (low + last) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (target < nums[mid]) {
                    last = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return nums[low] == target?low:-1;
    }

    /**
     * Enhancement to biSearch, it also supports rotated sorted array. A rotated
     * array looks like:
     * origin: [0 1 2 3 4 5 6 7]
     * rotated: [3 4 5 6 7 0 1 2]
     * Even though the array has been rotated, it should can also process the search
     * functionality.
     * @param nums Source data array to search
     * @param target The target data for searching
     * @return The index of target in nums if the target exists, otherwise -1
     */
    public static int biSearchRotate(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[low] <= nums[mid]) { // [low, mid + k] is increment zone, [mid + k + 1, high] is decrement zone
                if (nums[low] <= target && target < nums[mid]) { // low <= target < mid
                    high = mid - 1; // search in [low, mid - 1]
                } else {
                    low = mid + 1; // search in [mid, mid + k...high]
                }
            } else { // [low, mid + k] is decrement zone, [mid + k + 1, high] is increment zone
                if (target > nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
