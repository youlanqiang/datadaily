package season01listStackAndQueue;

public interface List<T> extends Collection<T>{

    T get(int index);

    T set(int index, T newVal);

    void add(int index, T x);

    T remove(int index);

}
