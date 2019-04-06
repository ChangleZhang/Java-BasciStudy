package sort;

import java.util.Arrays;

public class variousSort {
    public static void main(String[] args)
    {
        int[] data = new int[]{1100,192,221,12,23,6};
        print(data);
//        radixSort(data, 10, 4);
//        mergeSort(data,0,data.length-1);
        quickSort(data,0,data.length-1);
        print(data);
    }

    private static void quickSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1)
            return;
        int i = head, j = tail, p = arr[(head + tail) / 2];
        while (i <= j)
        {
            while (arr[i] < p)
            {
                i++;
            }
            while (arr[j] > p)
            {
                j--;
            }
            if (i < j)
            {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            } else if (i==j) {
                i++;
            }
        }
        quickSort(arr,head, j);
        quickSort(arr, i, tail);
    }

    private static void mergeSort(int[] data,int start,int end)
    {
        if (end > start)
        {
            int mid = (start + end) /2;
            mergeSort(data,start,mid);
            mergeSort(data,mid+1,end);
            merge(data,start,mid,mid+1,end);
        }
    }

    private static void merge(int[] array, int s1, int e1, int s2, int e2)
    {
        int i = s1;
        int j = s2;
        int[] tmp = new int[e2 - s1 + 1];
        int k = 0;
        while (i <= e1 && j <= e2)
        {
            if (array[i] < array[j])
            {
                tmp[k++]=array[i++];
            } else {
                tmp[k++]=array[j++];
            }
        }
        while (i <= e1)
        {
            tmp[k++] = array[i++];
        }
        while (j <= e2)
        {
            tmp[k++] = array[j++];
        }
        k = s1;
        for (int num:tmp)
        {
            array[k++] = num;
        }
    }

    private static void radixSort(int[] data, int radix, int d)
    {
        int[] tmp = new int[data.length];
        int[] bucket = new int[radix];
        for (int i=0,rate =1; i<d;i++)
        {
            Arrays.fill(bucket,0);
            System.arraycopy(data,0,tmp,0,data.length);
            for (int j=0; j< data.length;j++)
            {
                int subKey = (tmp[j] / rate) %radix;
                bucket[subKey]++;
            }
            for (int j=1;j<radix;j++)
            {
                bucket[j] = bucket[j] + bucket[j-1];
            }
            for (int m=data.length-1;m>=0;m--)
            {
                int subKey = (tmp[m]/rate)%radix;
                data[--bucket[subKey]] = tmp[m];
            }
            rate *=radix;
        }
    }

    private static void print(int[] data)
    {
        for (int i=0; i<data.length; i++)
        {
            System.out.print(data[i]+",");
        }
        System.out.print("\n");
    }
}
