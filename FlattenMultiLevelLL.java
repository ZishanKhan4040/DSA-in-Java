import java.util.ArrayList;
class FlattenMultiLevelLL {
    public Node flatten(Node head) {
        Node temp=head;
ArrayList<Node> al=new ArrayList<>();

while(temp!=null){
if(temp.child!=null){
if (temp.next!=null) al.add(temp.next);
temp.next=temp.child;
temp.child=null;
temp.next.prev=temp;
}
temp=temp.next;
}
if(al.size()>0){
int index=al.size()-1;
temp=head;

while(temp!=null){
if(temp.next==null && index>=0){
temp.next=al.get(index--);
temp.next.prev=temp;
}
temp=temp.next;
}
}
return head;
    }
}
