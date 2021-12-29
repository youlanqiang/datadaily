package season01listStackAndQueue.example;

public class ArrayStore {

    public static void main(String[] args) {
        Person[] arr = new Employee[5];
        arr[0] = new Student();  // java.lang.ArrayStoreException 在这一步直接报错

    }


    public static interface Person{

    }

    public static class Employee implements Person{

    }

    public static class Student implements Person{

    }

}
