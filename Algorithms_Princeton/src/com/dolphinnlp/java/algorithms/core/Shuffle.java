package com.dolphinnlp.java.algorithms.core;

import com.dolphinnlp.java.algorithms.utils.In;
import com.dolphinnlp.java.algorithms.utils.StdOut;
import com.dolphinnlp.java.algorithms.utils.StdRandom;

public class Shuffle {
	public static void shuffle(Object[] a)
	{
		int N = a.length;
		
		for(int i = 0; i < N; i++)
		{
			int j = StdRandom.uniform(0, i+1);
			
			exch(a, i, j);		
		}
	}
	
	public static void exch(Object[] a, int i, int j)
	{
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
		
	}
	
	public static void show(Object[] a)
	{
		int N = a.length;
		for(int i = 0; i < N; i++)
			StdOut.println(a[i]);
	}
	
	public static void main(String[] args)
	{
		String[] a = In.readStrings(args[0]);
		StdOut.println("********Before Shuffling********");
		show(a);
		shuffle(a);
		StdOut.println("********After Shuffling*********");
		show(a);
	}
}
