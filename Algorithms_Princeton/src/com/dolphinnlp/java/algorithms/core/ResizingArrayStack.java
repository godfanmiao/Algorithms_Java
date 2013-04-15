package com.dolphinnlp.java.algorithms.core;

import java.io.File;
import java.util.*;

import com.dolphinnlp.java.algorithms.utils.*;

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
		assert capacity >= N;
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
		else {
			a[N ++] = item;
		}
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
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>
	{
		private int i ;
		
		public ReverseArrayIterator()
		{
			i = N;
		}
		
		public boolean hasNext()
		{
			return i > 0;
		}
		
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
		
		public Item next()
		{
			if(!hasNext()) throw new NoSuchElementException();
			return a[--i];
			
		}
	}
	
	/**
	 * @param args
	 */
    public static void main(String[] args) {
    	
        ResizingArrayStack<String> s = new ResizingArrayStack<String>();
        In in = new In(new File(args[0]));
        
        while (!in.isEmpty()) {
            String item = in.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }



}
