package ReversePolishNotation;

public interface Stack<E> {
	
	public String toString(Node<E> node);
	
	public boolean isEmpty();

	public Node<E> top();

	public Stack<E> push(E element);

	public Stack<E> pop();

}
