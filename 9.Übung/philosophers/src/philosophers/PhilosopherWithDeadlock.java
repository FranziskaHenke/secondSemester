package philosophers;


public class PhilosopherWithDeadlock implements Runnable, Philosopher{
	private Thread t;
	private String name;
	private Fork leftFork;
	private Fork rightFork;
	public static boolean readyToStart;
	private boolean tookRightFork;
	private boolean tookLeftFork;
	
	public PhilosopherWithDeadlock(String name, Fork leftFork, Fork rightFork){
		this.name = name;
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}
	@Override
	public void run(){
		while(true){
			try{
				if(takeRightFork()){
					if(takeLeftFork()){
						System.out.println(name+ " eats" );
						rightFork.setIsTaken(false);
						System.out.println(name + " puts right fork down " + rightFork.name);
						tookRightFork=false;
						leftFork.setIsTaken(false);
						System.out.println(name + " puts left fork down " + leftFork.name );
						tookLeftFork = false;
					}
				}
				t.sleep(500);
			}catch(Exception e){
				//System.out.println("Interrupted!");
				e.printStackTrace();
			}
		}
	}
	@Override
	public void start(){
		t = new Thread(this, name);
		t.start();
	}
	@Override
	synchronized public boolean takeRightFork() throws InterruptedException{
		if((!rightFork.getIsTaken())&&(!tookRightFork)){
			rightFork.setIsTaken(true);
			System.out.println(name + " takes his right fork " + rightFork.name);
			tookRightFork=true;
			return true;
		}else if(tookRightFork){
			return true;
		}else{
			System.out.println(name + " waits for right fork " + rightFork.name);
			return false;		
		}
	}
	
	@Override
	synchronized public boolean takeLeftFork() throws InterruptedException{
		if((!leftFork.getIsTaken())&&(!tookLeftFork)){
			leftFork.setIsTaken(true);
			System.out.println(name + " takes his left fork " + leftFork.name);
			tookLeftFork = true;
			return true;
		}else if(tookLeftFork){
			return true;
		}else{
			System.out.println(name + " waits for left fork "+ leftFork.name);
			return false;
		}
		
	}
}
