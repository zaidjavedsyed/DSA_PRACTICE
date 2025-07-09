class MyLinkedList {
    Node head;

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public MyLinkedList() {
        head = null;    
    }

    public int get(int index) {
        Node tem = head;
        int i = 0;
        while (tem != null) {
            if (i++ == index) {
                return tem.val;
            }
            tem = tem.next;
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node newnode = new Node(val);
        newnode.next = head;
        head = newnode;
    }

    public void addAtTail(int val) {
        Node newnode = new Node(val);
        if (head == null) {
            head = newnode;
            return;
        }
        Node tem = head;
        while (tem.next != null) {
            tem = tem.next;
        }
        tem.next = newnode;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node curr = head;
        int i = 0;
        while (curr != null) {
            if (i + 1 == index) {
                Node newnode = new Node(val);
                newnode.next = curr.next;
                curr.next = newnode;
                return;
            }
            i++;
            curr = curr.next;
        }
    }

    public void deleteAtIndex(int index) {
        if (index == 0 && head != null) {
            head = head.next;
            return;
        }
        int i = 0;
        Node curr = head;
        while (curr != null && curr.next != null) {
            if (i + 1 == index) {
                curr.next = curr.next.next;
                return;
            }
            i++;
            curr = curr.next;
        }
    }
}