package com.dolphinnlp.java.algorithms.fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;

public class Queue<Item> implements Iterable<Item> {
	
	private int N;
	private Node first;
	private Node last;
	
	private class Node
	{
		private Item item;
		private Node next;
	}
	
	public Queue()
	{
		first = null;
		last = null;
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
	
	public Item peek()
	{
		if(isEmpty())
			throw new NoSuchElementException("Queue underflow");
		return first.item;
	}
	
	public void enqueue(Item item)
	{
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty())
			first = last;
		else
			oldlast.next = last;
		N++;
	}
	
	public Item dequeue()
	{
		if(isEmpty())
			throw new NoSuchElementException("Queue underflow");
		Item item = first.item;
		first = first.next;
		
		N--;
		
		if(isEmpty())
		{
			last = null;
		}
		return item;
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
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
