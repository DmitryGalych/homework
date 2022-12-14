package collections.nodelist;

public interface INodeList<T> {

    void add(T elm);

    void remove(T elm);

    String asSting();

    int size();
}
