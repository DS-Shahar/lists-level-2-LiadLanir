import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 8};
        int[] arr2 = {3, 7, 9, 10, 11};
        int[] arr3 = {4, 2, 7, 4, 5};

        Node<Integer> list1 = buildList(arr1);
        Node<Integer> list2 = buildList(arr2);
        Node<Integer> list3 = buildList(arr3);

        printList(SelectionSort(list3));
    }

    public static Node<Integer> SortLists(Node<Integer> L1, Node<Integer> L2) {
        Node<Integer> p1 = L1;
        Node<Integer> p2 = L2;
        Node<Integer> head3 = new Node<>(null);
        Node<Integer> p3 = head3;

        while (p1 != null && p2 != null) {
            if (p1.getValue() == p2.getValue()) {
                p3.setNext(new Node<>(p1.getValue()));
                p3 = p3.getNext();
                p3.setNext(new Node<>(p1.getValue()));
                p1 = p1.getNext();
                p2 = p2.getNext();
            } else if (p1.getValue() > p2.getValue()) {
                p3.setNext(new Node<>(p2.getValue()));
                p2 = p2.getNext();
            } else {
                p3.setNext(new Node<>(p1.getValue()));
                p1 = p1.getNext();
            }
            p3 = p3.getNext();
        }

        while (p1 != null) {
            p3.setNext(new Node<>(p1.getValue()));
            p1 = p1.getNext();
            p3 = p3.getNext();
        }

        while (p2 != null) {
            p3.setNext(new Node<>(p2.getValue()));
            p2 = p2.getNext();
            p3 = p3.getNext();
        }

        return head3.getNext();
    }

    public static Node<Integer> SelectionSort(Node<Integer> L1) {
        if (L1 == null) return null;

        Node<Integer> sortedHead = null;
        Node<Integer> sortedTail = null;

        while (L1 != null) {
            Node<Integer> minNode = L1;
            Node<Integer> p = L1.getNext();

            while (p != null) {
                if (p.getValue() < minNode.getValue()) {
                    minNode = p;
                }
                p = p.getNext();
            }

            Node<Integer> newNode = new Node<>(minNode.getValue());

            if (sortedHead == null) {
                sortedHead = newNode;
                sortedTail = newNode;
            } else {
                sortedTail.setNext(newNode);
                sortedTail = newNode;
            }

            if (minNode == L1) {
                L1 = L1.getNext();
            } else {
                Node<Integer> prev = L1;
                while (prev.getNext() != minNode) {
                    prev = prev.getNext();
                }
                prev.setNext(minNode.getNext());
            }
        }

        return sortedHead;
    }

    public static Node<Integer> buildList(int[] arr) {
        Node<Integer> head = new Node<>(arr[0]);
        Node<Integer> p = head;
        for (int i = 1; i < arr.length; i++) {
            Node<Integer> newNode = new Node<>(arr[i]);
            p.setNext(newNode);
            p = newNode;
        }
        return head;
    }

    public static void printList(Node<Integer> head) {
        Node<Integer> current = head;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public static boolean appearsRec(Node<Integer> l, int num) {
        if (l == null) return false;
        if (l.getValue() == num) return true;
        return appearsRec(l.getNext(), num);
    }

    public static Node<Integer> deleteAt(Node<Integer> l, int num) {
        if (num < 1) return l;
        if (num == 1) return l.getNext();

        Node<Integer> p = l;
        int i = 1;
        while (p != null) {
            if (i == num - 1) {
                p.setNext(p.getNext().getNext());
                break;
            }
            p = p.getNext();
            i++;
        }
        return l;
    }
}

class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
