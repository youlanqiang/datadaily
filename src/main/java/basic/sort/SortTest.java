package basic.sort;

import lombok.extern.slf4j.Slf4j;
import utils.RandomUtils;

import java.util.Arrays;

/**
 * 实现SortTest来复习排序知识点
 */
@Slf4j
public abstract class SortTest {

    public static final int THRESHOLD = 10;

    // 冒泡排序
    protected abstract void bubbleSort(Integer[] arr);

    // 选择排序
    protected abstract void selectionSort(Integer[] arr);

    // 插入排序
    protected abstract void insertionSort(Integer[] arr);

    // 希尔排序
    protected abstract void shellSort(Integer[] arr);

    // 快速排序
    protected abstract void quickSort(Integer[] arr, int low, int high);

    // 归并排序
    protected abstract void mergeSort(Integer[] arr);


    public boolean isSort(Integer[] arr){
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i-1]){
                return false;
            }
        }
        return true;
    }

    public void test(){
        Integer[] originArr = RandomUtils.randomArray(THRESHOLD);
        log.info("原始数组:{} 数组大小:{}", originArr, originArr.length);

        Integer[] bubbleArr = Arrays.copyOf(originArr, THRESHOLD);
        bubbleSort(bubbleArr);
        log.info("冒泡排序 通过测试:{}, 排序后数组:{}  ", isSort(bubbleArr) ,bubbleArr);

        Integer[] selectionArr = Arrays.copyOf(originArr, THRESHOLD);
        selectionSort(selectionArr);
        log.info("选择排序 通过测试:{}, 排序后数组:{}", isSort(selectionArr), selectionArr);

        Integer[] insertionArr = Arrays.copyOf(originArr, THRESHOLD);
        insertionSort(insertionArr);
        log.info("插入排序 通过测试:{}, 排序后数组:{}", isSort(insertionArr), insertionArr);

        Integer[] shellArr = Arrays.copyOf(originArr, THRESHOLD);
        shellSort(shellArr);
        log.info("希尔排序 通过测试:{}, 排序后数组:{}", isSort(shellArr), shellArr);

        Integer[] quickArr = Arrays.copyOf(originArr, THRESHOLD);
        quickSort(quickArr,0, quickArr.length - 1);
        log.info("快速排序 通过测试:{}, 排序后数组:{}", isSort(quickArr), quickArr);

        Integer[] mergeArr = Arrays.copyOf(originArr, THRESHOLD);
        mergeSort(mergeArr);
        log.info("归并排序 通过测试:{}, 排序后数组:{}", isSort(mergeArr), mergeArr);
    }
}
