package algorithm;

public class Stack<T> {

	int size;
	int capacity;
	T[] elems;
	
	public Stack(int capacity){
		 this.capacity = capacity;
		 elems = (T[]) new Object[capacity];
	}
	
	public boolean isEmpty(){
		return this.size == 0;
	}
	
	public void push(T x){
		if(this.size == this.capacity){
			this.capacity *= 2;
			this.elems = (T[]) new Object[this.capacity];
		}
		this.elems[this.size++] = x;
	}
	
	public T pop(){
		if(this.size == 0) return null;
		return this.elems[this.size-- - 1];
	}
	
	public T top(){
		return this.elems[this.size-1];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
