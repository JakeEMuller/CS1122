import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;

public class LinkedBinaryTreeNode<E> implements BinaryTreeNode<E> {
    E data;
    BinaryTreeNode<E> parent;
    BinaryTreeNode<E> leftChild;
    BinaryTreeNode<E> rightChild;


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
            parent.getRoot();
        }
        return this;
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
        ((LinkedBinaryTreeNode<E>) child).setParent(this);
    }

    @Override
    public BinaryTreeNode<E> getRight() {
        return rightChild;
    }

    @Override
    public void setRight(BinaryTreeNode<E> child) {
        rightChild = child;
        ((LinkedBinaryTreeNode<E>) child).setParent(this);
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
        ArrayList<BinaryTreeNode<E>> leafList = new ArrayList<>();
        BinaryTreeNode<E> root = getRoot();
        traverseInorder(node -> {
            if (node.isLeaf()) {
                if (node.getDepth() >= height) {
                    height = node.getDepth();
                }
            }
        });
        int result = height;
        height = 0;

//        int height = 0;
//        for(int i = 0; i < leafList.size(); i++){
//            int leafHeight = leafList.get(i).getDepth();
//            if( leafHeight >= height){
//                height = leafHeight;
//            }
//        }
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
        return size;
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
        visitor.visit(this);
        this.getLeft().traversePreorder(visitor);
        this.getRight().traversePreorder(visitor);
    }

    @Override
    public void traversePostorder(Visitor visitor) {
        this.getLeft().traversePostorder(visitor);
        this.getRight().traversePostorder(visitor);
        visitor.visit(this);
    }

    @Override
    public void traverseInorder(Visitor visitor) {
        this.getLeft().traverseInorder(visitor);
        visitor.visit(this);
        this.getRight().traverseInorder(visitor);
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(0, 4);
        test.add(0, 5);
        test.add(0, 7);
        System.out.println(test.toString());
    }

}
