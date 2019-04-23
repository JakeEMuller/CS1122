public class Scheduler {
    class Node {
        int data;
        String event;

        Node(int data, String event){
            this.data= data;
            this.event = event;
        }
    }
    Node firstEvent = null;
    public void add(Node node){
        if(firstEvent == null){
            firstEvent = node;
        } else {
            
        }
    }

    public void remove(String event){

    }

    public String getList(){
        return null;
    }
}
