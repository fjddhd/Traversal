package com.duoduo.isgood.traversal.Sorts;

import java.util.ArrayList;
import java.util.Arrays;

public class ExamOfSort {

    public static void main(String[] args){
        long start,end;
//        Integer[] test;
//        ArrayList<Integer> al=new ArrayList<>();
//        al.add(0);//堆排序专用：不使用下标为0的元素
//        for (int i=0;i<1000001;++i){
//            al.add((int) (Math.random()*100000000));
//        }
//        test=al.toArray(new Integer[al.size()]);
//        start = System.currentTimeMillis();
//
//        Heap.sort(test);
//
//        end = System.currentTimeMillis();
//        System.out.println(end-start);
//        System.out.println(isSorted(test));
        //show(test);

        showQuickEveryTerm();//快排每轮结果
//        showHeap();//构造堆结果
    }

    public static void sort(Comparable[] a){

    }

    public static boolean less(Comparable v,Comparable w){//仅v<w返回true
        return v.compareTo(w)<0;
    }
    public static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];a[i]=a[j];a[j]=t;
    }

    private static void show(Comparable[] a){//单行打印数组中各元素
        for (int i=0;i<a.length;i++)
            System.out.println(a[i]);//此处并没有使用原书的Std系列api
    }
    public static boolean isSorted(Comparable[] a){
        for (int i=1;i<a.length;++i){
            if (less(a[i],a[i-1]))
                return false;
        }
        return true;
    }



    /**
     * 测试快排单趟结果
     * */
    public static void showQuickEveryTerm(){
        Integer[] a={49,38,65,97,76,13,27,56};
        Quick.sort(a);
        System.out.println(isSorted(a));
    }
    /**
     * 测试构造堆
     * */
    public static void showHeap(){
        Integer[] a={0,86,92,70,33,65,24,56,48,81,38};
        Heap.sort(a);
        show(a);
    }
}
