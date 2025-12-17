package questions;

public class OOPLinkedListElement<T>{
    private T value;
    private OOPLinkedListElement<T> next;

    public OOPLinkedListElement(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public OOPLinkedListElement<T> getNext() {
        return next;
    }

    public void setNext(OOPLinkedListElement<T> next) {
        this.next = next;
    }
}