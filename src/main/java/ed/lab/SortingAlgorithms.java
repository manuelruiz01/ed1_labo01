package ed.lab;
import java.util.Random;

public class SortingAlgorithms {

    //highPivot
    public static <T extends Comparable<T>> void highPivotQuickSort(T[] arr) {
        highQuickSort(arr, 0, arr.length - 1);
    }
    private static <T extends Comparable <T>>  void highQuickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pivot = highPartition(arr, low, high);
            highQuickSort(arr,low,pivot-1);
            highQuickSort(arr,pivot+1,high);
        }
    }

    private static <T extends Comparable <T>> int highPartition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low-1;

        for(int j = low; j < high; j++) {
            if(arr[j].compareTo(pivot) <= 0) {
                i++;

                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        T temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    //Low Pivot

    public static <T extends Comparable <T>> void lowPivotQuickSort(T[] array){
        lowQuickSort(array,0,array.length-1);
    }

    private static <T extends Comparable <T>> void lowQuickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pivot = lowPartition(arr, low, high);
            lowQuickSort(arr,low,pivot-1);
            lowQuickSort(arr,pivot+1,high);

        }
    }

    private static <T extends Comparable <T>> int lowPartition(T[] arr, int low, int high) {
        T pivot = arr[low];
        int i = low+1;

        for(int j = low; j <= high; j++) {
            if(arr[j].compareTo(pivot) < 0) {


                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
            }
        }
        T temp = arr[low];
        arr[low] = arr[i-1];
        arr[i-1] = temp;
        return i-1;
    }

    //Random Pivot

    public static <T extends Comparable <T>> void randomPivotQuickSort(T[] arr) {
        randomQuickSort(arr,0,arr.length-1);

    }

    private static <T extends Comparable <T>>  void randomQuickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pivot = randomPartition(arr, low, high);
            randomQuickSort(arr,low,pivot-1);
            randomQuickSort(arr,pivot+1,high);
        }
    }

    private static <T extends Comparable <T>> int randomPartition(T[] arr, int low, int high) {
        Random random = new Random();
        int randomIndex = random.nextInt(high-low+1)+low;

        T temp = arr[randomIndex];
        arr[randomIndex] = arr[high];
        arr[high] = temp;

        return highPartition(arr,low,high);
    }




}
