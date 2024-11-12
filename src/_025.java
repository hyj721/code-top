/**
 * @author huyijin
 * @date 2024-08-25 18:09
 **/
public class _025 {
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(-1, head);
            ListNode pre = dummy;
            ListNode end = pre;
            ListNode begin = head;
            while (begin != null) {
                // 1、把end移动到末端
                for (int i = 0; i < k && end != null; i++) {
                    end = end.next;
                }
                if (end == null) {
                    break;
                }
                // 2、切断当前链表
                ListNode nextBegin = end.next;
                end.next = null;
                // 3、反转
                ListNode reversedList = reverseList(begin);

                // 4、调转指针
                pre.next = reversedList;
                begin.next = nextBegin;
                // 5、调整三个位置
                pre = begin;
                end = begin;
                begin = nextBegin;
            }
            return dummy.next;
        }

        private ListNode reverseList(ListNode head) {
            ListNode pre = null;
            while (head != null) {
                ListNode tmp = head.next;
                head.next = pre;
                pre = head;
                head = tmp;
            }
            return pre;
        }
    }
}
