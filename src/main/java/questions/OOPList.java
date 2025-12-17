package questions;

public interface OOPList<T> {
    void add(T value);
    void remove();
    T get(int n);
    int length();
}