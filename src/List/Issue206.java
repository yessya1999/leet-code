package List;

/**
 * 206:反转链表
 */
public class Issue206 {

    public ListNode reverseList(ListNode head){
        if(head == null){
            return null;
        }

        ListNode revHead = head;
        head = head.next;

        while(head != null){
            ListNode cur = head;
            head = head.next;
            cur.next = revHead;
            revHead = cur;
        }
        return revHead;
    }

    public ListNode reverseList1(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode revHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return revHead;
    }
}
