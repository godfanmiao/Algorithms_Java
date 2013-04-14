package com.dolphinnlp.java.algorithms.core;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.dolphinnlp.java.algorithms.utils.StdIn;
import com.dolphinnlp.java.algorithms.utils.StdOut;

public class Stack<Item> implements Iterable<Item> {
	
	private int N;//size of the stack
	private Node first;//top of stack
	
	private class Node //Inner class
	{
		private Item item;
		private Node next;
	}
	
	public Stack()
	{
		first = null;
		N = 0;
		assert check();
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
		assert check();
	}
	
	public Item pop()
	{
		if(isEmpty())
			throw new NoSuchElementException("Stack underflow");
		Item item = first.item;
		first = first.next;
		N--;
		assert check();
		return item;
	}
	
	public Item peek()
	{
		if(isEmpty())
			throw new NoSuchElementException("Stack underflow");
		return first.item;
	}
	
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		for(Item item : this)
			s.append(item + " ");
		return s.toString();
	}
	
	private boolean check()
	{
		if(N == 0)
		{
			if(first != null)
				return false;
		}
		else if(N == 1)
		{
			if(first == null)
				return false;
			if(first.next != null)
				return false;
		}
		else {
			if(first.next == null)
				return false;
		}
		
		int numberOfNodes = 0;
		for(Node x = first; x != null; x = x.next)
		{
			numberOfNodes ++;
		}
		
		if(numberOfNodes != N)
			return false;
		return true;
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
	
	public static void main(String[] args)
	{
		Stack<String> s = new Stack<String>();
		
		while(!StdIn.isEmpty())
		{
			String item = StdIn.readString();
			
			if(!item.equals("-"))
				s.push(item);
			else if(!s.isEmpty())
				StdOut.print(s.pop() + " ");
		}
		
		StdOut.println("(" + s.size() + " left on stack");
	}
	
	
}
