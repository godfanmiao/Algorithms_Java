package com.dolphinnlp.java.algorithms.core;

import java.io.File;
import com.dolphinnlp.java.algorithms.utils.In;
import com.dolphinnlp.java.algorithms.utils.StdOut;

/**
 * LinkedStackOfStrings.java	
 * A sample data structure of string stack that implemented by linked list.
 * @author Miao Fan
 * @afflication Department of Computer Science and Technology in Tsinghua University
 * @email fanmiao.cslt.thu@gmail.com
*/
public class LinkedStackOfStrings {
	private Node first = null;
	
	private class Node
	{
		String item;
		Node next;
	}
	
	public boolean isEmpty()
	{
		return first == null;
	}
	
	public String pop()
	{
		String item = null;
		if(!isEmpty())
		{
			item = first.item;
			first = first.next;
		}
		return item;
	}
	
	public void push(String item)
	{
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;		
	}
	
	/**
	 * 
	 * @param args [example: dataset\\tobe.txt]
	 * @throws Exception
	 */
	
	public static void main(String[] args)
	{
		In in = new In(new File(args[0]));
		LinkedStackOfStrings lstack = new LinkedStackOfStrings();
		
		while(!in.isEmpty())
		{
			String item = in.readString();
			if(item.equals("-"))
				StdOut.print(lstack.pop() + " ");
			else {
				lstack.push(item);
			}
		}
	}

}
