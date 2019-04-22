import java.util.ArrayList;

public class LinkedBinaryTreeNode<E> implements BinaryTreeNode<E> {
    E data;
    BinaryTreeNode<E> parent;
    BinaryTreeNode<E> leftChild;
    BinaryTreeNode<E> rightChild;


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
        if(getParent() != null){
            parent.getRoot();
        }
        return this;
    }

    @Override
    public BinaryTreeNode<E> getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode<E> parent){
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
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void removeFromParent() {

    }

    @Override
    public ArrayList<BinaryTreeNode<E>> pathTo(BinaryTreeNode<E> descendant) {
        return null;
    }

    @Override
    public ArrayList<BinaryTreeNode<E>> pathFrom(BinaryTreeNode<E> ancestor) {
        return null;
    }

    @Override
    public void traversePreorder(Visitor visitor) {

    }

    @Override
    public void traversePostorder(Visitor visitor) {

    }

    @Override
    public void traverseInorder(Visitor visitor) {

    }
}
