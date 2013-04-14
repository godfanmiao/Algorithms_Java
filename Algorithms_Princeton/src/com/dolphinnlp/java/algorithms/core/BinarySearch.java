package com.dolphinnlp.java.algorithms.core;

import java.util.Arrays;

/**
 * BinarySearch.java
 * Binary search algorithm.
 * @author Miao Fan
 * @afflication Department of Computer Science and Technology in Tsinghua University
 * @email fanmiao.cslt.thu@gmail.com
*/

public class BinarySearch {
	
	public static int rank(int key, int[] a)
	{
		int lo = 0;
		int hi = a.length - 1;
		
		while(lo <= hi)
		{
			int mid = (lo + hi) / 2;
			if(key < a[mid])
				hi = mid - 1;
			else if (key > a[mid]){
				lo = mid + 1;
			}
			else {
				return a[mid];
			}
		}
		return 0;
	}
	
	public static void main(String[] args)
	{
		
	}
}
