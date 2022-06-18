package com.akm.intready.linkedlist;

public class LInkedListTest {

    public static void main(String[] args) {
       Node head =  LinkedListUtils.createLinkedList(2,3,4,5,6,7);
        LinkedListUtils.printLinkedList(head);
        System.out.println("Length of the linkedlist is : " + LinkedListUtils.getLengthOfLinkedList(head));
        head = LinkedListUtils.insertNode(head, 10, 4);
        System.out.println("Length of the linkedlist is : " + LinkedListUtils.getLengthOfLinkedList(head));
        LinkedListUtils.printLinkedList(head);
        LinkedListUtils.deleteNode(head,4);
        System.out.println("Length of the linkedlist is : " + LinkedListUtils.getLengthOfLinkedList(head));
        LinkedListUtils.printLinkedList(head);
    }
}
