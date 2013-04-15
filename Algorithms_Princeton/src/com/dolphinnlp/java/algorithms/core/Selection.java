package com.dolphinnlp.java.algorithms.core;

import java.io.File;
import java.util.Comparator;
import com.dolphinnlp.java.algorithms.utils.In;
import com.dolphinnlp.java.algorithms.utils.StdOut;

/**
 * Selection.java	
 * Selection sorting algorithm.
 * @author Miao Fan
 * @afflication Department of Computer Science and Technology in Tsinghua University
 * @email fanmiao.cslt.thu@gmail.com
*/

public class Selection {
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		
		for(int i = 0; i < N; i++)
		{
			int min = i;
			
			for(int j = i + 1; j < N; j++)
			{
				if(less(a[j], a[min]))
					min = j;
			}
			
			exch(a, i, min);
		}
	}
	
	public static void sort(Object[] a, Comparator c)
	{
		int N = a.length;
		for(int i = 0; i < N; i++)
		{
			int min = i;
			for(int j = i + 1; j < N; j++)
			{
				if(less(c, a[j], a[min]))
					min = j;
			}
			exch(a, i, min);
		}
	}
	
	private static boolean less(Comparable v, Comparable w)
	{
		return (v.compareTo(w) < 0);
	}
	
	private static boolean less(Comparator c, Object v, Object w)
	{
		return (c.compare(v, w) < 0);
	}
	
	public static void exch(Object[] a, int i, int j)
	{
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	public static void show(Comparable[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			StdOut.println(a[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = In.readStrings(args[0]);
		
		Selection.sort(a);
		show(a);
		
	}

}
