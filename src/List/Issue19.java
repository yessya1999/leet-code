package List;

/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class Issue19 {

    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummyHead = new ListNode(-1, null);
        dummyHead.next = head;
        ListNode fast = head;
        ListNode slow = dummyHead;
        int count = 0;

        while(fast != null){

            fast = fast.next;
            if(count >= n){
                slow = slow.next;
            }
            count++;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
