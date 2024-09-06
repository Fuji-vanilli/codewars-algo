package org.example.functional;


import java.util.Objects;
import java.util.function.Function;

public interface Comparator<T>  {

    int compare(T o1, T o2);

    default <U extends Comparable<U>> Comparator<T> thenComparing(Function<T, U> keyExtractor) {
        return thenComparing(comparing(keyExtractor));
    }
    default Comparator<T> thenComparing(Comparator<T> other) {
        return (t1, t2)-> {
            final int compareResult = this.compare(t1, t2);
            return compareResult== 0 ? other.compare(t1, t2) : compareResult;
        };
    }

    static <T, U extends Comparable<U>> Comparator<T> comparing(Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);

        return (o1, o2)-> keyExtractor.apply(o1).compareTo(keyExtractor.apply(o2));
    }
}
