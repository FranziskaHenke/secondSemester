package philosophers;

import java.io.IOException;

public class Philosopher implements Runnable{
	private Thread t;
	private String name;
	private Fork leftFork;
	private Fork rightFork;
	
	public Philosopher(String name, Fork leftFork, Fork rightFork){
		this.name = name;
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}
	
	public void run(){
		while(true){
			try{
				takeRightFork();
				takeLeftFork();
				System.out.println(name+ " eats");
				rightFork.setIsTaken(false);
				System.out.println(name + " puts right fork down");
				leftFork.setIsTaken(false);
				System.out.println(name + " puts left fork down");
				
			}catch(Exception e){
				//System.out.println("Interrupted!");
				e.printStackTrace();
			}
		}
	}
	
	public void start(){
		t = new Thread(this, name);
		t.start();
	}
	
	synchronized public void takeRightFork() throws InterruptedException{
		boolean tookFork= false;
		if(!rightFork.getIsTaken()){
			rightFork.setIsTaken(true);
			System.out.println(name + "takes his right fork");
		}else{
			System.out.println(name + "waits for right fork");
			
		
		}
	}
	
	
	synchronized public void takeLeftFork() throws InterruptedException{
		boolean tookFork= false;
		if(!leftFork.getIsTaken()){
			leftFork.setIsTaken(true);
			System.out.println(name + "takes his left fork");
		}else{
			System.out.println(name + "waits for left fork");
		}
		
	}
}
