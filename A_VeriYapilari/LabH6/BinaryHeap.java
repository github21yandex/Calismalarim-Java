package A_VeriYapilari.LabH6;

/**
 * Minimum heap sınıfı
 * 
 * @param <T> Generic sınıf
 */
public class BinaryHeap<T extends Comparable<T>> {
    public T[]  dizi;//Yığını tutacak dizi(değiştirmeyin)
    public int es;//Eleman sayısı(değiştirmeyin)
    @SuppressWarnings("unchecked")
    public BinaryHeap() {//değiştirmeyin
        dizi=(T[]) new Comparable[100];
    }
    @SuppressWarnings("unchecked")
    public BinaryHeap(int boyut){//değiştirmeyin
        dizi=(T[])new Comparable[boyut];
    }
    public int ebeveyn(int konum){ return konum/2;}//değiştirmeyin, kullanın
    public int solCocuk(int konum){ return 2*konum;}//değiştirmeyin, kullanın
    public int sagCocuk(int konum){return 2*konum+1;}//değiştirmeyin, kullanın
    public int elemanSayisi(){return es;}

    public void ekle(T eleman){

        dizi[es+1] = eleman;
        es++;
        print();
        if(es == 1){return;}

        int i = es;
        T temp;
        
        while( i != 1 && dizi[i].compareTo(dizi[ebeveyn(i)] ) < 0){
            temp = dizi[i];
            dizi[i] = dizi[ebeveyn(i)];
            dizi[ebeveyn(i)] = temp;
            i = ebeveyn(i);
            print();
            
        }

        print();
    }

    public T sil(){
        
        T temp;
        int i;

        T silinen = dizi[1];
        dizi[1] = dizi[es];
        es--;

        i = 1;

        while( i <= es ){

            if(solCocuk(i) > es){
                return silinen;
            }
            else if(sagCocuk(i) > es){

                if(dizi[solCocuk(i)].compareTo(dizi[i]) < 0){
                    temp = dizi[i];
                    dizi[i] = dizi[solCocuk(i)];
                    dizi[solCocuk(i)] = temp;
                    i = solCocuk(i);
                }
                else{
                    return silinen;
                }

            }
            else{

                if (  dizi[solCocuk(i)].compareTo(dizi[sagCocuk(i)]) < 0){

                    if(dizi[solCocuk(i)].compareTo(dizi[i]) < 0){
                        temp = dizi[i];
                        dizi[i] = dizi[solCocuk(i)];
                        dizi[solCocuk(i)] = temp;
                        i = solCocuk(i);
                    }
                    else{
                        return silinen;
                    }
                    
                }
                else{
                    
                    if(dizi[sagCocuk(i)].compareTo(dizi[i]) < 0){
                        temp = dizi[i];
                        dizi[i] = dizi[sagCocuk(i)];
                        dizi[sagCocuk(i)] = temp;
                        i = sagCocuk(i);
                    }
                    else{
                        return silinen;
                    }
                    
                }

            }

        }//while sonu


        return silinen;
    }

    public void print(){

        for (int i = 1; i <= es; i++) {
            System.out.printf("%d ", dizi[i]);
        }
        System.out.println();
    }
}
