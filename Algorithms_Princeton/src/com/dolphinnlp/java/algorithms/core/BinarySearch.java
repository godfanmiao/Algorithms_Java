package com.dolphinnlp.java.algorithms.core;

import java.io.File;
import java.util.Arrays;

import com.dolphinnlp.java.algorithms.utils.In;
import com.dolphinnlp.java.algorithms.utils.StdOut;
import com.sun.corba.se.spi.orb.StringPair;

import sun.util.logging.resources.logging;

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
			{
				hi = mid - 1;
			}
			else if (key > a[mid])
			{
				lo = mid + 1;
			}
			else {
				return mid;
			}
		}
		
		return -1;
	}
	
	/**
	 * Find the terms that do not appear in the whitelist.
	 * @param args [example: dataset\\tinyW.txt dataset\\tinyT.txt]
	 * @throws Exception
	 */
	public static void main(String[] args)
	{
		int[] whitelist = In.readInts(args[0]);
		
		Arrays.sort(whitelist);
		
		In in = new In(new File(args[1]));
		
		while(!in.isEmpty())
		{
			int key = in.readInt();
			
			if(rank(key, whitelist) == -1)
				StdOut.println(key);
		}
	}
}
