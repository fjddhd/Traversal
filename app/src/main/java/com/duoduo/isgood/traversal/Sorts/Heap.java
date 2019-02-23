package com.duoduo.isgood.traversal.Sorts;

public class Heap extends  ExamOfSort {//注意：数组下标0不使用

    /**
     * 大顶堆，输出非递减序列，无重复则递增
     * */
    //此处用了与优先队列不同的sink
    private static void sink(Comparable[] a,int k,int N){//下沉（自上而下调整），每N次下沉只需少于2N次比较和少于N次交换
        while(2*k<=N){
            int j=2*k;
            if (j<N)//为了把更大的那个子节点换上去
                if (less(a[j],a[j+1])) {
                    j++;
                }
            if (!less(a[k],a[j]))
                break;
            exch(a,j,k);
            k=j;
        }
    }

    public void sort(Comparable[] a){
        int N=a.length-1;//此处跟书中不一样，因为测试的时候在0号下标处加上了一个0
        for (int k=N/2;k>=1;k--){//构造堆,从N/2开始依次下沉
            sink(a,k,N);
        }

        System.out.println("构造后堆的序列");
        for (int i=0;i<a.length;++i){
            System.out.print(a[i]+" ");
        }

        //此时堆有序（每个节点大于等于其子节点，子节点间未必有序）
        while (N>1){//修复堆，把堆底元素换到堆顶一依次下沉
            exch(a,1,N--);//每次sink保证栈顶在剩余序列中最大，所以把它换到合适的位置
            sink(a,1,N);
        }
    }

    /**
     * 小顶堆，输出非递增序列，无重复则递减
     * */
    private static void sinkl(Comparable[] a,int k,int N){//下沉（自上而下调整），每N次下沉只需少于2N次比较和少于N次交换
        while(2*k<=N){
            int j=2*k;
            if (j<N)//为了把更大的那个子节点换上去
                if (less(a[j+1],a[j])) {
                    j++;
                }
            if (!less(a[j],a[k]))
                break;
            exch(a,j,k);
            k=j;
        }
    }

    public static void sortl(Comparable[] a){
        int N=a.length-1;//此处跟书中不一样，因为测试的时候在0号下标处加上了一个0
        for (int k=N/2;k>=1;k--){//构造堆,从N/2开始依次下沉
            sinkl(a,k,N);
        }

        System.out.println("构造后堆的序列");
        for (int i=0;i<a.length;++i){
            System.out.print(a[i]+" ");
        }

        //此时堆有序（每个节点大于等于其子节点，子节点间未必有序）
        while (N>1){//修复堆，把堆底元素换到堆顶一依次下沉
            exch(a,1,N--);//每次sinkl保证栈顶在剩余序列中最小，所以把它换到合适的位置
            sinkl(a,1,N);
        }
    }
}
