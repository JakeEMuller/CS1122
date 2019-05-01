import java.util.ArrayList;

public class LinkedBinaryTreeNode<E> implements BinaryTreeNode<E> {
    private E data;
    private BinaryTreeNode<E> parent;
    private BinaryTreeNode<E> leftChild;
    private BinaryTreeNode<E> rightChild;


    public LinkedBinaryTreeNode(E data) {
        this.data = data;
    }


    @Override
    public E getData() {
        return data;
    }

    @Override
    public void setData(E data) {
        this.data = data;
    }


    @Override
    public BinaryTreeNode<E> getRoot() {
        if (getParent() != null) {
            return getParent().getRoot();
        } else {
            return this;
        }

    }

    @Override
    public BinaryTreeNode<E> getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode<E> parent) {
        this.parent = parent;
    }

    @Override
    public BinaryTreeNode<E> getLeft() {
        return leftChild;
    }

    @Override
    public void setLeft(BinaryTreeNode<E> child) {
        leftChild = child;
        if (child != null) {
            ((LinkedBinaryTreeNode<E>) child).setParent(this);
        }

    }

    @Override
    public BinaryTreeNode<E> getRight() {
        return rightChild;
    }

    @Override
    public void setRight(BinaryTreeNode<E> child) {
        rightChild = child;
        if (child != null) {
            ((LinkedBinaryTreeNode<E>) child).setParent(this);
        }

    }

    @Override
    public boolean isParent() {
        return leftChild != null || rightChild != null;
    }

    @Override
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    @Override
    public boolean hasLeftChild() {
        return leftChild != null;
    }

    @Override
    public boolean hasRightChild() {
        return rightChild != null;
    }

    @Override
    public int getDepth() {
        int depth = 0;
        BinaryTreeNode<E> node = this;
        while (node.getParent() != null) {
            depth++;
            node = node.getParent();
        }

        return depth;
    }


    private int height = 0;

    @Override
    public int getHeight() {
//        int height = 0;
        traverseInorder(node -> {
            if (node.isLeaf()) {
                if (node.getDepth() >= height) {
                    height = node.getDepth();
                }
            }
        });
        int result = height;
        height = 0;
        return result;
    }

    private int size = 0;

    @Override
    public int size() {
        traverseInorder(visitor -> {
            size++;
        });
        int result = size;
        size = 0;
        return result;
    }

    @Override
    public void removeFromParent() {
        BinaryTreeNode<E> parentNode = null;
        if (this.getParent() != null) {
            parentNode = this.getParent();
        } else {
            System.out.println("This element does not have a parent");
            return;
        }

        if (parentNode.getLeft() == this) {
            parentNode.setLeft(null);
        } else if (parentNode.getRight() == this) {
            parentNode.setRight(null);
        } else {
            return;
        }
    }


    //might run into problems with getTo with if statements
    @Override
    public ArrayList<BinaryTreeNode<E>> pathTo(BinaryTreeNode<E> descendant) {

        BinaryTreeNode<E> node = descendant;
        ArrayList<BinaryTreeNode<E>> getTo = new ArrayList<>();
        getTo.add(node);
        while (descendant.getParent() != this || descendant.getParent() != null) {
            getTo.add(0, node.getParent());
            node = node.getParent();
        }
        if (getTo.contains(this)) {
            return getTo;
        } else {
            return new ArrayList<BinaryTreeNode<E>>();
        }

    }


    @Override
    public ArrayList<BinaryTreeNode<E>> pathFrom(BinaryTreeNode<E> ancestor) {
        ArrayList<BinaryTreeNode<E>> getFrom = new ArrayList<>();
        BinaryTreeNode<E> node = this;
        getFrom.add(0, node);
        while (node.getParent() != ancestor || node.getParent() != null) {
            getFrom.add(0, node.getParent());
            node = node.getParent();
        }
        if (getFrom.contains(ancestor)) {
            return getFrom;
        } else {
            return new ArrayList<BinaryTreeNode<E>>();
        }
    }

    @Override
    public void traversePreorder(Visitor visitor) {
        BinaryTreeNode<E> node = this;
        visitor.visit(node);
        if (node.hasLeftChild()) {
            this.getLeft().traversePreorder(visitor);
        }
        if (node.hasRightChild()) {
            this.getRight().traversePreorder(visitor);
        }
    }

    @Override
    public void traversePostorder(Visitor visitor) {
        BinaryTreeNode<E> node = this;
        if (node.hasLeftChild()) {
            node.getLeft().traversePostorder(visitor);
        }
        if (node.hasRightChild()) {
            this.getRight().traversePostorder(visitor);
        }
        visitor.visit(this);
    }

    @Override
    public void traverseInorder(Visitor visitor) {
        BinaryTreeNode<E> node = this;
        if (node.hasLeftChild()) {
            this.getLeft().traverseInorder(visitor);
        }
        visitor.visit(this);
        if (node.hasRightChild()) {
            this.getRight().traverseInorder(visitor);
        }

    }

}
