import java.util.HashMap;
import java.util.Map;

/**
 * @author huyijin
 * @date 2024-08-25 15:07
 **/
public class _003 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int i = 0, j = 0;
            int res = 0;
            for (; j < s.length(); j++) {
                char cur = s.charAt(j);
                if (!map.containsKey(s.charAt(j))) {
                    map.put(cur, j);
                } else {
                    i = Math.max(i, map.get(cur) + 1);
                    map.put(cur, j);
                }
                res = Math.max(res, j - i + 1);
            }
            return res;
        }
    }

    class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            Map<Character, Integer> map = new HashMap<>();
            map.put(s.charAt(0), 0);
            int[] dp = new int[s.length()];
            dp[0] = 1;
            int res = 1;

            for (int i = 1; i < dp.length; i++) {
                char cur = s.charAt(i);
                if (!map.containsKey(cur)) {
                    dp[i] = dp[i - 1] + 1;
                    map.put(cur, i);
                } else {
                    int prevIndex = map.get(cur);
                    if (i - dp[i - 1] > prevIndex) {
                        dp[i] = dp[i - 1] + 1;
                    } else {
                        dp[i] = i - prevIndex;
                    }
                    map.put(cur, i);
                }
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}
