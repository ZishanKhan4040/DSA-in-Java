//771
public class JewelsAndStones{


public static int jewelsStone(String jewels,String stones){
int count=0;
for(int i=0;i<stones.length();i++){
if(jewels.contains(stones.charAt(i)+"")) count++;
}
return count;
}

public static void main(String [] args){
System.out.println(jewelsStone("aA","aAAbbbb"));
System.out.println(jewelsStone("z","ZZ"));

}


}
