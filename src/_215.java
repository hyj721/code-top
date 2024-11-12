/**
 * @author huyijin
 * @date 2024-08-25 17:51
 **/
public class _215 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return quickSort(nums, 0, nums.length - 1, k);
        }
        private int quickSort(int[] nums, int l, int r, int k) {
            if (l > r) {
                return -1;
            }
            if (l == r) {
                return nums[l]; // 此时k为1
            }
            int i = l - 1, j = r + 1, x = nums[l + r >> 1];
            while (i < j) {
                do {
                    i++;
                } while (nums[i] > x);
                do {
                    j--;
                } while (nums[j] < x);
                if (i < j) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
            int leftCount = j - l + 1;
            if (k <= leftCount) {
                return quickSort(nums, l, j, k);
            } else {
                return quickSort(nums, j + 1, r, k - leftCount);
            }
        }
    }
}
