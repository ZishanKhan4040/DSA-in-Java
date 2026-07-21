//1108   Defanging means making something harmless or safe 
public class DefangingAnIPAddress{

public static String defangIP(String  address){

StringBuilder sb=new StringBuilder();
for(int i=0;i<address.length();i++){
if(address.charAt(i)=='.') sb.append("[.]");
else sb.append(address.charAt(i));
}
return sb.toString();
}


public static void main(String [] args){
System.out.println(defangIP("1.1.1.1"));
System.out.println(defangIP("255.100.50.0"));

}


}
