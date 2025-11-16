import java.util.Scanner;

public class linkedlist01 {
    Node<Integer> head;
    int size;

    linkedlist01() {
        this.head = null;
        this.size = 0;
    }

    public void insertNode(int data, int position) {
        if(position> size +1 || position <=0){
            System.out.println("Invalid position");
            return;
        }
        if(position ==1){
            insertHead(data);
            return;
        }else if(position == size +1){
            insertTail(data);
            return;
        }else{
            int counter=1;
            Node<Integer> newNode = new Node<>(data);
            Node<Integer> temp = head;
            while(counter < position -1 && temp != null){
                temp = temp.next;
                counter++;
            }

            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
        System.out.println("Insertion at position " + position + " successful");
    }

    public void insertHead(int data) {
        Node<Integer> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("Insertion at head successful");
    }

    public void insertTail(int data) {
        Node<Integer> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            size++;
            System.out.println("Insertion at tail successful");
            return;
        }
        Node<Integer> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        size++;
        System.out.println("Insertion at tail successful");
    }

    public void deleteHead() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }
        Node<Integer> temp = head;
        head = head.next;
        temp.next = null;
        System.out.println("Deletion at head successful");
        size--;
    }

    public void deleteTail() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            size--;
            System.out.println("Deletion at tail successful");
            return;
        }
        Node<Integer> temp = head;
        Node<Integer> prev = null;
        while (temp.next != null) {
            prev =temp;
            temp = temp.next;
        }
        prev.next = null;
        System.out.println("Deletion at tail successful");
        size--;
    }

    public void deleteNode(int position) {
        if (position > size || position <= 0) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 1) {
            deleteHead();
        } else if (position == size) {
            deleteTail();
        } else {
            Node<Integer> temp = head;
            Node<Integer> prev = null;
            int counter = 1;
            while (counter < position) {
                prev = temp;
                temp = temp.next;
                counter++;
            }
            prev.next = temp.next;
            temp.next = null;
            size--;
            System.out.println("Deletion at position " + position + " successful");
        }
    }

    public void updateNode(int position, int updatedValue){
        if(head == null){
            System.out.println("Linked List is empty");
            return;
        }
        int counter =1;
        Node<Integer> temp = head;
        while(counter < position && temp != null){
            temp = temp.next;
            counter++;
        }
        if(temp!=null && counter == position){
            temp.data = updatedValue;
            System.out.println("Node updated at position " + position);
        } else {
            System.out.println("Invalid position");
        }
    }
    
    public boolean searchNode(int searchedValue){
        if(head == null){
            System.out.println("Linked List is empty");
            return false;
        }
        int counter =1;
        Node<Integer> temp = head;
        while(temp!= null){
            if(temp.data == searchedValue){
                System.out.println("Value found at position " + counter);
                return true;
            }
            temp = temp.next;
            counter++;
        }
        System.out.println("Value not found in the list");
        return false;

    }

    public void printList() {
        Node<Integer> temp = head;
        while(temp != null) {
            System.out.print("data is -> " + temp.data + "\n");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        linkedlist01 list = new linkedlist01();
        Scanner sc = new Scanner(System.in);

        list.insertHead(10);
        list.printList();
        list.insertTail(20);
        list.printList();
        list.insertHead(5);
        list.printList();
        list.insertNode(40, 5);
        list.insertNode(40, 4);
        list.insertNode(35, 4);
        list.insertNode(68, 5);
        list.insertNode(78, 6);
        list.printList();
        list.deleteTail();
        list.printList();
        list.deleteHead();
        list.printList();
        list.deleteNode(3);
        list.printList();
        list.updateNode(3, 100);
        list.printList();
        list.searchNode(100);
        list.searchNode(500);



    }
    }

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}
