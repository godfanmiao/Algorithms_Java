package com.dolphinnlp.java.algorithms.core;

import com.dolphinnlp.java.algorithms.utils.In;
import com.dolphinnlp.java.algorithms.utils.StdOut;

public class Shell {
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		
		int h = 1;
		while(h < N / 3)
		{
			h = 3 * h + 1;
		}
		while(h >= 1)
		{
			for(int i = h; i < N; i++)
			{
				for(int j = i; j >= h && less(a[j], a[j - h]); j -= h)
				{
					exch(a, j, j - h);
				}
			}
			
			h /= 3;
		}
	}
	
	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
		
	}
	
	private static void exch(Object[] a, int i, int j)
	{
		Object swap = a[j];
		a[j] = a[i];
		a[i] = swap;				
	}
	
	public static void show(Comparable[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			StdOut.println(a[i]);
		}
	}
	public static void main(String[] args)
	{
		String[] a = In.readStrings(args[0]);
		
		Shell.sort(a);
		show(a);
	}
}
