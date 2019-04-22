import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

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

    public interface Visitor<E> {
        public void visit(E value);
    }

    public void preOrderTraversal(Node node, Visitor visitor) {
        if (node == null) {
            return;
        }
        visitor.visit(node.value);
        preOrderTraversal(node.leftChild, visitor);
        preOrderTraversal(node.rightChild, visitor);
    }


    public void postOrderTraversal(Node node, Visitor visitor) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.leftChild, visitor);
        postOrderTraversal(node.rightChild, visitor);
        visitor.visit(node.value);
    }


    //Find algorithm created for Week 17 exersises
    int findIndex = 0;
    E result = null;

    public E findInSortOrder(int index) {
        inOrderTraversal(root, value -> {
            findIndex++;
            if (findIndex == index) {
                result = (E) value;
                return;
            }
        });
        findIndex = 0;
        return result;
    }

    public void inOrderTraversal(Node node, Visitor visitor) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftChild, visitor);
        visitor.visit(node.value);
        inOrderTraversal(node.rightChild, visitor);

    }

    public void depthFirstTraversal(Node subTreeRoot, Visitor visitor) {
        Stack<Node> stack = new Stack<>();
        stack.push(subTreeRoot);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            visitor.visit(currentNode.value);
            if (currentNode.rightChild != null) stack.push(currentNode.rightChild);
            if (currentNode.leftChild != null) stack.push(currentNode.leftChild);
        }
    }

    public void breathFirstTraversal(Node subTreeRoot, Visitor visitor) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(subTreeRoot);
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            visitor.visit(currentNode.value);
            if (currentNode.leftChild != null) queue.add(currentNode.leftChild);
            if (currentNode.rightChild != null) queue.add(currentNode.rightChild);
        }
    }


    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(4);
        tree.add(2);
        tree.add(7);
        tree.add(5);
        tree.add(1);
//        System.out.println("pre order time");
//        ArrayList foo = new ArrayList<>();
//        tree.preOrderTraversal(tree.root, value -> {
//            System.out.println(value);
//        });
//        System.out.println("In order time");
//        tree.inOrderTraversal(tree.root, value -> {
//            System.out.println(value);
//        });
//        System.out.println("post order time");
//        tree.postOrderTraversal(tree.root, value -> {
//            System.out.println(value);
//        });
        System.out.println("depth first time");
        tree.depthFirstTraversal(tree.root, value -> {
            System.out.println(value);
        });
//        System.out.println("Find index testing");
//        System.out.println("5 expected: " + tree.findInSortOrder(4));
//        System.out.println("4 expected: " + tree.findInSortOrder(3));
//        System.out.println("7 expected: " + tree.findInSortOrder(5));
//        System.out.println("7 expected: " + tree.findInSortOrder(5));
    }

}