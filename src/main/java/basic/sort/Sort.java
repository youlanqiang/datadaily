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
        Integer[] arr = {88, 71,45,422,32,22,734, 3};
        //insertionSort(arr); //插入排序
        Stopwatch stopwatch = Stopwatch.createStarted();
        bubbleSort(RandomUtils.randomArray(1000), false);  //冒泡排序
        stopwatch.stop();
        System.out.println(stopwatch.toString());
        

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

    /**
     * 冒泡排序
     */
    public static <T extends Comparable<? super T>>  void bubbleSort(T[] arr, boolean debug){
        if(debug){
            log.info("原始数组:{} 数组大小:{}", arr, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++ ){
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
}
