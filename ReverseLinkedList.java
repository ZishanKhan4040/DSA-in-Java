//by 2 pointer technique
public class ReverseLinkedList{

public static ListNode reverseList(ListNode head){

ListNode currrent=head;
ListNode previous=null;

while(current!=null){
ListNode next=current.next;
current.next=previous;
previous=current;
current=next;
}
return previous;


}



public static void main(String [] args){




}



}
