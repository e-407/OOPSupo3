package proj1a;

import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T>{
    Node sentinel = new Node();
    int size;

    public LinkedListDeque61B(){
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        Node newHead = new Node(x);
        newHead.setNext(sentinel.getNext());
        newHead.setPrev(sentinel);
        sentinel.getNext().setPrev(newHead);
        sentinel.setNext(newHead);
        size += 1;
    }

    @Override
    public void addLast(T x) {
        Node newTail = new Node(x);
        newTail.setPrev(sentinel.getPrev());
        newTail.setNext(sentinel);
        sentinel.getPrev().setNext(newTail);
        sentinel.setPrev(newTail);
        size += 1;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<T>();
        Node node = sentinel.getNext();
        while(node != sentinel){
            returnList.add(node.getVal());
            node = node.getNext();
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return (sentinel.getNext()==sentinel);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()){
            return null;
        }
        Node currentHead = sentinel.getNext();
        Node newHead = currentHead.getNext();
        newHead.setPrev(sentinel);
        sentinel.setNext(newHead);
        size -= 1;
        return currentHead.getVal();
    }

    @Override
    public T removeLast() {
        if (isEmpty()){
            return null;
        }
        Node currentTail = sentinel.getPrev();
        Node newTail = currentTail.getPrev();
        newTail.setNext(sentinel);
        sentinel.setPrev(newTail);
        size -= 1;
        return currentTail.getVal();
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0){
            return null;
        }
        Node node = sentinel.getNext();
        for (int i=0; i<index; i++){
            node = node.getNext();
        }
        return node.getVal();
    }

    @Override
    public T getRecursive(int index) {
        if (index >= size || index < 0){
            return null;
        }
        return getRecursiveHelper(index, sentinel.getNext());
    }

    private T getRecursiveHelper(int index, Node node){
        if (index == 0){
            return node.getVal();
        } else {
            return getRecursiveHelper(index - 1, node.getNext());
        }
    }

    private class Node{
        Node prev;
        Node next;
        T val;

        public Node(){

        }

        public Node(T val){
            this.val = val;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getVal() {
            return val;
        }

        public void setVal(T val) {
            this.val = val;
        }
    }
}
