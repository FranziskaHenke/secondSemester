package philosophers;

import java.io.IOException;

public interface Philosopher{	
	
	public void run();
	
	public void start();
	
	public boolean takeRightFork() throws InterruptedException;	
	
	public boolean takeLeftFork() throws InterruptedException;
}
