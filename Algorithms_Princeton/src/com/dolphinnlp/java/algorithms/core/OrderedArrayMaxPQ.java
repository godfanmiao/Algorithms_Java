package com.dolphinnlp.java.algorithms.core;

public class OrderedArrayMaxPQ<Key extends Comparable<Key>>{
	
	private Key[] pq;
	private int N;
	
	public OrderedArrayMaxPQ(int capacity)
	{
		pq = (Key[]) (new Comparable[capacity]);
		N = 0;
	}
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	public int size()
	{
		return N;
	}
	
	public Key delMax()
	{
		return pq[--N];
	}
	
	public void insert(Key key)
	{
		int i = N - 1;
		while(i >= 0 && less(key, pq[i]))
		{
			pq[i + 1] = pq[i];
			i--;
		}
		
		pq[i + 1] = key;
		N++;
	}
	
	private boolean less(Comparable i, Comparable j)
	{
		return i.compareTo(j) < 0;
	}
	
	
	private void exch(int i, int j)
	{
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
