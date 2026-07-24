//1374

public class GenerateString{

public static String  generateString(int n){

if(n<=0) return "";

StringBuilder sb=new StringBuilder();
for(int i=0;i<n;i++){
sb.append('a');
}
if(n%2!=0) return sb.toString();
return sb.deleteCharAt(sb.length()-1).append('b').toString();


}


public static void main(String [] args){
System.out.println(generateString(5));
System.out.println(generateString(4));
System.out.println(generateString(2));
System.out.println(generateString(1));
System.out.println(generateString(0));


}

}
