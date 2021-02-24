package io.imwj.e_LinkedList_Recursive;

/**
 * @author langao_q
 * @since 2021-02-23 17:57
 */
public class leetcode203 {

    /**
     * 节点内部类
     */
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
    }

    /**
     * 删除指定元素 然后返回链表集合
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        //待删除节点
        ListNode delNode = head;
        //待删除节点的前一个节点
        ListNode prevNode = new ListNode();
        while (head.next != null){
            if(delNode.val == val){
                prevNode.next = delNode.next;
                delNode.next = null;
                return head;
            }
            prevNode = delNode;
            delNode = delNode.next;
        }
        return null;
    }

}
