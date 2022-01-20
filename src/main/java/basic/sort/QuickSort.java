package basic.sort;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 快速排序 冒泡排序的升级版都是交换式排序
 */
@Slf4j
public class QuickSort {

    private static final AtomicInteger count = new AtomicInteger(1);

    public static void main(String[] args) {

        Integer[] arr = RandomUtils.randomArray(10);
        log.info("排序前数组:{}",(Object) arr);
        Stopwatch stopwatch = Stopwatch.createStarted();
        sort(arr,0, arr.length - 1);
        stopwatch.stop();
        log.info("排序后数组:{}",(Object) arr);
        log.info("耗时:{}",stopwatch.toString());
    }



    public static <T extends Comparable<? super T>> void quickSort(T[] arr, boolean debug){
        if(debug){
            log.info("原始数组:{} 数组大小:{}", arr, arr.length);
        }
        quickSort(arr, 0, arr.length - 1, debug);
    }

    public static <T extends Comparable<? super T>> void quickSort(T[] arr, int left, int right, boolean debug){

        int l = left;
        int r = right;

        // pivot 中轴值
        T pivot = arr[(left + right) / 2];

        T temp; //用来进行交换

        // while循环的目的是让比pivot值小放到左边
        // 比pivot值小放到左边
        while (l < r){
            //在 pivot的左边一直找，找到大于等于pivot值，才退出
            while(pivot.compareTo(arr[l]) > 0){
                l += 1;
            }

            //在pivot的右边一直找，找到小于等于pivot值，才退出
            while(pivot.compareTo(arr[r]) < 0){
                r -= 1;
            }

            // 如果 l >= r 说明 pivot的左右两的值，已经按照左边全部是
            // 小于等于pivot值，右边全部是大于等于pivot值
            if(l >= r){
                break;
            }

            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 如果交换完后，发现这个arr[l]== pivot值， 前移
            if(arr[l].compareTo(pivot) == 0){
                r -= 1;
            }

            // 如果交换完后，发现这个arr[r] == pivot值，后移
            if(arr[r].compareTo(pivot) == 0){
                l += 1;
            }
        }

        // 如果 l == r, 必须l++, r--,否则栈ni出
        if(l == r){
            l += 1;
            r -= 1;
        }

        if(debug){
            log.info("第{}次排序,数组:{}",  count.getAndAdd(1), arr);
        }

        //向左递归
        if(left < r){
            quickSort(arr, left, r, debug);
        }

        //向右递归
        if(right > l){
            quickSort(arr, l, right, debug);
        }

    }

    /**
     * 更好的实现
     */
    public static void sort(Integer[] arr,int low, int high){
        if (low >= high){
            return;
        }
        // i,j
        int i = low;
        int j = high;

        //key
        int key = arr[i];

        while (i < j){
            while (arr[j] > key && i<j){
                j --;
            }
            if (i < j){
                int t ;
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
            while (arr[i] <= key && i<j){
                i ++;
            }
            if (i < j){
                int t;
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        //对基准左侧的集合重复操作
        sort(arr,low,i-1);

        //对基准右侧的集合重复操作
        sort(arr,i+1,high);

    }

    /**
     *  书上实现的快速排序
     */
    public static void sort(List<Integer> items){
        if(items.size() > 1){
            List<Integer> smaller = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();

            Integer chosenItem = items.get(items.size() / 2);

            for (Integer i : items){
                if(i < chosenItem){
                    smaller.add(i);
                }
                else if (i > chosenItem){
                    larger.add(i);
                }
                else {
                    same.add(i);
                }
            }

            sort(smaller);
            sort(larger);

            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
        }
    }
}
