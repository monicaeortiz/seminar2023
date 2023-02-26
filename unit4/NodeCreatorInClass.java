public class NodeCreatorInClass {
    public static void main(String[] args) {
        Node first = new Node(100);
        Node second = new Node(200);

        first.next = second;  // Now first is linked to second!
        System.out.println(toString(first));

        // Initializing a list containing [8, 9, 11].
        Node head = new Node(8, new Node(9, new Node(11)));
        System.out.println(toString(head));
    }

    // Returns a string representation of a linked list, given the start node.
    public static String toString(Node start) {
        String toRet = "[";
        Node current = start;
        while (current != null) {
            toRet += current.data + " ";  // Add a space between elements.
            current = current.next;
        }
        return toRet + "]";
    }
}