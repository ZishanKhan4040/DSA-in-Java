import java.util.*;
public class FindAllAnagrams{

public static List<Integer> findAnagrams(String s,String p){
List<Integer> list=new ArrayList<>();
int n=p.length();
char [] ch=p.toCharArray();
Arrays.sort(ch);
String sorted=new String(ch); 
char[]arr;
for(int i=0;i<s.length();i++){
if(i+n<=s.length()){
arr=s.substring(i,i+n).toCharArray();
Arrays.sort(arr);

if(sorted.equals(new String(arr))){
list.add(i);
}

}


}

return list;
}



public static void main(String [] args){
System.out.println(findAnagrams("cbaebabacd","abc"));
System.out.println(findAnagrams("abab","ab"));

}


}
