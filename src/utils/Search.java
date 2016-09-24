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
            if (nums[low] <= nums[mid]) { // [low, mid + k] is increment zone, [mid + k + 1, high] is increment zone II
                if (nums[low] <= target && target < nums[mid]) { // low <= target < mid
                    high = mid - 1; // search in [low, mid - 1]
                } else {
                    low = mid + 1; // search in [mid, mid + k...high]
                }
            } else { // [mid - k, mid + j] is increment zone, [mid + j + 1, high] is increment zone II
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * Follow up for "search in Rotated Sorted Array": What if duplicates are allowed?
     * Would this affect the run-time complexity? How and why?
     * Write a function to determine if a given target is in the array.
     * [1 3 1 1 1]
     * @param nums The input data
     * @param target The target data to search
     * @return true if target exists otherwise false
     */
    public static boolean biSearchRotateII(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (target == nums[mid]) return true;
            if (nums[low] < nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[low] > nums[mid]) {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else { // drop duplicate data and continue
                low++;
            }
        }
        return false;
    }

    /**
     * There are two sorted arrays A and B of size m and n respectively. Find the median of
     * the two sorted arrays. The overall run time complexity should be O(log(m+n));
     * @param left The first sorted array
     * @param right The second sorted array
     * @return The median of left and right sorted arrays
     */
    public static int getMedianOfTwoSortedArrays(int[] left, int[] right) {
        if (left.length == 0 && right.length == 0) return -1;
        if (left.length == 0 && right.length > 0) return right[right.length >> 1];
        if (left.length != 0 && right.length == 0) return left[left.length >> 1];
        if (left.length == 1 && right.length == 1) return Math.min(left[0], right[0]);

        int k = left.length + right.length >> 1;
        int[] p = new int[k];
        int[] q = new int[k];
        System.arraycopy(left, 0, p, 0, k);
        System.arraycopy(right, 0, q, 0, k);
        while (k > 0) {
            if (p[k - 1] < q[k - 1]) { //left[(i+j)/2] < right[(i+j)/2]
                System.arraycopy(left, k, p, 0, left.length - k);
            } else if (p[k - 1] == q[k - 1]) {
                break;
            } else { // left[(i+j)/2] > right[(i+j)/2]
                System.arraycopy(right, k, q, 0, right.length - k);
            }
            k--;
        }
        return p[k];
    }

    /**
     * Find the Kth large data from two sorted arrays A and B of size m and n respectively.
     * @param left The first sorted array
     * @param right The second sorted array
     * @param k The index of the data in two arrays, sorted by the data value
     * @return The value of data that is the Kth large
     */
    public static int getKthNumberFromTwoSortedArrays(int[] left, int[] right, int k) {
        return 0;
    }
}
