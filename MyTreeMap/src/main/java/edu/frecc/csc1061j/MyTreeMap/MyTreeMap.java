package edu.frecc.csc1061j.MyTreeMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyTreeMap<K, V> implements Map<K, V>, Iterable<V> {
	private Node root = null;
	private int size = 0;

	private class Node {
		private K key;
		private V value;
		private Node left = null;
		private Node right = null;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	@Override
	public Iterator<V> iterator() {
		return new InOrderIterator(root);
	}

	private class InOrderIterator implements Iterator<V> {
		private ArrayList<V> list = new ArrayList<>();
		private int currentIndex = 0;

		public InOrderIterator(Node root) {
			inOrder(root);
		}

		private void inOrder(Node node) {
			if (node == null) {
				return;
			}
			inOrder(node.left);
			list.add(node.value);
			inOrder(node.right);
		}

		@Override
		public boolean hasNext() {
			return currentIndex < list.size();
		}

		@Override
		public V next() {
			V value = list.get(currentIndex);
			currentIndex++;
			return value;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		Comparable<K> k = (Comparable<K>) key;
		Node current = root;

		while (current != null) {
			if (k.compareTo(current.key) < 0) {
				current = current.left; // compares the keys and places new key to the left if it is less than the
										// current node
			} else if (k.compareTo(current.key) > 0) {
				current = current.right; // compares the keys and places new key to the right if it is less than the
											// current node
			} else {
				return current.value;
			}
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		if (root == null) {
			Node newNode = new Node(key, value);
			root = newNode;
			size++;
			return value;
		}

		Node current = root;
		Node parent = null;
		Comparable<K> k = (Comparable<K>) key; // Casts the key as comparable to other keys

		while (current != null) {
			if (k.compareTo(current.key) < 0) {
				parent = current;
				current = current.left; // compares the keys and places new key to the left if it is less than the
										// current node
			} else if (k.compareTo(current.key) > 0) {
				parent = current;
				current = current.right; // compares the keys and places new key to the right if it is less than the
											// current node
			} else {
				return null;
			}
		}

		Node newNode = new Node(key, value);
		if (k.compareTo(parent.key) > 0) {
			parent.right = newNode;
		} else {
			parent.left = newNode;
		}
		size++;
		return value;
	}

	@Override
	public V remove(Object key) // first case should be if/has left and right children
								// parent.left/right = null -> DO NOT remove current node
	{
		Node current = root;
		Node parent = null;
		Comparable<K> k = (Comparable<K>) key;

		if (root == null) {
			return null;
		}
		while (current != null) 
		{
			if (k.compareTo(current.key) < 0)
			{
				parent = current; 
				current = current.left;
			}
			else if (k.compareTo(current.key) > 0)
			{
				parent = current; 
				current = current.right;
			}
			else
			{
				break;
			}
		}
		
		if (current == null)// if the key isnt found
		{
			return null;
		}
		
		if (current.right != null && current.left != null) // node has 2 children
		{
			Node oldest = current.left;
			Node oldestParent = current;
			
			while (oldest.right !=null)
			{
				oldestParent = oldest;
				oldest = oldest.right;
			}
			current.key = oldest.key;
			current.value = oldest.value;
			current = oldest;
			parent = oldestParent;
		}
		
		if (current.right != null || current.left != null) // node has 1 child
		{
			Node child = current.right != null ? current.right : current.left;
			if (parent == null)
			{
				root = child;
			}
			else if (parent.left == current)
			{
				parent.left = child;
			}
			else
			{
				parent.right = child;
			}
		}
		
		else // node has 0 children
		{
			if (parent == null)
			{
				root = null;
			}
			else if (parent.left == current)
			{
				parent.left = null;
			}
			else
			{
				parent.right = null;
			}
		}
		return current.value;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
}
