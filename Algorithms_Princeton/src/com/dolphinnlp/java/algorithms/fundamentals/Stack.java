package com.dolphinnlp.java.algorithms.fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;

public class Stack<Item> implements Iterable<Item>{
	private int N;
	private Node first;
	
	private class Node
	{
		private Item item;
		private Node next;
	}
	
	public Stack()
	{
		first = null;
		N = 0;
	}
	
	public boolean isEmpty()
	{
		return first == null;
	}
	
	public int size()
	{
		return N;
	}
	
	public void push(Item item)
	{
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;	
	}
	
	public Item pop()
	{
		if(isEmpty())
			throw new NoSuchElementException("Stack underflow");
		
		Item item = first.item;
		first = first.next;
		N --;
		
		return item;
	}
	
	public Item peek()
	{
		if(isEmpty())
			throw new NoSuchElementException("Stack underflow");
		return first.item;
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
