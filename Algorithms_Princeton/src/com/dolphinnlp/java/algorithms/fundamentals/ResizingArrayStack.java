package com.dolphinnlp.java.algorithms.fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<Item> implements Iterable<Item> {
	
	private Item[] a;
	private int N;
	
	public ResizingArrayStack()
	{
		a = (Item[]) new Object[2];
	}
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	public int size()
	{
		return N;
	}
	
	private void resize(int capacity)
	{
		Item[] temp = (Item[]) new Object[capacity];
		
		for(int i = 0; i < N; i++)
		{
			temp[i] = a[i];
		}
		
		a = temp;
		
	}
	
	public void push(Item item)
	{
		if(N == a.length)
			resize(2 * a.length);
		a[N++] = item;
	}
	
	public Item pop()
	{
		if(isEmpty())
			throw new NoSuchElementException("Stack underflow");
		Item item = a[N - 1];
		a[N - 1] = null;
		N --;
		
		if(N > 0 && N == a.length / 4)
			resize(a.length / 2);
		
		return item;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>
	{
		private int i;
		
		public ReverseArrayIterator()
		{
			i = N;
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i > 0;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if(!hasNext())
				throw new NoSuchElementException();
			return a[--i];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
