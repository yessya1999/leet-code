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

    /**
     * 不带虚拟头节点
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {

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

    /**
     * 带虚拟头节点
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head){
        ListNode dummyHead = new ListNode(-1, null);
        dummyHead.next = head;

        ListNode first = null;
        ListNode second = null;
        ListNode cur = dummyHead;

        while(cur.next != null && cur.next.next != null){
            first = cur.next;
            second = cur.next.next;
            ListNode tmp = second.next;
            cur.next = second;
            second.next = first;
            first.next = tmp;
            cur = first;
        }

        return dummyHead.next;
    }

    /**
     * 带头结点的递归解法
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode tmp = head.next;
        head.next = tmp.next;
        tmp.next = head;
        head.next = swapPairs(head.next);
        return tmp;
    }
}
