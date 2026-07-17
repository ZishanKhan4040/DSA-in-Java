//657

public class RobotReturnToOrigin{

public static boolean checkRobot(String moves){
// if  left & down then subtract -1
//if right & up then add +1
int count=0;
for(int i=0;i<moves.length();i++){
if(moves.charAt(i)=='L') count--;
else if(moves.charAt(i)=='D') count--;
else if(moves.charAt(i)=='R') count++;
else if(moves.charAt(i)=='U') count++;
}
if(count==0) return true;
return false;
}


public static void main(String [] args){

System.out.println(checkRobot("UD"));
System.out.println(checkRobot("UDLR"));
System.out.println(checkRobot("UDD"));
System.out.println(checkRobot("UU"));




}




}
