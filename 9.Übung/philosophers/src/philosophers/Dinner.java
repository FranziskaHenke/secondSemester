package philosophers;

public class Dinner {
	public static void main(String args[]){
		Fork firstFork = new Fork("1");
		Fork secondFork = new Fork("2");
		Fork thirdFork = new Fork("3");
		Fork forthFork = new Fork("4");
		Fork fifthFork = new Fork("5");
		Philosopher first = new PhilosopherWithDeadlock("First Philosopher",firstFork, fifthFork);
		first.start();
		Philosopher second = new PhilosopherWithDeadlock("Second Philosopher", secondFork, firstFork);
		second.start();
		Philosopher third = new PhilosopherWithDeadlock("Third Philosopher", thirdFork, secondFork);
		third.start();
		Philosopher forth = new PhilosopherWithDeadlock("Forth Philosopher", forthFork, thirdFork);
		forth.start();
		Philosopher fifth = new PhilosopherWithDeadlock("Fifth Philosopher", fifthFork, forthFork);
		fifth.start();
		PhilosopherWithDeadlock.readyToStart = true;
	}
}
