

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MyArray<E> implements Iterable<E> {
    E[] myArray = (E[]) new Object[0];

    /**
     * No-Args Constructor
     */
    public MyArray(){}

    /**
     * A constructor that allows yu to specify the initial size
     * @param initialSize
     */
    public MyArray(int initialSize ){
        myArray = (E[]) new Object[initialSize];
    }

    private void extendArray(int newLength){
        E[] tempArray = (E[]) new Object[newLength];
        for(int i = 0 ; i < myArray.length; i++){
            tempArray[i] = myArray[i];

        }
        myArray = tempArray;
    }

    /**
     * Returns the specified element from the array
     * @param index
     * @return
     */
    public E get(int index){
        if(index >= myArray.length){
            extendArray(index + 1);
        }
        return myArray[index];
    }

    /**
     * Sets an index of the array to a particular value
     * @param index
     * @param element
     */
    public void set(int index, E element){
        if(index >= myArray.length){
            extendArray(index + 1);
        }
        myArray[index] = element;
    }

    /**
     *
     * @return size of the array
     */
    public int size(){
        return myArray.length;
    }



    /**
     * converts Array into a string
     * @return
     */
    public String toString(){
        return Arrays.toString(myArray);
    }

    /**
     *
     * @return true is the array is empty
     */
    public boolean isEmpty(){
        if(myArray.length == 0){
            return true;
        } else {
            return false;
        }
    }

    /**
     * tests two arrays to test if they are equal.
     * @return
     */
    public boolean equals(MyArray<E> newArray) {
        E[] temp = newArray.getMyArray();

        if(temp.length != myArray.length){
            return false;
        } else {
            for(int i = 0; i < myArray.length; i++){
                if(!temp[i].equals(myArray[i]) ){
                    System.out.println(temp[i]);
                    System.out.println(myArray[i]);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns an iterator over elements of type {@code T}
     *
     * @return an Iterator
     */
    @Override
    public Iterator<E> iterator() {
        ArrayList<E> list = new ArrayList<E>();
        for(int i = 0; i < size(); i++){
            list.add(myArray[i]);
        }
        return list.iterator();
    }


    public E[] getMyArray() {
        return myArray;
    }

    public void setMyArray(E[] myArray) {
        this.myArray = myArray;
    }


    // main method used for testing
    public static void main(String[] args) {
        MyArray<Integer> test = new MyArray<>();
        MyArray<Integer> test2 = new MyArray<>();

        for(int i = 0; i < 16; i++ ){
            test2.set(i, new Integer(i));
            test.set( i, new Integer(i));
        }
        for(Object e : test){
            System.out.println(e);
        }
        System.out.println(test.toString());
        System.out.println(test2.toString());
        boolean temp = test.equals(test2);
        System.out.println(temp);
    }
}
