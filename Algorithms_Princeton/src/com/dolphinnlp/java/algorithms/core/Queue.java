package com.dolphinnlp.java.algorithms.core;

import java.awt.Checkbox;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item>{
	private int N;
	private Node first;
	private Node last;
	
	private class Node
	{
		private Item item;
		private Node next;
	}
	
	public Queue<Item>()
	{
		first = null;
		last = null;
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
		N ++;
		assert check();
	}
	
	public Item dequeue()
	{
		if(isEmpty())
			throw new NoSuchElementException("Queue underflow");
		Item item = first.item;
		first = first.next;
		N--;
		if(isEmpty())
			last = null;
		assert check();
		return item;
	}
	
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		for(Item item : this)
		{
			s.append(item + " ");
		}
		return s.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}