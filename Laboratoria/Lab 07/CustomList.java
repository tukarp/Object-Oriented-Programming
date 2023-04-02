package pl.umcs;

import java.util.*;
import java.util.stream.Stream;

public class CustomList<T> extends AbstractList<T> {
    private class Node {
        T value;
        Node next;
    }

    Node head, tail;

    public CustomList() {
        head = tail = null;
    }

    public void addLast(T value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;

        if(head == null) // lista jest pusta
            head = tail = newNode;
        else { // lista ma co najmniej 1 element
            tail.next = newNode;
            tail = newNode;
        }
    }

    public T getLast() {
        if(tail == null)
            throw new NoSuchElementException();
        else
            return tail.value;
    }

    public void addFirst(T value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;

        if(head == null) // lista jest pusta
            head = tail = newNode;
        else { // lista ma co najmniej 1 element
            newNode.next = head;
            head = newNode;
        }
    }

    @Override
    public boolean add(T t) {
        addLast(t);
        return true;
    }

    public T getFirst() {
        if(head == null)
            throw new NoSuchElementException();
        else
            return head.value;
    }

    public T removeFirst() {
        if(head == null)
            throw new NoSuchElementException();
        else if(head == tail) { // jest 1 element
            Node resultNode = tail;
            head = tail = null;
            return resultNode.value;
        }
        else {
            Node resultNode = head;
            head = head.next;
            return resultNode.value;
        }
    }

    public T removeLast() {
        if(head == null)
            throw new NoSuchElementException();
        else if(head == tail) { // jest 1 element
            Node resultNode = tail;
            head = tail = null;
            return resultNode.value;
        }
        else {
            Node resultNode = tail;
            Node currentNode = head;
            while(currentNode.next != tail)
                currentNode = currentNode.next;
            currentNode.next = null;
            tail = currentNode;
            return resultNode.value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                Node resultNode = currentNode;
                currentNode = currentNode.next;
                return resultNode.value;
            }
        };
    }

    @Override
    public T get(int index) {
        if(head == null)
            throw new NoSuchElementException();
        else {
            Node currentNode = head;
            for(int i=0; i<index; i++)
                currentNode = currentNode.next;
            return currentNode.value;
        }
    }

    @Override
    public int size() {
        if(head == null)
            return 0;
        else {
            int result = 1;
            Node currentNode = head;
            while (currentNode != tail) {
                result++;
                currentNode = currentNode.next;
            }
            return result;
        }
    }

    @Override
    public Stream<T> stream() {
        Stream.Builder<T> streamBuilder = Stream.builder();
        for(T entry : this)
            streamBuilder.accept(entry);
        return streamBuilder.build();
    }
}
