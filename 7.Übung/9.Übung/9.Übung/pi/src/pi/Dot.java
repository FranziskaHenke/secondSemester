package pi;

public class Dot {
	private int xCoordinate;
    private int yCoordinate;
    private boolean isOutsideOfCircle;
	
	public Dot(int x, int y, boolean isOutsideOfCircle){
		xCoordinate = x;
		yCoordinate = y;
		this.isOutsideOfCircle = isOutsideOfCircle;
	}
	
	public boolean returnInOut(){
		return isOutsideOfCircle;
	}
}
