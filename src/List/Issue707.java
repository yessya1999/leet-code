package List;

import java.util.List;

/**
 * Issue707:手动实现链表常用功能
 */
public class Issue707 {

    ListNode list;

    public int get(int index) {
        int i = 0;
        ListNode cur = list;
        while(i <= index && cur != null){
            cur = cur.next;
            i++;
        }
        if(i == index){
            return cur.val;
        }else{
            return -1;
        }
    }

    public void addAtHead(int val) {
        ListNode first = new ListNode(val, list);

        list = first;
    }

    public void addAtTail(int val) {
        ListNode last = new ListNode(val, null);
        if(list == null){
            list = last;
        }
        ListNode cur = list;

        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = last;
    }

    public void addAtIndex(int index, int val) {
        ListNode add = new ListNode(val, null);
        if(index == 0){
            add.next = list.next;
            list = add;
        }
        if(list == null && index > 0){
            return;
        }
        int i = 1;
        ListNode cur = list.next;
        ListNode pre = list;
        while(i < index && cur != null){
            i++;
            cur = cur.next;
        }
        if(i == index){
            add.next = cur;
            pre.next = add;
        }
    }

    public void deleteAtIndex(int index) {
        if(list == null){
            return;
        }
        if(index == 0){
            list = list.next;
        }
        int i = 1;
        ListNode cur = list.next;
        ListNode pre = list;
        while(i < index && cur != null){
            i++;
            cur = cur.next;
        }
        if(i == index){
            pre.next = cur.next;
        }

    }
}
