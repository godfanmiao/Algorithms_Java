package com.dolphinnlp.java.algorithms.fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;

public class Bag<Item> implements Iterable<Item>{
	private int N;
	private Node first;
	
	private class Node
	{
		private Item item;
		private Node next;
	}
	
	public Bag()
	{
		first = null;
		N = 0;
	}
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	public int size()
	{
		return N;
	}
	
	public void add(Item item)
	{
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if(!hasNext())
				throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
				
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	
}
