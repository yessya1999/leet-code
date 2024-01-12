package List;

import java.util.HashSet;

/**
 * 142:环形链表 II
 */
public class Issue142 {
    /**
     * 通过查看 hashset是否重复，重复的第一个节点即为环的起始位置
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * 双指针 + 数学规律
     *
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
