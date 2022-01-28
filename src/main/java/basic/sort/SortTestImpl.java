package basic.sort;



public class SortTestImpl extends SortTest{

    public static void main(String[] args) {
        SortTest sortTest = new SortTestImpl();
        sortTest.test();
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
        

    }

    @Override
    public void insertionSort(Integer[] arr) {


    }

    @Override
    public void shellSort(Integer[] arr) {



    }

    @Override
    public void quickSort(Integer[] arr, int low, int high) {

    }



    @Override
    protected void mergeSort(Integer[] arr) {

    }


}
