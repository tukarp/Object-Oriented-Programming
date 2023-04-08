package pl.umcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //CustomList<String> list = new CustomList<>();
        List<String> list = new CustomList<>();
        list.add("ala");
        list.add("ma");
        list.add("kota");
        //list.addFirst("mała");
        //list.removeLast();
        for(int i=0; i<list.size(); i++) // skrajnie nieoptymalne
            System.out.println(list.get(i));

        System.out.println("---");

//        System.out.println(list.removeFirst());
//        System.out.println(list.removeFirst());
//        System.out.println(list.removeFirst());
//        System.out.println(list.removeFirst());

        for(String entry : list) // optymalne, wykorzystuje iterator
            System.out.println(entry);

        System.out.println("---");

        list.stream().forEach(System.out::println);

        System.out.println("---");

        List<Number> intList = new LinkedList<>(List.of(1,2.3,3,4.7,5,6,7,8,9.0,10,11));
        System.out.println(filter(intList, Integer.class));
        System.out.println(countInRange(list, "a", "l"));

        List<Integer> list1 = new ArrayList(List.of(1,2,3,4,5,6,100));
        List<Integer> list2 = new ArrayList(List.of(1,2,3,4,5,6,200));
        CountComparator<List<Integer>> countComparator = new CountComparator();
        System.out.println(countComparator.compare(list1,list2));

        SumComparator<List<Integer>, Integer> summaryComparator = new SumComparator();
        System.out.println(summaryComparator.compare(list1,list2));
    }

    public static <T> List<T> filter(List<T> objectList, Class filterClass) {
        List<T> resultList = new ArrayList<>();
        for (T item : objectList)
            if (filterClass.equals(item.getClass()))
                resultList.add(item);
        return resultList;
    }

    public static <T extends Comparable> int countInRange(List<T> list, T begin, T end) {
        RangePredicate<T> predicate = new RangePredicate<>(begin, end);
        return (int) list.stream()
                .filter(predicate)
                .count();
    }
}
