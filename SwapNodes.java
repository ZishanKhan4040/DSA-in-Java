public ListNode swapNodes(ListNode head, int k) {

    ListNode temp = head;

    int n = 0;

    // First pass: find length
    while(temp != null) {
        n++;
        temp = temp.next;
    }

    int pos1 = k;
    int pos2 = n - k + 1;

    ListNode temp1 = null;
    ListNode temp2 = null;

    temp = head;
    int count = 0;

    // Second pass: find both nodes
    while(temp != null) {

        count++;

        if(count == pos1)
            temp1 = temp;

        if(count == pos2)
            temp2 = temp;

        temp = temp.next;
    }

    // Swap data
    int x = temp1.data;
    temp1.data = temp2.data;
    temp2.data = x;

    return head;
}
