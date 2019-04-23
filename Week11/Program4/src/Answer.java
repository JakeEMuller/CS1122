public class Answer<E> extends LinkedBinaryTreeNode<E> {

    public Answer(E answer){
        super( answer);
    }


    public boolean isQuestion(){
        return false;
    }

    public boolean isAnswer(){
        return true;
    }
}
