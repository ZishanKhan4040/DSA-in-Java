//599
import java.util.Arrays;
import java.util.ArrayList;
public class MinimumIndexSum{

public static String[] findRestaurant(String [] list1,String [] list2){
 ArrayList<String> list=new ArrayList<>();


int minSum=Integer.MAX_VALUE;
for(int i=0;i<list1.length;i++){
for(int j=0;j<list2.length;j++){
if(list1[i].equals(list2[j])){
int sum=i+j;
if(sum<minSum){
minSum=sum;
list.clear();
list.add(list1[i]);
}
else if(sum==minSum) list.add(list1[i]);
}
}
}
return list.toArray(new String[0]);
}

public static void main(String [] args){
System.out.println(Arrays.toString(findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"},new String[]{"KFC","Shogun","Burger King"})));

System.out.println(Arrays.toString(findRestaurant(new String[]{"happy","sad","good"},new String[]{"sad","happy","good"})));

System.out.println(Arrays.toString(findRestaurant(new String[]{"Shogun","Piatti","Tapioca Express","Burger King","KFC"},new String[]{"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"})));


//["Shogun","Piatti","Tapioca Express","Burger King","KFC"]
}



}
