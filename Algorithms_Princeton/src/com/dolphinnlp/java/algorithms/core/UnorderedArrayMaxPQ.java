package com.dolphinnlp.java.algorithms.core;

import com.dolphinnlp.java.algorithms.utils.In;
import com.dolphinnlp.java.algorithms.utils.StdOut;


public class UnorderedArrayMaxPQ<Key extends Comparable<Key>>{
	private Key[] mpq;
	private int N;
	
	public UnorderedArrayMaxPQ(int capacity)
	{
		N = 0;
		mpq = (Key[])new Comparable[capacity];
	}
	
	public int size()
	{
		return N;
	}
	
	public void insert(Key x)
	{
		mpq[N++] = x;
	}
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	public Key delMax()
	{
		int max = 0;
		for(int i = 1; i < N; i++)
		{
			if(less(max, i))
			{
				max = i;
			}
			
		}
		exch(max, N - 1);
		return mpq[--N];
	}
	
	
	private boolean less(int i, int j)
	{
		return mpq[i].compareTo(mpq[j]) < 0;
	}
	
	
	private void exch(int i, int j)
	{
		Key swap = mpq[i];
		mpq[i] = mpq[j];
		mpq[j] = swap;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = In.readStrings(args[0]);
		UnorderedArrayMaxPQ mpq = new UnorderedArrayMaxPQ(a.length);
		
		for(String string : a)
		{
			mpq.insert(string);
			//StdOut.println(string);
		}
		
		while(!mpq.isEmpty())
		{
			StdOut.println(mpq.delMax());
		}
	}

}
