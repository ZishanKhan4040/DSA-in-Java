//725
class ListNode{
int val;
ListNode next;
ListNode(){
}
ListNode(int val){
this.val=val;
}
ListNode(int val,ListNode next){
this.val=val;
this.next=next;
}

}
public class SplitLinkedList{
public ListNode[] splitToParts(ListNode head, int k){
ListNode temp=head; int n=0;
while(temp!=null){
temp=temp.next;
n++;
}
int baseSize=n/k; 
int extra=n%k;
int index=0;
ListNode [] result=new ListNode[k];
ListNode previous=head;
temp=head;

int var=n;
if(n<k){
while(var>0){
result[index++]=temp;
previous=temp;
temp=temp.next;
previous.next=null;
var--;
}
return result;
}
int count=0;
for(int i=1;i<=n;i++){
count++;
if(count%baseSize==0 && extra>0){
result[index++]=previous;
previous=temp.next.next;
temp.next.next=null;
temp=previous;
extra--;
i++;
count=0;
continue;
}
else if(count%baseSize==0){
result[index++]=previous;
previous=temp.next;
temp.next=null;
temp=previous;
count=0;
continue;
}
temp=temp.next;
}

return result;
}




public static void main(String ... args){
ListNode node=new ListNode(10); 
node.next=new ListNode(20); 
node.next.next=new ListNode(30); 
node.next.next.next=new ListNode(40);
node.next.next.next.next=new ListNode(50); 
node.next.next.next.next.next=new ListNode(60); 
node.next.next.next.next.next.next=new ListNode(70);
ListNode[] arr=new SplitLinkedList().splitToParts(node,3);
for(ListNode x : arr){
  if (x!=null) System.out.println(x.val);
}
}

}
