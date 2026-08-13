import java.math.BigInteger;
class DoubleNumberInLL{
    public ListNode doubleIt(ListNode head) {
        StringBuilder sb=new StringBuilder();
ListNode temp=head;

while(temp!=null){
sb.append(temp.val);
temp=temp.next;
}
BigInteger x=new BigInteger(sb.toString());
x=x.multiply(BigInteger.valueOf(2));
String result=new String(""+x);
if(sb.length()==result.length()){
 temp=head;
int i=0;
while(temp!=null){
temp.val=result.charAt(i++)-'0';
temp=temp.next;
}
return head;
}
else{
ListNode extra=new ListNode(result.charAt(0)-'0');
extra.next=head;
 temp=head;
int i=1;
while(temp!=null){
temp.val=result.charAt(i++)-'0';
temp=temp.next;
}
return extra;
}
    }
}
