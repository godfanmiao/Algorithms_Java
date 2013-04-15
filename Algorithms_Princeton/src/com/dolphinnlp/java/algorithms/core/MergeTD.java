package com.dolphinnlp.java.algorithms.core;

import com.dolphinnlp.java.algorithms.utils.In;
import com.dolphinnlp.java.algorithms.utils.StdOut;

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
		}//Copy this segment of array into aux
		
		int i = lo, j = mid + 1;//Two pointers to head of the subArrays
		
		for(int k = lo; k <= hi; k++)
		{
			if(i > mid)
				a[k] = aux[j++];
			else if(j > hi)
				a[k] = aux[i++];
			else if(less(aux[j], aux[i]))
				a[k] = aux[j++];
			else {
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
	
	public static void sort(Comparable[] a)
	{
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}
	
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
        
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
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
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = In.readStrings(args[0]);
		MergeTD.sort(a);
		show(a);
	}

}
