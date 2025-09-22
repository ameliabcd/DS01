public class Node <Y> {
    Y data;
    Node<Y> next;

    public Node(Y obj)
    {
        this.data=obj;
    }

    public Y getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node<Y> getNext() {
        return next;
    }

    public void setData(Y data) {
        this.data = data;
    }
}
