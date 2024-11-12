/**
 * @author huyijin
 * @date 2024-08-26 15:24
 **/
public class _053 {
    class Solution {
        public int maxSubArray(int[] nums) {
            // 设dp[i]表示以nums[i]结尾的子数组中，和的最大值
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int res = dp[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}
