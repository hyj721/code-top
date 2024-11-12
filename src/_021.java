/**
 * @author huyijin
 * @date 2024-08-26 15:52
 **/
public class _021 {
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    cur.next = list1;
                    cur = cur.next;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    cur = cur.next;
                    list2 = list2.next;
                }
            }
            cur.next = list1 == null ? list2 : list1;
            return dummy.next;
        }
    }
}
