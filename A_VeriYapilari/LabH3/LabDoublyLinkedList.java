package A_VeriYapilari.LabH3;

public class LabDoublyLinkedList<T> extends DoublyLinkedList<T> {
    /**
     * Çift bağlı listenin istenilen konumuna eleman ekler
     * 
     * @param index konum
     * @param value eklenecek eleman
     */
    @Override
    public void insertAt(int index, T value) {
        if(index > size() || index < 0){

            throw new RuntimeException("OutOfIndex");
        }

        Node<T> node = new Node<T>(value, null, null);

        if (index == 0) {
            addFirst(value);
        }
         else if (  index == (size())  ){
            addLast(value);
         }
        else {
            
            node.next = getHead().next;

            for (int i = 0; i < index-1; i++) {
                node.next = node.next.next;
            }

            node.previous = (node.next).previous;
            (node.previous).next = node;
            (node.next).previous = node;
            setSize( size() + 1 );
        }

    }

    /**
     * Verilen konumdaki elemanı siler
     * 
     * @param index silinecek elemanın konumu
     * @return silinen değer
     */
    @Override
    public T removeAt(int index) {
        if(index < 0 || index >= size()){
            throw new RuntimeException("OutOfIndex");
        }
       
        if (index == 0){
            return removeFirst();
        }
        
        if(index == (size()-1)){
            return removeLast();
        }
        
        Node<T> node = new Node<>(null, null, null);

        node = getHead();
       
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        
            (node.previous).next = node.next;
            (node.next).previous = node.previous;
            setSize( size() - 1 );
        
        return node.value;
    }
}
