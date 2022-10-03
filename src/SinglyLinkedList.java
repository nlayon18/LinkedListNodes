import java.util.NoSuchElementException;

public class SinglyLinkedList {
    int size;
    Node head;
    Node tail;

    public SinglyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public void clear() {
        size = 0;
        head = null;
        tail = null;

    }
    public void printList() {
        //
        if (size == 0){
            System.out.println("This list is empty!");
            return;
        }

        //Beginnning of head/setting up the current

        Node current = head; // This will always be non-null when the list is at lease size 1.

        //Current is jumping next each node until it reaches null
        while (current != null) {
            System.out.print(current.data + " - > ");
            current = current.next;

        }

        System.out.println("end");
    }

    //How to add a head or tail to a list

    // Process to add a new node to the head and adjusting the head
    public void addFirst(String data) {
        // if size == 0 ... essencially we aren't adding anything to the empty list so
        // both head and tail will not be adjusted.
        if(size == 0){
            Node newNode = new Node(data, null);
            head = newNode;
            tail = newNode;
            //Changing the size of the list of nodes.
            ++size;
        } else {
            Node newNode = new Node (data, head);
            //Connecting the new head to the previous head.

            head = newNode;
            //Changing the size of the list of nodes.
            ++size;
        }

    }
    // Process to add a new node to the tail and adjusting the tail
    public void addlast(String data) {
        if(size == 0){
            Node newNode = new Node(data, null);
            head = newNode;
            tail = newNode;
            //Changing the size of the list of nodes.
            ++size;

        } else {
            Node newNode = new Node (data, null);
            //Connecting the previous tail to the new tail.
            tail.next = newNode;
            tail = newNode;
            //Changing the size of the list of nodes.
            ++size;
        }
    }
    // This method is returning a Node
    public Node getFirst() {
        // Checking if list is empty
        if (size == 0){
            // You can totally throw in an exception
            // throw new NoSuchElementException("This list is empty")
            System.out.println("This list is empty!");
            return null;
        } else {
            return head;
        }

    }

    public Node getLast() {
        // Checking if list is empty
        if (size == 0) {
            // You can totally throw in an exception
            // throw new NoSuchElementException("This list is empty")
            System.out.println("This list is empty!");
            return null;
        } else {
            return tail;
        }
    }


    public void removeFirst() {
        if (size == 0) {
            System.out.println("this list is empty!");
        }else {
            head = head.next;
            --size; // Remember to decrease the size of the list when removing a node!
        }
    }
//    public void removeLast() {
//        /* For single lists we can't move the tail we have to create a loop to reorganize our list...
//           This isn't a with double lists problem */
//        if (size == 0){
//            System.out.println("This List is empty!");
//        }else{
//            Node current = head;
//
//            while (current.next != tail){
//                current = current.next;
//            }
//
//            tail = current;
//            current.next = null;
//
//            --size; // Remember to decrease the size of the list when removing a node!
//
//        }
//    }
//    /////
//
    public void removeLast() throws NoSuchElementException {
        if (size == 0) {
            //If empty, throw a new exception to ensure there's no illegal actions performed.
            throw new NoSuchElementException("This list is empty!");
        } else if (size == 1) {
            //Removing from a list of size 1 is the same as clearing it, so this saves a bit of repetition.
            clear();
        } else {
            //Removing from the end of a singly linked list is a bit more involved, because we can't go backwards.
            //We need to traverse the list to find the second to last node and remove the tail from its perspective.
            //If this was a doubly linked list we could consistently do this faster by referring to tail.prev.
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }

            current.next = null;
            tail = current;
            --size;
        }
    }

    public Node get(int index) {

        if (size == 0) {
            throw new NoSuchElementException("This is empty!");

        } else if (index < 0 || index > size -1) {
            throw new IndexOutOfBoundsException("Index" + index + "for list of size" + size + "is out of bounds");

        } else if (index == 0) {
            return getFirst(); // retrieving getFirst Method.. method is retrieving - return head;

        } else if (index == size -1) {
            return getLast(); // retrieving getLast method

        } else {
            Node current = head; // setting current equal to head
            int i = 0;

            while (i != index) { /* While loops will loop through the code if the values are true and will stop when
                values are false */
                current = current.next; // this going through the list until the while loop finds a false statement
                ++i;
            }
            return current; // returning/getting false statement.
        }

    }

    public void add(int index, String data){
        if (index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException("Index " + index + " for list of size " + size + " is out of bounds");

        } else if (index == 0){
            addFirst(data);

        } else if (index == size ){ // (EDIT: removed the -1 from size because it doesn't add index to list correctly)
            addlast(data);

        } else {
            Node current = head;
            int i = 0;

            while (i != index -1) { // stopping one short so we can relink the list
                current = current.next;
                ++i;
            }
            current.next = new Node(data, current.next); /* skipping over the previous index and the newly added
             index */
            ++size;
        }

    }

    public void remove(int index) {
        if (size == 0){
            throw new NoSuchElementException("This list is empty");

        } else if (index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException("Index" + index + "for list of size" + size + "is out of bounds");

        } else if (index == 0){
            removeFirst();

        } else if (index == size -1){
            removeLast();

        } else {
            Node current = head;
            int i = 0;

            while (i != index -1) { // stopping one short so we can relink the list
                current = current.next; // skipping over the previous index and the newly added index
                ++i;
            }
            current.next = current.next.next;
            --size;
        }


    }

}
