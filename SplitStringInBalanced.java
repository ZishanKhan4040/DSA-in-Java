//1221
public class SplitStringInBalanced{


public static int splitString(String s){
int ans=0,count=0;
for(int i=0;i<s.length();i++){
if(s.charAt(i)=='R') count++;
else count--;

if(count==0) ans++;
}
return ans;
}


public static void main(String [] args){
System.out.println(splitString("RLRRLLRLRL"));
System.out.println(splitString("RLRRRLLRLL"));
System.out.println(splitString("LLLLRRRR"));


}


}
