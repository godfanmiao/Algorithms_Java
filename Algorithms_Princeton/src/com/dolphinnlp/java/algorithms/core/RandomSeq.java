package com.dolphinnlp.java.algorithms.core;

import com.dolphinnlp.java.algorithms.utils.StdOut;
import com.dolphinnlp.java.algorithms.utils.StdRandom;

/**
 * RandomSeq.java	
 * Print N numbers between lo and hi
 * @author Miao Fan
 * @afflication Department of Computer Science and Technology in Tsinghua University
 * @email fanmiao.cslt.thu@gmail.com
*/

public class RandomSeq {
	/**
	 * 
	 * @param args [example: 5 100.0 200.0]
	 */
	public static void main(String[] args)
	{
			
		if(args.length == 1)
		{
			int N = Integer.parseInt(args[0]);
			for(int i = 0; i < N; i++)
			{
				double x = StdRandom.uniform();
				StdOut.println(x);
				
			}
		}
		else if(args.length == 3)
		{
			int N = Integer.parseInt(args[0]);
			double lo = Double.parseDouble(args[1]);
			double hi = Double.parseDouble(args[2]);
			
			for(int i = 0; i < N; i++)
			{
				double x = StdRandom.uniform(lo, hi);
				StdOut.printf("%.2f\n", x);
			}
		}
		else {
			throw new IllegalArgumentException("Invalid number of arguments");
		}
	}
}
