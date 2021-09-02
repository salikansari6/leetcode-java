public class RemoveNthFromEnd {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = removeNthFromEnd(head,2);
        System.out.println(head.val);

    }

    static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyNode = new ListNode(0);
        ListNode slowPtr = dummyNode;
        ListNode fastPtr = dummyNode;
        dummyNode.next = head;

        int count = 0;
        while(count <= n){
            fastPtr = fastPtr.next;
            count++;
        }

        while(fastPtr!=null){
            // slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = slowPtr.next.next;

        return dummyNode.next;
    }
}



 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

