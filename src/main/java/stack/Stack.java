package stack;

import java.util.EmptyStackException;
import java.util.Objects;

public class Stack<T> implements Cloneable {
    private int size;
    private Node topElement;

    private class Node{
        private T value;
        private Node next;
        private Node(T value, Node next){
            this.value = value;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next);
        }

    }

    public Stack(){
        size = 0;
        topElement = null;
    }


    public void push(T elem){
        Node old = topElement;
        topElement = new Node(elem, old);
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public T pop(){ // Берёт верхний элемент и удаляет его
        if(isEmpty()) throw new EmptyStackException();
        T val = topElement.value;
        topElement = topElement.next;
        size--;
        return val;
    }

    public T getTopElement() { // Берёт значение верхнего элемента, но не удаляет
        return topElement.value;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node node = topElement;
        for (int i = 0; i < size; i++) {
            res.append(node.value).append("->");
            node = node.next;
        }
        res.append("null");
        return res.toString();
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stack stack = (Stack) o;
        return size == stack.size &&
                Objects.equals(topElement, stack.topElement);
    }

    @Override
    protected Stack clone() throws CloneNotSupportedException {
        Stack newStack = (Stack)super.clone();
        return newStack;
    }
}
