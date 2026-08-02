public class SumOfDecimalNumber{


public static int add(int x,int y){
StringBuilder sb=new StringBuilder();
int carry=0;
while(x>0 || y>0 || carry>0){
int sum=carry;

if(x>0){
sum+=x%10;
x/=10;
}

if(y>0){
sum+=y%10;
y/=10;
}

sb.append(sum%10);
carry=sum/10;


}

return Integer.parseInt(sb.reverse().toString());
}



public static void main(String [] rdfgh){
System.out.println(add(6752735,989));
System.out.println(add(999999,1));



}


}
