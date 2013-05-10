package com.dolphinnlp.java.algorithms.sorting;


import com.dolphinnlp.java.algorithms.utils.In;
import com.dolphinnlp.java.algorithms.utils.StdOut;

public class Merge
{
	public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
	{
		for(int k = lo; k <= hi; k++)
			aux[k] = a[k];
		
		int i = lo, j = mid + 1;
		for(int k = lo; k <= hi; k++)
		{
			if(i > mid)
				a[k] = aux[j++];
			else if(j > hi)
				a[k] = aux[i++];
			else if(less(aux[j], aux[i]))
				a[k] = aux[j++];
			else 
				a[k] = aux[i++];
		}
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
	{
		if(lo >= hi)
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
	
	public static void show(Comparable[] a)
	{
		for(int i = 0; i < a.length; i++)
			StdOut.println(a[i]);
	}
	public static boolean less(Comparable v, Comparable w)	
	{
		return (v.compareTo(w) < 0);
	}
	
	public static void main(String[] args)
	{
		String[] a = In.readStrings("dataset\\tiny.txt");
		sort(a);
		show(a);
	}
}