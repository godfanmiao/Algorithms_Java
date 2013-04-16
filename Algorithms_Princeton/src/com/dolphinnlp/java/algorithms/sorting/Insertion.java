package com.dolphinnlp.java.algorithms.sorting;

import java.util.Comparator;

import com.dolphinnlp.java.algorithms.utils.StdOut;

public class Insertion {
	
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		for(int i = 0; i < N; i++)
		{
			for(int j = i; j > 0 && less(a[j], a[j - 1]); j--)
			{
				exch(a, j, j - 1);
			}
		}
	}
	
	public static void sort(Object[] a, Comparator c)
	{
		int N = a.length;
		
		for(int i = 0; i < N; i++)
		{
			for(int j = i; j > 0 && less(c, a[j], a[j - 1]); j--)
			{
				exch(a, j, j - 1);
			}
		}
	}
	
	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}
	
	private static boolean less(Comparator c, Object v, Object w)
	{
		return c.compare(v, w) < 0;
	}
	
	private static void exch(Object[] a, int i, int j)
	{
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	private static void show(Comparable[] a)
	{
		int N = a.length;
		
		for(int i = 0; i < N; i++)
		{
			StdOut.println(a[i]);
		}
	}

}
