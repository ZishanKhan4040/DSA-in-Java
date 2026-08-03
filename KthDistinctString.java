//2053
import java.util.HashMap;
public class KthDistinctString{

public static String kthDistinct(String [] arr,int k){
int count=0;

HashMap<String,Integer> hm=new HashMap<>();
for(String s : arr){
hm.put(s,hm.getOrDefault(s,0)+1);
}

for(int i=0;i<arr.length;i++){
if(hm.get(arr[i])==1) count++;

if(count==k) return arr[i];
}


return "";
}


public static void main(String [] args){

System.out.println(kthDistinct(new String [] {"d","b","c","b","c","a"},2));
System.out.println(kthDistinct(new String [] {"aaa","aa","a"},1));
System.out.println(kthDistinct(new String [] {"a","b","a"},3));

}



}
