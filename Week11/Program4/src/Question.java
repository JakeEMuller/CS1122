public class Question<E> extends LinkedBinaryTreeNode<E> {

    public Question( E question){
        super(question);

    }

    public boolean isQuestion(){
        return true;
    }

    public boolean isAnswer(){
        return false;
    }



}
