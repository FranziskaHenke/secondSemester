package ReversePolishNotation;

public class LinkedListStack<E> implements Stack<E> {
	private Node<E> first;
	
	public LinkedListStack(){
		first = null;
	}

	@Override
	public String toString(Node<E> node) {
		return node.getData();

	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public Node<E> top() {		
		return first;
	}

	@Override
	public Stack<E> push(Object data) {
		Node<E> node = new Node<E>(data);
		Node<E> node2 = first;
		first = node;
		first.setNext(node2);
		return this;
	}

	@Override
	public Stack<E> pop(){
		first = first.getNext();	
		return this;
	}
}
