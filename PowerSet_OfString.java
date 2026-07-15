import java.util.*;
public class PowerSet_OfString{


public static List<String> powerSet(String s){
int index=0;
List<String >  ans=new ArrayList<>();
StringBuilder output=new  StringBuilder();
getAllSubsequences(s,index,output,ans);
Collections.sort(ans); //as the question demands it wants an answer in lexicography order
return ans;
}

public static void getAllSubsequences(String s,int index,StringBuilder output,List<String> ans){

// base  case
if(index==s.length()){
ans.add(output.toString());
return;
}  

//recursive call for include-exclude pattern

//for include
output.append(s.charAt(index));
getAllSubsequences(s,index+1,output,ans);

//for exclude
output.deleteCharAt(output.length()-1);
getAllSubsequences(s,index+1,output,ans);

}

public static void main(String [] args){
System.out.println(powerSet("abc"));

System.out.println(powerSet("xyz"));




}



}
