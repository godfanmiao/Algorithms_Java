package com.dolphinnlp.java.algorithms.core;

import java.io.File;

import com.dolphinnlp.java.algorithms.utils.In;
import com.dolphinnlp.java.algorithms.utils.StdOut;

public class FixedCapacityStackOfStrings {
	private String[] s;
	private int N = 0;
	
	public FixedCapacityStackOfStrings(int capacity)
	{
		s = new String[capacity];
	}
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	public void push(String item)
	{
		s[N ++] = item;
	}
	
	public String pop()
	{
		return s[--N];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FixedCapacityStackOfStrings fstack = new FixedCapacityStackOfStrings(100);
		In in = new In(new File(args[0]));
		
		
		while(!in.isEmpty())
		{
			String item = in.readString();
			if(item.equals("-"))
				StdOut.print(fstack.pop() + " ");
			else {
				fstack.push(item);
			}
		}
	}

}
