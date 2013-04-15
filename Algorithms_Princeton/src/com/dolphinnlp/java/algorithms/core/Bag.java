package com.dolphinnlp.java.algorithms.core;

import java.util.*;

import com.dolphinnlp.java.algorithms.utils.StdIn;
import com.dolphinnlp.java.algorithms.utils.StdOut;

public class Bag<Item> implements Iterable<Item> {
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
	
	public void add(Item item)
	{
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
		assert check();
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bag<String> bag = new Bag<String>();
		while(!StdIn.isEmpty())
		{
			String item = StdIn.readString();
			bag.add(item);
		}
		
		StdOut.println("size of bag = " + bag.size());
		for(String s: bag)
		{
			StdOut.println(s);
		}
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;
		
		public boolean hasNext()
		{
			return current != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if(!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
	}
	

}
