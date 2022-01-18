package basic.sort;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import utils.RandomUtils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * shell sort 希尔排序
 */
@Slf4j
public class ShellSort {

    public static void main(String[] args) {



        Integer[] arr = RandomUtils.randomArray(10);
        Stopwatch stopwatch = Stopwatch.createStarted();

        shellSort(arr, true); //选择排序
        stopwatch.stop();
        log.info("耗时:{}",stopwatch.toString());
    }


    //j = i; j >= gap && temp.compareTo(arr[j - gap]) < 0; j -= gap

    public static <T extends Comparable<? super T>> void shellSort(T[] arr, boolean debug){
        if(debug){
            log.info("原始数组:{} 数组大小:{}", arr, arr.length);
        }
        AtomicInteger count = new AtomicInteger(1);

        int j;
        for(int gap = arr.length/2; gap > 0; gap /= 2){
            for(int i = gap; i < arr.length; i++){
                T temp = arr[i];
                for(j = i; j >= gap && temp.compareTo(arr[j - gap]) < 0; j -= gap){
                    arr[j] = arr[j-gap];
                }
                arr[j] = temp;
            }

            if(debug){
                log.info("第{}次排序,数组:{}",  count.getAndAdd(1), arr);
            }
        }
    }


    /**
     * 希尔排序
     */
    public static <T extends Comparable<? super T>> void sort(T[] arr){
        T temp;
        for (int gap = arr.length/2; gap > 0; gap/=2){
            for(int i = gap; i< arr.length; i++){
                //遍历各组中所有的元素 步长gap
                for(int j = i - gap; j >= 0; j -= gap){
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if(arr[j].compareTo(arr[j+gap]) > 0){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
    }


}
