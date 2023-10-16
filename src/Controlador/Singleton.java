package Controlador;

import Algorithms.Sorts.*;


public class Singleton {
    public static boolean pausa;

    public static int[] llenar(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - i - 1] = (int)Math.floor(Math.random() * (100 - 0 + 1) + 0);
        }
        return arr;
    }

    public static int[] SS(int arr[]){
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);
        return arr;
    }

    public static int[] BS(int arr[]){
        GFG.bubbleSort(arr, arr.length);
        return arr;
    }


    public static int[] IS(int arr[]){
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(arr);
        return arr;
    }

    public static int[] MS(int arr[]){
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr, 0, arr.length - 1);
        return arr;
    }

    public static int[] QS(int arr[]){
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr, 0, arr.length - 1);
        return arr;
    }

}
