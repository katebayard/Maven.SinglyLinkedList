package com.zipcodewilmington.singlylinkedlist;

import java.util.List;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T> {

    Node startingNode;

    public SinglyLinkedList(T element) {
        this.startingNode = new Node(element);
    }

    public class Node {
        T element;
        Node nextNode;

        public Node(T element) {
            this.element = element;
            this.nextNode = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void updateNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }

    public void add(T element) {
        Node currentNode = startingNode;
        while(currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        Node newNode = new Node(element);
        currentNode.updateNextNode(newNode);
    }

    public void remove(int index) {
        Node currentNode = getNodeByIndex(index);;
        currentNode.setElement(null);
    }

    private Node getNodeByIndex(int index) {
        Node currentNode = startingNode;
        int currentIndex = 0;
        while (currentIndex < index) {
            currentNode = currentNode.getNextNode();
            currentIndex ++;
        }
        return currentNode;
    }

    public boolean contains(T elementToLookFor) {
        if(find(elementToLookFor) != -1) {
            return true;
        }
        return false;
    }

    public int find(T elementToLookFor) {
        Node currentNode = startingNode;
        int currentIndex = 0;
        do {
            if(currentNode.getElement() == elementToLookFor) {
                return currentIndex;
            } else {
                currentNode = currentNode.getNextNode();
                currentIndex++;
            }
        } while(currentNode != null);

        return -1;
    }

    public int size() {
        Node currentNode = startingNode;
        int currentSize = 1;
        do {currentNode = currentNode.getNextNode();
            currentSize++;
        } while(currentNode.getNextNode() != null);
        return currentSize;
    }

    public Object get(int index) {
        Node currentNode = getNodeByIndex(index);
        return currentNode.getElement();
    }

}

//copy -- returns a new linked list containing the same values (look up deep versus shallow copy)
//sort -- sorts the list using your algorithm of choice. You must perform the sorting yourself (no fair using someone else's library)