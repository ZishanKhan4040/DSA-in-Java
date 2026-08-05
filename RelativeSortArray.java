//1122
import java.util.*;
public class RelativeSortArray{


public static int[] relativeSortArray(int [] arr1,int [] arr2){

HashMap<Integer,Integer> hm=new HashMap<>();
int n=arr1.length;
//store the elemennts of arr1 with their frequency 
for(int k=0;k<n;k++){
hm.put(arr1[k],hm.getOrDefault(arr1[k],0)+1);
}
//System.out.println(hm);
//store the lements of arr2
HashSet<Integer> hs=new HashSet<>();
for(int x : arr2) {
hs.add(x);
}
//store the remaining  elements of arr1
int m=arr1.length;
ArrayList<Integer> al=new ArrayList<>();
for(int j=0;j<m;j++){
if(!hs.contains(arr1[j]))
al.add(arr1[j]);
}
//System.out.println(al);

int i=0,arr2Index=0,freq=hm.get(arr2[0]);
for(i=0;i<arr1.length-al.size();i++){
if(freq>0){
arr1[i]=arr2[arr2Index];
freq--;
}
else{
freq=hm.get(arr2[++arr2Index]);
arr1[i]=arr2[arr2Index];
freq--;
}
}
Collections.sort(al);
for(int h=0;h<al.size();h++){
arr1[i]=al.get(h);
i++;
}
return arr1;
}


public static void main(String [] args){
System.out.println(Arrays.toString(relativeSortArray(new int []{2,3,1,3,2,4,6,7,9,2,19},new int []{2,1,4,3,9,6})));
//System.out.println((new int []{2,1,2,5,3,2}));
//System.out.println((new int []{5,1,5,2,5,3,5,4}));

}


}
