package A_VeriYapilari.LabH3;


public class App {
    public static void main(String[] args) {
        
        LabDoublyLinkedList<Integer> ll = new LabDoublyLinkedList<>(); 
        
        // ll.addLast(0);
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(3);

        ll.insertAt(0,1);
        ll.insertAt(0,5);
        ll.insertAt(1,4);
        ll.print();         //Test et: Listedeki elemanlar 5,4,1 olmalı

        ll.insertAt(3,7);
        ll.insertAt(3,8);
        ll.print();         //Test et: Listedeki elemanlar 5,4,1,8,7 olmalı
        
        for (int i = ll.size(); i > 0; i--) {
            ll.removeFirst();
        }
        for (int i = 1; i <= 6 ; i++) {
            ll.addLast(i);
        }

        ll.print();
        
        ll.removeAt(0);
        ll.removeAt(4);
        ll.removeAt(2);
        ll.print();         //Test et: Listedeki elemanlar 2,3,5 olmalı
        
        ll.removeAt(0);
        ll.removeAt(0);
        ll.removeAt(0);
        ll.print();         //Test et: Liste boş olmalı

    }
}
