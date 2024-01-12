package List;

import java.util.HashSet;

/**
 * 面试题 02.07. 链表相交
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点
 */
public class mianshi02_07 {

    /**
     * 双指针
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode idxA = headA;
        ListNode idxB = headB;

        while(idxA != null && idxB != null){
            idxA = idxA.next;
            idxB = idxB.next;
        }
        if(idxA != null){
            idxB = headA;
            while(idxA != null){
                idxA = idxA.next;
                idxB = idxB.next;
            }
            idxA = headB;
        }else{
            idxA = headB;
            while(idxB != null){
                idxA = idxA.next;
                idxB = idxB.next;
            }
            idxB = headA;
        }

        while(idxA != null){
            if(idxA == idxB){
                return idxA;
            }
            idxA = idxA.next;
            idxB = idxB.next;
        }

        return null;
    }

    /**
     * 利用 hashset
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }

        while(headB != null){
            if(set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
