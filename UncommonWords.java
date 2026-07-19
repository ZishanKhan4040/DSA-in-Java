//884
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
public class UncommonWords{

public static String [] uncommonWords(String s1,String s2){
HashMap<String,Integer> hm=new HashMap<>();
ArrayList<String> al=new ArrayList<>();

for(String words : s1.split(" ")) hm.put(words,hm.getOrDefault(words,0)+1);
for(String words : s2.split(" ")) hm.put(words,hm.getOrDefault(words,0)+1);

for(Map.Entry<String,Integer> entries : hm.entrySet()){
if(entries.getValue()==1) al.add(entries.getKey());
}

return al.toArray(new String[0]);

}
public static void main(String [] arjkhs){
System.out.println(Arrays.toString(uncommonWords("this apple is sweet","this apple is sour")));

System.out.println(Arrays.toString(uncommonWords("apple apple ","banana")));




}

}
