package com.dolphinnlp.java.algorithms.core;

import java.io.File;
import java.util.Scanner;

/**
 * WeightedQuickUnionUF.java	
 * Weighted Quick Union Algorithm for Union Find.
 * @author Miao Fan
 * @afflication Department of Computer Science and Technology in Tsinghua University
 * @email fanmiao.cslt.thu@gmail.com
*/

public class WeightedQuickUnionUF {
	private int[] id;
	private int[] sz;
	private int count;
	
	public WeightedQuickUnionUF(int N)
	{
		id = new int[N];
		sz = new int[N];
		count = N;
		
		for(int i = 0; i < N; i++)
		{
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	public int count()
	{
		return count;
	}
	
	//Find operation will be slow!
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
	
	//Union the small size to the large one!
	public void union(int p, int q){
		int pid = find(p);
		int qid = find(q);
		
		if(pid == qid)
			return;
		if(sz[pid] > sz[qid])
		{
			id[qid] = pid;
			sz[pid] += sz[qid];
		}
		else
		{
			id[pid] = qid;
			sz[qid] += sz[pid];
		}
		count --;
	}
	
	/**
	 * 
	 * @param args [example: data\\tinyUF.txt]
	 * @throws Exception
	 */
	
	public static void main(String[] args) throws Exception
	{
		if(args.length == 0)
		{
			System.err.println("Parameter args[0] must be the path of input file!");
			return;
		}
		
		Scanner scanner = new Scanner(new File(args[0]));
		
		int N = scanner.nextInt();
		WeightedQuickUnionUF wquuf = new WeightedQuickUnionUF(N);
		
		while(scanner.hasNext())
		{
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			
			if(wquuf.connected(p, q))
			{
				System.out.println(p + " and " + q + " has connected!");
				continue;
			}
			
			wquuf.union(p, q);
			System.out.println(p + " union " + q);		
		}
		System.out.println(wquuf.count() + " components");		
	}

}
