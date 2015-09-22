package philosophers;

public class Dinner {
	public static void main(String args[]){
		Fork firstFork = new Fork();
		Fork secondFork = new Fork();
		Fork thirdFork = new Fork();
		Fork forthFork = new Fork();
		Fork fifthFork = new Fork();
		Philosopher first = new Philosopher("First Philosopher",firstFork, fifthFork);
		first.start();
		Philosopher second = new Philosopher("Second Philosopher", secondFork, firstFork);
		second.start();
		/*Philosopher third = new Philosopher("Third Philosopher", secondFork, thirdFork);
		third.start();
		Philosopher forth = new Philosopher("Forth Philosopher", thirdFork, forthFork);
		forth.start();
		Philosopher fifth = new Philosopher("Fifth Philosopher", forthFork, fifthFork);
		fifth.start();*/
	}
}
