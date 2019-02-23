package com.duoduo.isgood.traversal.Sorts;

import java.util.ArrayList;
import java.util.Arrays;

public class ExamOfSort {



    public void sort(Comparable[] a){

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


}
