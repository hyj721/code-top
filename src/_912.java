/**
 * @author huyijin
 * @date 2024-08-26 15:28
 **/
public class _912 {
    class Solution {
        public int[] sortArray(int[] nums) {
            mergeSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSort(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            int i = left - 1, j = right + 1, x = nums[left + right >> 1];
            while (i < j) {
                do {
                    i++;
                } while (nums[i] < x);
                do {
                    j--;
                } while (nums[j] > x);
                if (i < j) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
            quickSort(nums, left, j);
            quickSort(nums, j + 1, right);
        }

private void mergeSort(int[] nums, int left, int right) {
    if (left >= right) {
        return;
    }
    int mid = (left + right) /2;
    mergeSort(nums, left, mid);
    mergeSort(nums, mid + 1, right);
    int[] tmp = new int[right - left + 1];
    int k = 0, p = left, q = mid + 1;
    while (p <= mid && q <= right) {
        if (nums[p] <= nums[q]) {
            tmp[k++] = nums[p++];
        } else {
            tmp[k++] = nums[q++];
        }
    }
    while (p <= mid) {
        tmp[k++] = nums[p++];
    }
    while (q <= right) {
        tmp[k++] = nums[q++];
    }
    for (int i = left; i <= right; i++) {
        nums[i] = tmp[i - left];
    }
}
    }
}
