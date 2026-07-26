public class Palindrome{



public boolean isPalindrome(SimplyLinkedList.Node head){  //only head is given, tail is not

int mid=new SimplyLinkedList().length(head)/2;
int count=0; 
SimplyLinkedList.Node temp=head;
while(count<mid){
count++;
temp=temp.next;
}
//now temp is pointing mid node

//reverse the second half
SimplyLinkedList.Node previous=temp;
SimplyLinkedList.Node current=temp.next;
while(current!=null){
SimplyLinkedList.Node next=current.next;
current.next=previous;
previous=current;
current=next;
}
count=0; 
temp=head;
while(count<mid){
count++;
if(temp.data!=previous.data) return false;
temp=temp.next;
previous=previous.next;
}

return true;
}



public static void main(String [] args){
SimplyLinkedList list=new SimplyLinkedList();
list.add(1);list.add(2);list.add(3);list.add(3);list.add(2);list.add(1);list.add(3);
System.out.println(new Palindrome().isPalindrome(list.head));

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

 Node head;
Node tail;

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

int length(Node head){
Node temp=head;
int len=0;
while(temp!=null){
len++;
temp=temp.next;
}
return len;
}



}
