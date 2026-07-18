//804
import java.util.HashSet;
public class UniqueMorseCodeWords{

public static int uniqueMorse(String [] words){
HashSet<String> hs=new HashSet<>();
String [] arr={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
for(int i=0;i<words.length;i++){
StringBuilder sb=new StringBuilder();
for(int j=0;j<words[i].length();j++){
sb.append(arr[words[i].charAt(j)-'a']);
}
hs.add(sb.toString());
}
//System.out.println(hs);
return hs.size();
}



public static void main(String [] args){
System.out.println(uniqueMorse(new String[]{"gin","zen","gig","msg"}));
System.out.println(uniqueMorse(new String[]{"a"}));


}


}
