package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

/* PECS:
 * producer extends, consumer super
 */
public class Stack<E> {
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	@SuppressWarnings("unchecked")
	public Stack() {
		elements = (E[])new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}
	
	public E pop() {
		if(size == 0)
			throw new EmptyStackException();
		E result = elements[--size];
		elements[size] = null;
		return result;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void pushAll(Iterable<? extends E> src) {
		for(E e : src)
			push(e);
	}
	
	public void popAll(Collection<? super E> dst) {
		while(!isEmpty()) {
			dst.add(pop());
		}
	}
	
	private void ensureCapacity() {
		if(elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Number> numStack = new Stack<Number>();
		Iterable<Integer> integers = Arrays.asList(new Integer[]{2,3,4,5});
		numStack.pushAll(integers);
		Collection<Object> objects = new ArrayList<>();
		numStack.popAll(objects);
	}

}
