package List;

/**
 * 24. 两两交换链表中的节点(只能进行节点交换)
 */
public class Issue24 {

    public static void main(String[] args) {
        ListNode node0 = new ListNode(1, null);
        ListNode node1 = new ListNode(2, null);
        ListNode node2 = new ListNode(3, null);
        ListNode node3 = new ListNode(4, null);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        new Issue24().swapPairs(node0);
    }

    public ListNode swapPairs(ListNode head) {

        ListNode first = head;
        ListNode second = null;
        ListNode pre = null;

        while(first != null){
            if(first.next == null){
                break;
            }
            second = first.next;
            ListNode tmp = second.next;
            second.next = first;
            first.next = tmp;
            if(pre == null){
                head = second;
            }else{
                pre.next = second;
            }
            pre = first;
            first = tmp;
        }
        return head;
    }
}
