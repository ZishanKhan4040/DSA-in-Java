//961
import java.util.*;
public class NRepeatedElement{


public static int repeatedNTimes(int [] nums){
HashMap<Integer,Integer> hm=new HashMap<>();
for(int x : nums){
hm.put(x,hm.getOrDefault(x,0)+1);
}
for(Map.Entry<Integer,Integer> entries : hm.entrySet()){
if(entries.getValue()==(nums.length/2)) return entries.getKey();
}

return -1;
}


public static void main(String [] args){
System.out.println(repeatedNTimes(new int []{1,2,3,3}));
System.out.println(repeatedNTimes(new int []{2,1,2,5,3,2}));
System.out.println(repeatedNTimes(new int []{5,1,5,2,5,3,5,4}));

}


}
