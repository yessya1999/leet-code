package List;

/**
 * 203.移除链表元素
 * 删除链表中等于给定值 val 的所有节点
 */

public class Issue203 {
    /**
     * 头节点单独讨论-直接使用原来的链表来进行删除操作。
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val){
        ListNode pre = null;
        ListNode cur = head;

        while(cur != null){
            if(cur.val == val){
                if(pre == null){
                    head = head.next;
                }else{
                    pre.next = cur.next;
                }
                cur = cur.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 头节点单独讨论2
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        while(head != null && head.val == val){
            head = head.next;
        }
        if(head == null){
            return head;
        }

        ListNode pre = head;

        while(pre.next != null){
            if(pre.next.val == val){
                pre.next = pre.next.next;
            }else{
                pre = pre.next;
            }
        }

        return head;
    }

    /**
     * 设置一个虚拟头结点在进行删除操作
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements3(ListNode head, int val) {
        ListNode first = new ListNode();
        first.next = head;

        ListNode pre = first;

        while(pre.next != null){
            if(pre.next.val == val){
                pre.next = pre.next.next;
            }else{
                pre = pre.next;
            }
        }

        return first.next;
    }

    /**
     * 递归解法
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }

        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        }
        return head;
    }
}
