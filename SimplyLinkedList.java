public SimplyLinkedList detectCycle(SimplyLinkedList head){

SimplyLinkedList temp=head;
HashSet<SimplyLinkedList> set=new HashSet<>(); 
while(temp!=null){
if(set.contains(temp))  return temp;
set.add(temp);
temp=temp.next;
}

return null;
}
