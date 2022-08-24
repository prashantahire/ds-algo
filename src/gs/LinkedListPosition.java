package gs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedListPosition {

    public static void main(String ...args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String noOfElements = reader.readLine();
        String elements = reader.readLine();
        Node head = null;
        if(elements != null){
            head = buildLinkedList(elements.split(" "));
        }
        String element = reader.readLine();
        printFirstAndLastPosition(Integer.parseInt(element), head);
    }

    public static void printFirstAndLastPosition(int element, Node head){
        if(head == null)
            return;
        int i=0;
        Node temp = head;
        int firstPosition = -1;
        int lastPostion = -1;
        while(temp!= null){
            if(temp.value == element){
                if(firstPosition == -1){
                    firstPosition = i;
                    lastPostion = i;
                }else{
                    lastPostion = i;
                }
            }
            temp = temp.next;
            i++;
        }
        System.out.println("First position: "+firstPosition);
        System.out.println("Last position: "+lastPostion);
    }
    public static Node buildLinkedList(String values[]){
        if(values == null || values.length == 0){
            return null;
        }
        Node head = new Node(Integer.parseInt(values[0]));
        Node prevNode = head;
        for(int i=1; i<values.length; i++){
            Node node = new Node(Integer.parseInt(values[i]));
            prevNode.next = node;
            prevNode = node;
        }
        return head;
    }
}
class Node{
    int value;
    Node next;
    Node(int value){
        this.value = value;
    }
}
