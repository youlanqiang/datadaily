package basic.sort;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import utils.RandomUtils;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class MergeSort {

    private static final AtomicInteger count = new AtomicInteger(1);

    public static void main(String[] args) {

        Integer[] arr = RandomUtils.randomArray(10); // merge 次数为 N - 1
        log.info("原始数组:{}", (Object) arr);
        Stopwatch stopwatch = Stopwatch.createStarted();
        mergeSort(arr, 0, arr.length - 1, new Integer[10]);
        stopwatch.stop();
        log.info("排序后数组:{}",(Object) arr);
        log.info("耗时:{}",stopwatch.toString());
    }

    // 分 + 合
    public static <T extends Comparable<? super T>> void mergeSort(T[] arr, int left, int right, T[] temp){
        if(left < right){
            int mid = (left + right) / 2;//中间索引
            // 向左递归进行分解
            mergeSort(arr, left, mid, temp);

            // 向右递归进行分解
            mergeSort(arr, mid+1, right, temp);

            //合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并的方法
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 做中转的数组
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void merge(T[] arr, int left, int mid, int right, T[] temp){
        int i = left; // 初始化i，左边有序列表的初始索引
        int j = mid + 1; // 初始化j, 右边有序列表的初始索引
        int t = 0; //指向temp数组的当前索引

        // 一
        //先把左右两边（有序）的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while( i <= mid && j <= right){
            // 如果左边的有序序列的当前元素
            // 小于等于右边有序序列的当前元素
            // 即将左边的当前元素，拷贝到temp数组
            // 然后t++, i++
            if(arr[i].compareTo(arr[j]) <= 0){
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else { //反之 将右边有序序列的当前元素,填充到temp数组
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        // 二
        //把有剩余数据的一边的数据依次全部填充到temp
        while( i <= mid ){ // 左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while( j <= right){// 右边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        // 三
        //将temp数组的元素拷贝到arr
        //注意,并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        while(tempLeft <= right){
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }
}
