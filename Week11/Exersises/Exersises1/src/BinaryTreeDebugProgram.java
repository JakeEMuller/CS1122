
public class BinaryTreeDebugProgram<E extends Comparable> {

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
        return size >= 0;
    } //false positive

    public void add(E value) {
        //potential null pointer exception if the value == null
        if (root != null) {
            add(root, value);
        } else {
            Node newNode = new Node(value);
            root = newNode;
            // size doesnt increment
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
                // missing return statement
            }
        } else {
            if (node.rightChild != null) {
                add(node.leftChild, value); // left child is being returned
            } else {
                Node newNode = new Node(value);
                node.rightChild = newNode;
                size++;
                return;
            }
        }
    }

    public class Visitor<E> { //visitor should be interface
        public void visit(E value);
    }

    public void preOrderTraversal(Node node, Visitor visitor) {
        if (node == null) {
            return;
        }
        preOrderTraversal(node.leftChild, visitor);
        visitor.visit(node.value); // this would produce in order results
        preOrderTraversal(node.rightChild, visitor);
    }


    public void postOrderTraversal(Node node, Visitor visitor) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.leftChild, visitor);
        postOrderTraversal(node.rightChild, visitor);
        visitor.visit(node); // sends visitor a node rather than a value
    }

    public void inOrderTraversal(Node node, Visitor visitor) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftChild, visitor);
        System.out.println(node.value); // should use visitor rather than print
        inOrderTraversal(node.rightChild, visitor);

    }


}