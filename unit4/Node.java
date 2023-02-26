public class Node {
    public int data;
    public Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
        // next remains null!
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}