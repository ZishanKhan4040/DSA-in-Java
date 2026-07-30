//268
public class  MissingNumber{

public static int missingNumber(int [] nums){
int sum=0;
int  n=nums.length;

sum=(n*(n+1))/2;

for(int x : nums) sum-=x;



return sum;
}




public static void main(String [] args){
System.out.println(missingNumber(new int[]{3,0,1}));
System.out.println(missingNumber(new int[]{0,1}));
System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));


}

}
