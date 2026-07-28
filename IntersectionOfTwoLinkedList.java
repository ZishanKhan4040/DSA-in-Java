///160
public class IntersectionOfTwoLinkedList{


public ListNode getIntersection(ListNode headA,ListNode headB){
//equalize 
if(headA==null || headB==null) return  null;

ListNode ptr1=headA,ptr2=headB;


//traverse through the list until both pointers meet
while (ptr1 != ptr2){
ptr1=(ptr1 != null) ? ptr1.next : headB;
ptr2=(ptr2 != null) ? ptr2.next : headA;

}
return ptr1;


}



public static void main(String [] args){



}


}
