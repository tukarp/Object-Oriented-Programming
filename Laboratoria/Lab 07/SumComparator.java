package pl.umcs;

import java.util.Collection;
import java.util.Comparator;

public class SumComparator <T extends Collection<E>,E extends Number> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Double.compare(o1.stream().map(E::doubleValue).reduce(0.0,Double::sum),
                o2.stream().map(E::doubleValue).reduce(0.0,Double::sum));
    }
}
