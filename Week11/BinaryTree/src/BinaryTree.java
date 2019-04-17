public class BinaryTree<E extends Comparable> {

    //*********************
    // Helper Class
    //*********************
    private class Node {
        E value;
        Node leftChild;
        Node rightChild;

        public Node(E value) {
            this.value = value;
        }
    }

    //*********************
    // Methods
    //*********************
    Node root;
    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public void add(E value) {
        if (value == null) {
            throw new IllegalArgumentException("value to be added is null");
        }
        if (root != null) {
            add(root, value);
        } else {
            Node newNode = new Node(value);
            root = newNode;
            size++;
        }

    }

    public void add(Node node, E value) {
        if (value.compareTo(node.value) < 0) {
            if (node.leftChild != null) {
                add(node.leftChild, value);
            } else {
                Node newNode = new Node(value);
                node.leftChild = newNode;
                size++;
                return;
            }
        } else {
            if (node.rightChild != null) {
                add(node.rightChild, value);
            } else {
                Node newNode = new Node(value);
                node.rightChild = newNode;
                size++;
                return;
            }
        }
    }
}