package utils;


import java.util.Random;

public class RandomUtils {

    public static Integer[] randomArray(int size){
        Random random = new Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(size);
        }
        return arr;
    }
}
