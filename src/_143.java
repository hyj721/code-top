public class _143 {
    class Solution {
        public void reorderList(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode right = slow.next;
            slow.next = null;
            right = reverseList(right);
            ListNode left = head;
            while (left != null && right != null) {
                ListNode tmp1 = left.next;
                ListNode tmp2 = right.next;
                left.next = right;
                right.next = tmp1;
                left = tmp1;
                right = tmp2;
            }
        }

        private ListNode reverseList(ListNode list) {
            ListNode pre = null;
            ListNode cur = list;
            while (cur != null) {
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            return pre;
        }
    }
}
