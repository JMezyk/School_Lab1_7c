import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void mergeSort(int[] Array)
    {
        // if array consists of only one element, it doen't need sorting
        if (Array.length <= 1)
            return;

        // split array in half
        int L = Array.length;
        int M = L/2;
        int[] B;
        int[] C;
        B = Arrays.copyOfRange(Array, 0, M);
        C = Arrays.copyOfRange(Array, M, L);

        // sort each half separately - recurrent call
        mergeSort(B);
        mergeSort(C);

        // merge sorted arrays
        merge(Array,B,C);
    }

    public static void merge(int[] A, int[] B, int[] C)
    {
        int i = 0, j = 0, k = 0;
        // copy elements from B and C, one-by-one, smaller value first
        while( i < B.length && j < C.length)
        {
            if(B[i] < C[j])
                A[k++] = B[i++];
            else
                A[k++] = C[j++];
        }

        // if there's anything left, copy as is (C is already empty)
        while(i < B.length)
        {
            A[k++] = B[i++];
        }

        // if there's anything left, copy as is (B is already empty)
        while(j < C.length){
            A[k++] = C[j++];
        }
    }

    public static void main(String[] args)
    {
        int[] tab = new int[20];        // empty tab
        Random rand = new Random();     // fill with random numbers
        for (int i = 0; i < tab.length; i++)
        {
            tab[i] = rand.nextInt(99);
        }
        System.out.println("Original Table:\n" + Arrays.toString(tab)); // print not sorted table
        mergeSort(tab);
        System.out.println("Sorted Table:\n" + Arrays.toString(tab)); // print sorted table
    }
}