package basic.search;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * 使用二分查找的前提是数据是有序的
 */
public class BinarySearch {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 12, 300, 1000, 1000, 1000, 5379, 6324};
        System.out.println(find(arr, 7000));
        System.out.println(findMulti(arr, 1000));
    }


    public static <T extends Comparable<? super T>> int find(T[] arr, T val){
        return binarySearch(arr, 0, arr.length - 1, val);
    }

    public static <T extends Comparable<? super T>> ArrayList<Integer> findMulti(T[] arr, T val){
        return multiBinarySearch(arr, 0, arr.length - 1, val);
    }

    /**
     *
     * @param arr  数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param findVal 要查找的值
     * @param <T> 类型
     * @return 如果找到返回下标，没有找到返回 -1
     */
    public static <T extends Comparable<? super T>> int binarySearch(final T[] arr, int left, int right, T findVal){
        // 数组中不存在
        if(left > right){
            return -1;
        }

        int mid = (left + right) / 2;
        T midVal = arr[mid];
        int compared = findVal.compareTo(midVal);
        if (compared > 0) { // 向右递归
            return binarySearch(arr, mid + 1 , right, findVal);
        } else if (compared < 0){ // 向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        }else{
            return mid;
        }

    }

    /**
     * 如果数组中存在多个相同的值，则返回多个下标
     */
    public static <T extends Comparable<? super T>> ArrayList<Integer> multiBinarySearch(final T[] arr, int left, int right, T findVal){
        // 数组中不存在
        if(left > right){
            return  Lists.newArrayList(-1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        int mid = (left + right) / 2;
        T midVal = arr[mid];
        int compared = findVal.compareTo(midVal);
        if (compared > 0) { // 向右递归
            return multiBinarySearch(arr, mid + 1 , right, findVal);
        } else if (compared < 0){ // 向左递归
            return multiBinarySearch(arr, left, mid - 1, findVal);
        }else{
            list.add(mid);

            int index = mid - 1;
            while(index > 0 && (arr[index].compareTo(findVal)) == 0){
                list.add(index);
                index--;
            }

            index = mid + 1;
            while(index < arr.length - 1 && (arr[index].compareTo(findVal)) == 0){
                list.add(index);
                index++;
            }
            return list;
        }

    }
}
