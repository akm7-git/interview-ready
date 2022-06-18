package com.akm.intready.linkedlist;

public class LinkedListUtils {

    public static Node createLinkedList(Object... datas) {
        Node head = new Node(datas[0]);
        Node prev = head;
        for (Object n : datas) {
            Node currentNode = new Node(n);
            prev.setNext(currentNode);
            prev = currentNode;
        }
        return head;
    }

    public static void printLinkedList(Node head) {
        int ctr = 0;
        while (null != head.getNext()) {
            System.out.println(" node : " + ctr + " : " + head.getNext().getData());
            head = head.getNext();
            ctr++;
        }
    }

    public static int getLengthOfLinkedList(Node head) {
        int ctr = 0;
        while (null != head.getNext()) {
            ctr++;
            head = head.getNext();
        }
        return ctr;
    }

    public static Node insertNode(Node head, Object data, int index) {
        Node nodeToInserted = new Node(data);
        if (null == head) {
            return nodeToInserted;
        }
        if (getLengthOfLinkedList(head) < index) {
            System.out.println("Insertion is not possible");
            return head;
        }
        int ctr = 0;
        Node cNode = head;
        Node next = null;
        while (ctr != index) {
            cNode = cNode.getNext();
            ctr++;
        }
        if (null != cNode.getNext()) {
            next = cNode.getNext();
        }
        cNode.setNext(nodeToInserted);
        nodeToInserted.setNext(next);
        return head;
    }

    public static Node deleteNode(Node head, int nodeIndexToBeDeleted) {
        if (null == head) {
            return null;
        }
        if (getLengthOfLinkedList(head) < nodeIndexToBeDeleted) {
            System.out.println("deletion is not possible");
            return head;
        }
        int ctr = 0;
        Node cNode = head;
        while (ctr != nodeIndexToBeDeleted) {
            cNode = cNode.getNext();
            ctr++;
        }
        Node ntd = cNode.getNext();
        cNode.setNext(ntd.getNext());
        ntd = null;
        return head;
    }


}
