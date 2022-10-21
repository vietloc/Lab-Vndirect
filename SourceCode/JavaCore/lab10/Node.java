public class Node<T> {
    T value;

    Node<T> next;

    public TreeNode<T> parent;

    Node(T v){
        value = v;
    }

    Node(T v,Node<T>n){
        value = v;
        next = n;
    }

    public T getGetter() {
        return value;
    }

    public void setGetter(T value) {
        this.value = value;
    };
}
