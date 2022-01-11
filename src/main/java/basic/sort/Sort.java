package basic.sort;

import java.util.Arrays;

/**
 * 一些简单的排序算法
 */
public class Sort {

    public static void main(String[] args) {
        Integer[] arr = {1,45,422,32,22,734};
        //insertionSort(arr); //插入排序
        popSort(arr);  //冒泡排序
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     */
    public static <T extends Comparable<? super T>>  void insertionSort(T[] arr){
        int j;

        for (int p = 1; p < arr.length; p++){
            T tmp = arr[p];
            for (j = p; j > 0 && tmp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    /**
     * 冒泡排序
     */
    public static <T extends Comparable<? super T>>  void popSort(T[] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++){
                T temp = arr[j];
                if(temp.compareTo(arr[i]) > 0) {
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
