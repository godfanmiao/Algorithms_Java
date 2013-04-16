package com.dolphinnlp.java.algorithms.core;

import com.dolphinnlp.java.algorithms.utils.In;
import com.dolphinnlp.java.algorithms.utils.StdOut;
import com.dolphinnlp.java.algorithms.utils.StdRandom;

public class Quick {
	public static void sort(Comparable[] a)
	{
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi)
	{
		if(lo >= hi)
			return;
		
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}
	
	public static int partition(Comparable[] a, int lo, int hi)
	{
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		
		while(true)
		{		
			while(less(a[++i], v))
			{
				if(i == hi)
					break;
			}
			
			while(less(v, a[--j]))
			{
				if(j == lo)
					break;
			}
			if(i >= j)
				break;
			exch(a, i, j);
		}
		
		exch(a, lo, j);
		
		return j;
	}
	
	private static boolean less(Comparable a, Comparable b)
	{
		return a.compareTo(b) < 0;
	}
	
	private static void exch(Object[] a, int i, int j)
	{
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	public static void show(Comparable[] a)
	{
		int N = a.length;
		for(int i = 0; i < N; i++)
			StdOut.println(a[i]);
	}
	
	public static void main(String[] args)
	{
		String[] a = In.readStrings(args[0]);
		sort(a);
		show(a);
	}
}
