import java.util.NoSuchElementException;

public class OOPLinkedList<T> implements OOPList<T>{
    private OOPLinkedListElement<T> head;

    public OOPLinkedList() {
        this.head = null;
    }

    public void add(T value) {
        OOPLinkedListElement<T> newElement = new OOPLinkedListElement<T>(value);
        newElement.setNext(head);
        this.head = newElement;
    }

    public void remove() {
        if (head != null) {
            head = head.getNext();
        }
    }

    public T get(int n) {
        OOPLinkedListElement<T> current = head;
        for (int i = 0; i < n; i++) {
            if (current == null) throw new NoSuchElementException();
            current = current.getNext();
        }
        if (current == null) throw new NoSuchElementException();
        return current.getValue();
    }

    public int length() {
        int count = 0;
        OOPLinkedListElement<T> current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    protected OOPLinkedListElement<T> getHead() {
        return head;
    }

    protected void setHead(OOPLinkedListElement<T> head) {
        this.head = head;
    }

    public T getHeadValue() {
        if (head == null) throw new NoSuchElementException();
        return head.getValue();
    }
}