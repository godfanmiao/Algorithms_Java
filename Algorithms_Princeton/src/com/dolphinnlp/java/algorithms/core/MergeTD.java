package com.dolphinnlp.java.algorithms.core;

public class MergeTD {
	//Divide and Conquer
	public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
	{
		for(int k = lo; k <= hi; k++)
		{
			aux[k] = a[k];
		}
		
		int i = lo, j = mid + 1;
		
		for(int k = lo; k <= hi; k++)
		{
			if(i > mid)
				a[k] = aux[j++];
			else if(j > hi)
				a[k] = aux[i++];
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
