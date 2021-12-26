
public class LL {

    int size = 0;
    ListNode head = null;
    ListNode tail = size != 0 ? getPrevNode(size) : null;

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int d, ListNode n) {
            this.val = d;
            this.next = n;
        }

        public ListNode(int data) {
            this.val = data;
        }
    }

    public void reverseLL(ListNode temp) {
        if (temp.next == null) {
            head = temp;
            tail = head;
            return;
        }

        reverseLL(temp.next);
        tail.next = temp;
        tail = temp;
        tail.next = null;
    }

    public static ListNode reverseItr(ListNode head) {
        if (head.next == null || head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;

        while (pres != null) {
            pres.next = prev;
            prev = pres;

            pres = next;

            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    public void insert(int index, int value) {
        helper(index, value, head);
    }

    private ListNode getPrevNode(int index) {
        ListNode temp = head;

        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public void helper(int index, int value, ListNode temp) {
        if (size == 0 || index == 0) {
            ListNode node = new ListNode(value);
            node.next = head;
            head = node;
            size++;
            return;
        }
        if (index == 1) {
            // insert val
            ListNode node = new ListNode(value);
            node.next = temp.next;
            temp.next = node;
            size++;
            return;
        }

        if (index > size) {
            System.out.println("You can't add at " + index + " index, size of list is : " + size);
            return;
        }

        helper(index - 1, value, temp.next);
    }

    public void duplicates() {
        ListNode node = head;

        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
    }

    public void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static LL merge(LL list1, LL list2) {
        ListNode f = list1.head;
        ListNode s = list2.head;

        LL merged = new LL();

        while (f.next != null && s.next != null) {

            if (f.val < s.val) {
                merged.insert(merged.size, f.val);
                f = f.next;
            } else {
                merged.insert(merged.size, s.val);
                s = s.next;
            }

        }

        while (f.next != null) {
            merged.insert(merged.size, f.val);
            f = f.next;
        }

        while (s.next != null) {
            merged.insert(merged.size, s.val);
            s = s.next;
        }

        return merged;
    }

    public ListNode middleNode(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }

        return s;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode middleNode = middleNode(head);

        ListNode midHead = reverseItr(middleNode);

        // display(h);

        while (midHead.val == head.val && midHead.next != null) {
            head = head.next;
            midHead = midHead.next;
        }

        if (midHead.val == head.val) {
            return true;
        }

        return false;
    }

    public ListNode reorderList(ListNode head) {
        ListNode mNode = middleNode(head);
        ListNode hs = reverseItr(mNode);

        ListNode hf = head;

        while (hs.next != null && hs != null) {
            ListNode temp1 = hf.next;
            hf.next = hs;
            hf = temp1;

            temp1 = hs.next;
            hs.next = hf;
            hs = temp1;
        }

        return head;
    }

    public ListNode reverseInBetn(ListNode head, int l, int r) {
        if (l == r) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;
        for (int i = 0; i < l - 1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        prev = current;
        ListNode pres = prev.next;
        ListNode next = pres.next;

        for (int i = 0; pres != null && i < r - l; i++) {
            pres.next = prev;

            prev = pres;
            pres = next;
            if (next != null) {
                next = next.next;
            } else {
                next = null;
            }
        }

        // prev.next = pres;
        current.next = pres;

        if (last != null) {
            last.next = prev;
        } else {
            return prev;
        }

        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode last = head;
        ListNode start = null;
        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;
        int count = 0;

        while (pres != null) {
            count++;

            for (int i = 0; i < k; i++) {
                pres.next = prev;
                prev = pres;
                pres = next;
                if (pres == null && i < k - 1) {
                    ListNode h = reverseItr(prev);
                    last.next = h;
                    return head;
                }

                if (next != null) {
                    next = next.next;
                } else {
                    next = null;
                }
            }

            if (count == 1) {
                head = prev;
            } else {
                last.next = prev;
                last = start;
            }

            start = pres;

            prev = null;

        }

        return head;
    }

    private LL.ListNode reverseKGroupAlt(LL.ListNode head2, int k) {

        ListNode last = head;
        ListNode start = null;
        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;
        int count = 0;

        while (next != null) {
            count++;

            if (count % 2 == 0) {
                for (int i = 0; i < k; i++) {
                    prev = pres;
                    pres = next;
                    if (next != null) {
                        next = next.next;
                    } else {
                        next = null;
                    }
                }
                last.next = start;
                start = pres;
                last = prev;
                prev = null;

            } else {

                for (int i = 0; i < k; i++) {
                    pres.next = prev;
                    prev = pres;
                    pres = next;

                    if (next != null) {
                        next = next.next;
                    } else {
                        next = null;
                    }
                }

                if (count == 1) {
                    head = prev;
                } else {
                    last.next = prev;
                    last = start;
                }

                start = pres;
                prev = null;

            }
        }

        return head;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode prev = null;
        ListNode newHead;
        int len = 1;

        while (temp.next != null) {
            len++;
            prev = temp;
            temp = temp.next;
        }
        
        temp.next = head;
        temp = head;
        prev = null;

        int itr = len - k % len;

        while ( itr-- > 0) {
            prev = temp;
            temp = temp.next;
        }

        newHead = temp;
        prev.next = null;

        return newHead;
    }

    public static void main(String[] args) throws Exception {
        LL list1 = new LL();
        list1.insert(3, 1);
        list1.insert(1, 2);
        list1.insert(1, 2);
        list1.insert(0, 0);
        list1.insert(0, 0);
        list1.insert(5, 4);
        // list1.display();

        LL list2 = new LL();
        list2.insert(1, 2);
        list2.insert(1, 3);
        list2.insert(0, 1);
        list2.insert(3, 5);
        list2.insert(0, 0);
        // list2.display();

        LL merged = merge(list1, list2);

        // merged.display();

        merged.reverseLL(merged.head);

        // merged.display();

        LL list3 = new LL();

        for (int i = 1; i < 6; i++) {
            list3.insert(list3.size, i);
        }

        // list3.display();

        ListNode head = list3.reverseInBetn(list3.head, 1, 4);

        // list3.display(head);

        LL list4 = new LL();
        list4.insert(list4.size, 1);
        list4.insert(list4.size, 2);
        list4.insert(list4.size, 3);
        list4.insert(list4.size, 4);
        list4.insert(list4.size, 5);
        list4.insert(list4.size, 6);
        list4.insert(list4.size, 7);
        list4.insert(list4.size, 8);
        list4.insert(list4.size, 9);
        list4.insert(list4.size, 10);
        list4.insert(list4.size, 11);
        list4.insert(list4.size, 12);

        // boolean palin = list4.isPalindrome(list4.head);
        // System.out.println(palin);

        // ListNode hNode = list4.reorderList(list4.head);
        // list4.display(hNode);

        // list4.display();
        // ListNode hNode1 = list4.reverseKGroup(list4.head, 4);
        // list4.display(hNode);

        // ListNode hNode = list4.reverseKGroupAlt(list4.head, 3);
        // list4.display(hNode);

        LL list5 = new LL();
        list5.insert(list5.size, 1);
        list5.insert(list5.size, 2);
        list5.insert(list5.size, 3);
        list5.insert(list5.size, 4);
        list5.insert(list5.size, 5);

        list5.display();
        ListNode hNode = list5.rotateRight(list5.head, 13);
        list5.display(hNode);

    }

}
