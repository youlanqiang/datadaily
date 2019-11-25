package season01listStackAndQueue;

import java.util.Stack;

public interface List<T> extends Collection{

    T get(int index);

    T set(int index, T newVal);

    void add(int index, T x);

    void remove(int index);

}
