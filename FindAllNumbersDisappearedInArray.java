//448
import java.util.List;
import java.util.ArrayList;
public class  FindAllNumbersDisappearedInArray{

public static List<Integer> missingNumber(int [] nums){
List<Integer> list=new ArrayList<>();

for(int i=0;i<nums.length;i++){
int index=Math.abs(nums[i])-1;

//mark it as processed
if(nums[index]>0) //if not already processed then only enter inside & mark it ass processed
nums[index]=-nums[index];
}

for(int i=0;i<nums.length;i++){
if(nums[i]>0) list.add(i+1);
}

return list;
}

public static void main(String [] args){
System.out.println(missingNumber(new int[]{4,3,2,7,8,2,3,1}));
//System.out.println(missingNumber(new int[]{0,1}));
//System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));


}

}
