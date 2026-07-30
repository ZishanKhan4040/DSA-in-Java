//49
import java.util.*;
public     class  GroupAnagrams{

static public List<List<String>> groupAnagram(String[] strs){

HashMap<String,List<String>> hm=new HashMap<>();

for(String s : strs){
char[] arr=s.toCharArray();
Arrays.sort(arr); 
String key=new String(arr);

if(hm.containsKey(key)){
hm.get(key).add(s);
}
else {
List<String> list=new ArrayList<>();
list.add(s);
hm.put(key,list);
}
} 
return  new ArrayList<>(hm.values()); 
}


public static void main(String [] args){
System.out.println(groupAnagram(new String[]{"eat","tea","tan","ate","nat","bat"}));

}


}
