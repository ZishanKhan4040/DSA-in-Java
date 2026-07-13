//389
public class FindTheDifference{

public static char findDifference(String s,String t){
char ch='\0';    //   ch='\0';  backward slash will come    or this too works ch=0;
int max=Math.max(s.length(),t.length());

for(int i=0;i<max;i++){

if(i<s.length()){
ch=(char)(ch^s.charAt(i));
}

if(i<t.length()){
ch=(char)(ch^t.charAt(i));
}

}


return (char)ch;
}


public static void main(String [] args){
System.out.println(findDifference("abcd","abcde"));
System.out.println(findDifference("","t"));
System.out.println(findDifference("abcd","dacbe"));
System.out.println(findDifference("aabb","abacb"));
System.out.println(findDifference("hello","olehlx"));

}



}
