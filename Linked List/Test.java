public class Test {
    public static void main(String[] args){
        LinkedListImp<String> SLL = new LinkedListImp<String>();

       SLL.pushFront("Stephen Curry");
        SLL.pushFront("Kevin Durant");
        SLL.pushBack("Lebron James");
        SLL.pushBack("James Harden");
        System.out.println(SLL.valueAtIndex(1));
        SLL.printList();
        SLL.reverseList();
        SLL.printList();
        System.out.println(SLL.size());
        SLL.deleteAtIndex(1);
        SLL.printList();
        System.out.println(SLL.size());

    }
}

