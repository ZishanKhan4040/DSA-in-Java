//876

public class MiddleOfLinkedList{


public static SimplyLinkedList.Node middle(SimplyLinkedList.Node head){

SimplyLinkedList.Node fast=null;
SimplyLinkedList.Node slow=null;

SimplyLinkedList.Node temp=head;

while(fast!=null){
if(fast.next.next!=null)
fast=fast.next.next;

if(slow.next!=null)
slow=slow.next;

}
System.out.println(slow.data);
return slow;
}



public static void main(String [] args){

SimplyLinkedList list=new SimplyLinkedList();
list.add(10);
list.add(20);list.add(30);list.add(40);list.add(50);

middle(list.head);
}




}


class SimplyLinkedList{

 class Node{

int data;
Node next;

Node(int data){
this.data=data;
this.next=next;
}

} 

public Node head;
public Node tail;

public  void add(int data){
Node node=new Node(data);

if(head==null){
head=node;
tail=node;
return;
}
tail.next=node;
tail=node;
}

}
