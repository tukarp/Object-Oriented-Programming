package pl.umcs;

import java.util.Collection;
import java.util.Comparator;

public class CountComparator <T extends Collection<?>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.size() - o2.size();
    }
}