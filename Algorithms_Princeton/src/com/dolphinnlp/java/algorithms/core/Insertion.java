package com.dolphinnlp.java.algorithms.core;

import java.util.Comparator;
import java.util.concurrent.Exchanger;

import com.dolphinnlp.java.algorithms.utils.In;
import com.dolphinnlp.java.algorithms.utils.StdOut;

import sun.tools.jar.resources.jar;

/**
 * Insertion.java	
 * Insertion sorting algorithm.
 * @author Miao Fan
 * @afflication Department of Computer Science and Technology in Tsinghua University
 * @email fanmiao.cslt.thu@gmail.com
*/

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
	
	public static int[] indexSort(Comparable[] a)
	{
		int N = a.length;
		int[] index = new int[N];
		
		for(int i = 0; i < N; i++)
		{
			index[i] = i;
		}
		
		for(int i = 0; i < N; i++)
		{
			for(int j = i; j > 0 && less(a[index[j]], a[index[j - 1]]); j--)
			{
				exch(index, j, j - 1);
			}
		}
		
		return index;
	}
	
	private static boolean less(Comparable v, Comparable w)
	{
		return (v.compareTo(w) < 0);
	}
	
	private static boolean less(Comparator c, Object v, Object w)
	{
		return (c.compare(v, w) < 0);
	}
	
	private static void exch(Object[] a, int i, int j)
	{
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	private static void exch(int[] a, int i, int j)
	{
		int swap = a[i];
	    a[i] = a[j];
	    a[j] = swap;
	}

	
	private static void show(Comparable[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			StdOut.println(a[i]);
		}
	}
	
	/**
	 * 
	 * @param args [dataset\\words3.txt]
	 */
	
	public static void main(String[] args)
	{
		String[] a = In.readStrings(args[0]);
		Insertion.sort(a);
		show(a);
	}
}
