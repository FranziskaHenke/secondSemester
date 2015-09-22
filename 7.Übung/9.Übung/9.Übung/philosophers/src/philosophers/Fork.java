package philosophers;

public class Fork {
	private boolean isTaken;
	
	public Fork(){
		isTaken = false;
	}
	
	synchronized public void setIsTaken(boolean taken){
		isTaken = taken;
	}
	
	public boolean getIsTaken(){
		return isTaken;
	}
}
