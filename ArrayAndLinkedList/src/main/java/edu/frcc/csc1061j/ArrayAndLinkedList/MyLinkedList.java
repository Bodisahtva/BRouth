package edu.frcc.csc1061j.ArrayAndLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements List <E>{

	private class Node {
		public E data;
		public Node next;
		
		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
	
	private Node head;
	private int size;
	
	public MyLinkedList() {
		head = null;
		size = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		if (indexOf(o) != -1) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		int i = 0;
		for (Node node = head; node != null; node = node.next) {
			array[i] = node.data;
			i++;
		}
		return array;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		Node newNode = new Node(e);
		if (head == null) {
			head = newNode;
		} else {
			Node node = null;
			for (node = head; node.next != null; node = node.next) {
			}
			node.next = newNode;
		}
		size++;
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove(int index) {
		E data = get(index);
		if (index == 0) {
			head = head.next;
		}
		else {
			Node node = getNode(index - 1);
			node.next = node.next.next;
		}
		size--;
		return data;
	}

	private Node getNode(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		Node node = head;
		for (int i = 0; i < size; i++) {
			if (o.equals(node.data)) {
				return i;
			}
			node = node.next;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
