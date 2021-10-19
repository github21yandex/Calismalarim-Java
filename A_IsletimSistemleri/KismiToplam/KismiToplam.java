package A_IsletimSistemleri.KismiToplam;

//Onur ŞAHİN
//19253019
//15.11.2020





public class KismiToplam {
    public static void main(String[] args) throws InterruptedException {

        int threadNumber = 4;//değiştirilebilir                                        //toplam işlemi kaç thread e bölünecek seçilir
        int totalSum = 0;                                                               //array in tüm toplamını tutar
        int bruteForceSum = 0;                                                          //sağlama için yapılan toplama sonucunu tutar
        
        int[] array = new int[100000000];//değiştirilebilir                                  //Array kaç elemanlı olacak seçilir

        for (int i = 0; i < array.length; i++) {
            
            array[i] = (int)(Math.random()*100);
        }

        long time1 = System.nanoTime();

        for (int i = 0; i < array.length; i++) {                                        //sağlama amaçlı array toplanır
            bruteForceSum += array[i];
        }
        long time2 = System.nanoTime();

        System.out.println("Sağlama için bruteForceSum   = " + bruteForceSum);
        System.out.println( "toplam süre                 = " + (time2-time1) );

        Thread [] thrds = new Thread[threadNumber];

        Results rslts = new Results(thrds.length);                                      //tüm thread lerin sonucunun tutulacağı array objesi 
        
        long time3 = System.nanoTime();
        for (int i = 0; i < thrds.length; i++) {
            thrds[i] = new Thread(new Summation(array, i, rslts));                      //thread ler oluşturulur
                                                                                        //i     : thread numarası / indisi için kullanılacak
                                                                                        //rslts : herbir thread in sonucu kaydedilecek
        }

        for (int i = 0; i < thrds.length; i++) {
            thrds[i].start();                                                           //thread ler çalışmaya başlar
        }

       
        for (Thread thrd : thrds) {                                                     //her bir thread in sonlandığından emin olunur ve ana thread devam eder
            try {
                thrd.join();
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
        for (int rslt : rslts.getRsltsArray()) {                                        //rslts objesinde toplanan tüm thread sonuçları toplanır
            
            totalSum += rslt;                                                           //tüm thread lerin nihai toplamı elde edilir 
        }
        long time4 = System.nanoTime();

        System.out.println( "thread lerin sonucu totalSum = " + totalSum);
        System.out.println( "toplam süre                  = " + (time4-time3) );
    }
}

class Results{                                           //thread lerin sonucunun toplanacağı int[] array i içeren Results class ı

    private int[] rslts;                                 //threadlerin sonucu kaydedlir

    public Results(int length){
        this.rslts = new int[length];
    };

    public void setValue(int index, int value){
        rslts[index] = value;
    }

    public int[] getRsltsArray(){
        return rslts;
    }
}


class Summation implements Runnable{                         //thread leri oluşturan class

    private int subtotal = 0;                                //her thread in ara toplamını tutar

    private int[] array;
    private int index;                                       //thread id/index ini tutar
    private Results rslts;                                   //her thread in sonucunun kaydedileceği array in bulunduğu nesne

    public Summation(int[] array, int index, Results rslts){
        this.array = array;
        this.index = index;
        this.rslts = rslts;
    }


    @Override
    public void run(){
       
        double h = (double)array.length/(double)rslts.getRsltsArray().length;      //thread lerin array elemanlarını dengeli paylaşması için işlemler
        

        int firstIndex = (int)(  ((double)index) * h); 
        int finalIndex = (int)( (  (double)index + 1) * h ) - 1;
        
       
  
        for (int i = firstIndex; i <= finalIndex; i++) {                           //thread in payına düşen array elemanlarının toplanması
            
            subtotal += array[i];
        }

        rslts.setValue(index, subtotal);                                           //thread sonucunun rslts nesnesindeki array e kaydedilmesi
        
    }
}