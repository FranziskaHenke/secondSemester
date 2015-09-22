package philosophers;

public class Fork {
	private boolean isTaken;
	public String name;
	
	public Fork(String name){
		isTaken = false;
		this.name = name;
	}
	
	synchronized public void setIsTaken(boolean taken){
		isTaken = taken;
	}
	
	public boolean getIsTaken(){
		return isTaken;
	}
}
