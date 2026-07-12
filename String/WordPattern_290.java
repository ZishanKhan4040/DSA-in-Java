//290
import java.util.HashMap;
public class WordPattern{

public static boolean wordPattern(String pattern,String s){
String [] arr=s.split(" ");
if(pattern.length()!=arr.length) return false;
HashMap<Character,String> hm=new HashMap<>();
for(int i=0;i<pattern.length();i++){
//System.out.println(hm);
  char ch=pattern.charAt(i);
if(! hm.containsKey(ch)){

  if(hm.containsValue(arr[i])) return false;
  
  hm.put(ch,arr[i]);
}

else if(! hm.get(ch).equals(arr[i])){ return false;}
}
return true;
}

public static void main(String [] args){
System.out.println(wordPattern("abba","dog cat cat dog"));
System.out.println(wordPattern("abba","dog cat cat fish"));
System.out.println(wordPattern("aaaa","dog cat cat dog"));
System.out.println(wordPattern("abba","dog dog dog dog"));
}


}
