package com.duoduo.isgood.traversal.Sorts;

public class MaxPQ<Key extends Comparable<Key>> {//基于堆的优先队列
    private Key[] pq;//基于堆的完全二叉树
    private int N=0;//存储于pq[1...N]中，pq[0]没有使用

    public MaxPQ(int maxN){
        pq= (Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void insert(Key v){//在堆底插入，然后向上调整到合适位置
        pq[++N]=v;
        swim(N);
    }
    public Key delMax(){
        Key max=pq[1];
        exch(1,N--);//总元素个数在交换之后要减去一位
        pq[N+1]=null;//原堆底元素置null
        sink(1);//把换上来的的元素由堆顶位置
        return max;
    }



    //以下为辅助方法
    public boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }

    public void exch(int i,int j){
        Key t=pq[i];
        pq[i]=pq[j];
        pq[j]=t;
    }

    private void swim(int k){//自下而上
        while (k>1 && less(k/2,k)){
            exch(k/2,k);
            k/=2;
        }
    }

    private void sink(int k){//自上而下
        while(2*k<=N){
            int j=2*k;
            if (j<N && less(j,j+1))//为了把更大的那个子节点换上去
                j++;
            if (!less(k,j))
                break;
            exch(j,k);
            k=j;
        }
    }
}
