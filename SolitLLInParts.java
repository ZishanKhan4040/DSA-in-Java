/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
       int n=0;
ListNode temp=head;
while(temp!=null){
temp=temp.next;
n++;
} 

if(n/k < 0 ) return new ListNode[]{head};
ListNode [] arr=new ListNode[k];
int index=0;
int baseSize=n/k;
int extraSize=n%k;
temp=head;
while(temp!=null){
arr[index++]=temp;

int size=baseSize;
if(extraSize>0){
size+=1;
extraSize--;
}

for(int i=1;i<size && temp!=null ;i++){
temp=temp.next;
}
ListNode saveNextNode=temp.next;
temp.next=null;
temp=saveNextNode;
}
return arr;
    }
}
