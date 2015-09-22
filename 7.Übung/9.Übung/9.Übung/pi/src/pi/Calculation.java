package pi;

import java.util.Random;

public class Calculation {
	private static double pi;
	private static int size;
	private static int midpoint;
	private static Random random = new Random();
	private static double in;
	private static double out;
	
	public static void main(String args[]){
		//size = Integer.parseInt(args[0]);
		//computePi(Integer.parseInt(args[1]));
		size = 150000;
		computePi(1000000000);
		System.out.println(pi);
	}

	
	public static double computePi(int numberOfTimes){
		for(int i = 0;i<numberOfTimes;i++){
			Dot dot = createRandomDot();
			boolean inOut = dot.returnInOut();
			if(inOut==true){
				in++;
			}else{
				out++;
			}			
		}
		pi = (in/numberOfTimes)*4;
		return pi;
	}
	
	public static Dot createRandomDot(){
		int x = random.nextInt(size);
		int y = random.nextInt(size);
		boolean inOut = calculateIfInOrOut(x,y);
		Dot dot = new Dot(x,y,inOut);
		return dot;
	}
	
	public static boolean calculateIfInOrOut(int x, int y){
		midpoint = size/2;
		double distance = Math.sqrt(Math.pow(midpoint-x,2)+Math.pow(midpoint-y,2));
		if(distance<size/2){
			return true;
		}else{
			return false;
		}
	}
}
