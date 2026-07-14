//680
public class ValidPalindrome_2{


public static boolean validPalindrome(String s){
int range=0;
if(s.length()%2==0) range=(s.length()/2)-1;
else range=s.length()/2;

int start=0,end=s.length()-1;
for(int i=0;i<range;i++){
if(s.charAt(start)!=s.charAt(end)) return false;
start++;
end--;
}
return true;
}

public static void main(String [] args){
System.out.println(validPalindrome("aba"));
System.out.println(validPalindrome("abca"));
System.out.println(validPalindrome("abc"));
//"deeee"

}


}
