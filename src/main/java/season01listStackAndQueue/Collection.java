package season01listStackAndQueue;

import java.util.Iterator;

/**
 * 集合类接口
 */
public interface Collection<T> extends Iterable{

    int size();

    boolean isEmpty();

    void clear();

    boolean contains(T x);

    boolean add(T x);

    boolean remove(T x);

    Iterator<T> iterator();

}
