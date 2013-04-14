package com.dolphinnlp.java.algorithms.core;

import java.io.File;
import java.util.Scanner;
import com.dolphinnlp.java.algorithms.utils.*;

/**
 * QuickUnionUF.java	
 * Quick Union Algorithm for Union Find.
 * @author Miao Fan
 * @afflication Department of Computer Science and Technology in Tsinghua University
 * @email fanmiao.cslt.thu@gmail.com
*/

public class QuickUnionUF {
	private int[] id;
	private int count;
	
	public QuickUnionUF(int N)
	{
		id = new int[N];
		count = N;
		
		for(int i = 0; i < N; i++)
			id[i] = i;
	}
	
	int count()
	{
		return count;
	}
	
	public int find(int p)
	{
		while(p != id[p])
		{
			p = id[p];
		}
		return p;
	}
	
	public boolean connected(int p, int q)
	{
		return find(p) == find(q);
	}
	
	public void union(int p, int q)
	{
		int pid = find(p);
		int qid = find(q);
		
		if(pid == qid)
			return;
		id[pid] = qid;
		count --;
	}
	
	/**
	 * 
	 * @param args [example: dataset\\tinyUF.txt]
	 * @throws Exception
	 */
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		if(args.length == 0)
		{
			StdOut.println("Parameter args[0] must be the path of input file!");
			return;
		}

		In in = new In(new File(args[0]));
		
		int N = in.readInt();
		QuickUnionUF quuf = new QuickUnionUF(N);	
			
		while(!in.isEmpty())
		{
			int p = in.readInt();
			int q = in.readInt();
			
			if(quuf.connected(p, q))
			{
				StdOut.println(p + " and " + q + " has connected!");
				continue;
			}
			quuf.union(p, q);
			StdOut.println(p + " union " + q);
		}
		
		StdOut.println(quuf.count() + " components");
	}

}
