public class DemoLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst("1");
        list.addlast("35");
        list.printList();

        list.addFirst("2");
        list.printList();

        list.add(2,"3");
        list.printList();

        System.out.println(list.get(3).data);
        System.out.println(list.get(2).data);
        list.remove(0);
        list.printList();

        list.remove(2);
        list.printList();

    }
}
