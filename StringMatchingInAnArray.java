//1408
import java.util.List;
import java.util.ArrayList;
public class StringMatchingInAnArray{
public static List<String> stringMatching(String [] words){
int count=0;
List<String> list=new ArrayList<>();
for(int i=0;i<words.length && count<words.length;i++){
//System.out.println(list);
if(i!=count && ! list.contains(words[count]) && words[i].contains(words[count])) list.add(words[count]);
if(i==words.length-1) { count++;i=-1;  }// bcz if we initialize it with zero then it will increment first  with 1
//System.out.println(i+"  "+count);
}
return list;
}
public static void main(String [] args){
System.out.println(stringMatching(new String[]{"mass","as","hero","superhero"}));
System.out.println(stringMatching(new String[]{"leetcode","et","code"}));

}




}
