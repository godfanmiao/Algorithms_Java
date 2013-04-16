package com.dolphinnlp.java.algorithms.core;

import com.dolphinnlp.java.algorithms.utils.In;
import com.dolphinnlp.java.algorithms.utils.StdOut;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Zephyr;

/**
 * MergeTD.java
 * Top-down merge sorting algorithm.
 * @author Miao Fan
 * @afflication Department of Computer Science and Technology in Tsinghua University
 * @email fanmiao.cslt.thu@gmail.com
*/

public class MergeTD {
	//Divide and Conquer
	
	public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
	{
		for(int k = lo; k <= hi; k++)
		{
			aux[k] = a[k];
		}
		
		int i = lo;
		int j = mid + 1;
		
		for(int k = lo; k <= hi; k++)
		{
			if(i > mid)
			{
				a[k] = aux[j++];
			}
			else if(j > hi)
			{
				a[k] = aux[i++];
			}
			else if(less(aux[j], aux[i]))
			{
				a[k] = aux[j++];
			}
			else 
			{
				a[k] = aux[i++];
			}
		}
		
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
	{
		if(hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}
	
	private static boolean less(Comparable a, Comparable b)
	{
		return a.compareTo(b) < 0;
	}
	
	public static void sort(Comparable[] a)
	{
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}
	
	private static void show(Comparable[] a)
	{
		int N = a.length;
		for(int i = 0; i < N; i++)
		{
			StdOut.println(a[i]);
		}
	}
	
	/**
	 * @param args [dataset\\words3.txt]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = In.readStrings(args[0]);
		MergeTD.sort(a);
		show(a);
	}

}
