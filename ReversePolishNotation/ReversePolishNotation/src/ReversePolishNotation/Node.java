package ReversePolishNotation;

public class Node<E>{
	private Node<E> next;
	private Object data;
	
	public Node(Object data){
		this.next = null;
		this.data = data;
	}
	
	public void add(Node<E> first){
		next = first;
	}
	
	public void delete(){
		this.data = null;
	}
	
	public String getData(){
		return  this.data.toString();
	}
	
	public void setNext(Node<E> nextNode){
		next = nextNode;
	}
	
	public Node<E> getNext(){
		return next;
	}
}
