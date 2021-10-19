package A_VeriYapilari.LabH6;

public class App {
    public static void main(String[] args) {
        BinaryHeap<Integer> heap = new BinaryHeap<>();

        // heap.ekle(1);
        // heap.ekle(2);
        // heap.ekle(3);
        // heap.ekle(4);
        // heap.ekle(5);
        // heap.ekle(6);

        // heap.print();

        // heap.sil();
        // heap.print();

        int [] eleman = {70, 23, 92, 60, 60, 4, 36, 70, 12, 36};  
        
        for (int i : eleman) {
            heap.ekle(i);
        }

        heap.print();

        heap.sil();
        heap.sil();
        heap.sil();
    }
}
