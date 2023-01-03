package pl.umcs;

import java.util.function.Predicate;

public class RangePredicate <T extends Comparable> implements Predicate<T> {
    private T begin, end;

    public RangePredicate(T begin, T end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public boolean test(T t) {
        return t.compareTo(begin)>0 && t.compareTo(end)<0;
    }
}