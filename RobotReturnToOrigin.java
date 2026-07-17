//657

public class RobotReturnToOrigin{

public static boolean checkRobot(String moves){
// if  left & down then subtract -1
//if right & up then add +1
  //left & right are represented by x
  //up and dowm are represented by y
int x=0,y=0;
for(int i=0;i<moves.length();i++){
if(moves.charAt(i)=='L') x--;
else if(moves.charAt(i)=='D') y--;
else if(moves.charAt(i)=='R') x++;
else if(moves.charAt(i)=='U') y++;
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
