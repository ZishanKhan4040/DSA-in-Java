import java.util.HashMap;
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        HashMap<Integer,ListNode> map=new HashMap<>();
        int sum=0;
        ListNode temp=dummy;

        while(temp!=null){
            sum+=temp.val;
            map.put(sum,temp);
            temp=temp.next;
            
        }

        sum=0;
        temp=dummy;

        while(temp!=null){
            sum+=temp.val;
            temp.next=map.get(sum).next;
            temp=temp.next;
        }
        return dummy.next;




        

    }
}
