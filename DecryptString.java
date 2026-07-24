//1309

public class DecryptString{


public static String  freqAlphabets(String s){

///char[] arr = "abcdefghijklmnopqrstuvwxyz".toCharArray();  quickest way to create

char [] arr={
   ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
    'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
};

StringBuilder sb=new StringBuilder();
for(int i=0;i<s.length();i++){
if(i+2<s.length() && s.charAt(i+2)=='#'){
sb.append(arr[Integer.parseInt(s.substring(i,i+2))]);
i+=2;
}
else{
sb.append(arr[Integer.parseInt(s.substring(i,i+1))]);
}

}
return sb.toString();
}


public static void main(String [] args){

System.out.println(freqAlphabets("10#11#12"));
System.out.println(freqAlphabets("1326#"));

}

}
