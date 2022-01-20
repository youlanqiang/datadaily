package basic.sort;

import java.util.Arrays;

public class SortTestImpl extends SortTest{

    public static void main(String[] args) {
        SortTest sortTest = new SortTestImpl();
        Integer[] arr = {3, 4, 5, 1, 9, 9, 2, 6, 9, 4};
        sortTest.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public void bubbleSort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - i -1; j++){
                if(arr[j] > arr[j+1]){
                    Integer temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    @Override
    public void selectionSort(Integer[] arr) {
        for(int i = 0; i < arr.length - 1; i++){
            Integer min = arr[i];
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }

    }

    @Override
    public void insertionSort(Integer[] arr) {
        int j;
        for(int i = 1; i < arr.length; i++){
            Integer temp = arr[i];
            for(j = i; j > 0 && arr[j] < arr[j - 1]; j--){
                arr[j - 1] = arr[j];
            }
            arr[j] = temp;
        }

    }

    @Override
    public void shellSort(Integer[] arr) {
        int j;
        for(int gap = arr.length / 2; gap > 0; gap /=2){

            for(int i = gap; i < arr.length; i++){
                int temp = arr[i];
                for(j = i ; j >= gap && temp < arr[j-gap] ;j -= gap){
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;

            }

        }

    }

    @Override
    public void quickSort(Integer[] arr) {

    }
}
