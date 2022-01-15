package basic.sort;


import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import utils.RandomUtils;


/**
 * 一些简单的排序算法
 */
@Slf4j
public class Sort {

    public static void main(String[] args) {
        //insertionSort(arr); //插入排序
        Integer[] arr = RandomUtils.randomArray(7);
        Stopwatch stopwatch = Stopwatch.createStarted();
        //bubbleSort(arr, true);  //冒泡排序
        //insertionSort(arr, true);  // 插入排序
        selectionSort(arr, true); //选择排序
        stopwatch.stop();
        log.info("耗时:{}",stopwatch.toString());
        

    }

    /**
     * 简单选择排序
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] arr, boolean debug){
        if(debug){
            log.info("原始数组:{} 数组大小:{}", arr, arr.length);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            T min = arr[i];
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(min.compareTo(arr[j]) > 0){
                    min = arr[j];
                    minIndex = j;
                }
            }

            arr[minIndex] = arr[i];
            arr[i] = min;


            if(debug){
                log.info("第{}次排序,数组:{}", i+1, arr);
            }
        }
    }

    /**
     * 冒泡排序
     */
    public static <T extends Comparable<? super T>>  void bubbleSort(T[] arr, boolean debug){
        if(debug){
            log.info("原始数组:{} 数组大小:{}", arr, arr.length);
        }
        for (int i = 0; i < arr.length -1; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++ ){
                T temp = arr[j];
                if(temp.compareTo(arr[j+1]) > 0){
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(debug){
                log.info("第{}次排序,数组:{}",  arr.length - i, arr);
            }
        }
    }


    /**
     * 插入排序
     */
    public static <T extends Comparable<? super T>>  void insertionSort(T[] arr, boolean debug){
        if(debug){
            log.info("原始数组:{} 数组大小:{}", arr, arr.length);
        }

        int j;

        for (int p = 1; p < arr.length; p++){
            T tmp = arr[p];
            for (j = p; j > 0 && tmp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
            if(debug){
                log.info("第{}次排序,数组:{}",  p, arr);
            }
        }
    }
}
