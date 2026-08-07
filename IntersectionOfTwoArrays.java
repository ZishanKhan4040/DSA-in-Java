//350
import java.util.*;
public class IntersectionOfTwoArrays{


public static int [] intersect(int [] nums1,int [] nums2){
 ArrayList<Integer> al=new ArrayList<>();
HashMap<Integer,Integer> hm=new HashMap<>();

for(int i=0;i<nums1.length;i++){
hm.put(nums1[i],hm.getOrDefault(nums1[i],0)+1);
}
for(int x : nums2){
if(hm.containsKey(x) && hm.get(x)>0){
al.add(x);
hm.put(x,hm.get(x)-1);
}
}
int [] result=new int[al.size()];
int index=0;
for(int x : al){
result[index++]=x;
}

return result;
}


public static void main(String [] args){
System.out.println(Arrays.toString(intersect(new int [] {1,2,2,1},new int [] {2,2})));
System.out.println(Arrays.toString(intersect(new int [] {4,9,5},new int [] {9,4,9,8,4})));



}


}
