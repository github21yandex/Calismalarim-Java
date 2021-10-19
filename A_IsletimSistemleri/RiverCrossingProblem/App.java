

package A_IsletimSistemleri.RiverCrossingProblem;

public class App {
    public static void main(String[] args) throws InterruptedException {
        
        // aşağıdaki iki değişken dördün katları olacak şekilde değiştirilebilir
        int numberOfHacker = 8;                                                    // yaratılacak hacker sayısı
        int numberOfSerfs  = 8;                                                    // yaratılacak serf sayısı

        Person [] hackers = new Hacker[numberOfHacker];                            // hacker adreslerini tutan dizi
        Person [] serfs   = new Serf[numberOfSerfs];                               // serf adreslerini tutan dizi

        Thread [] thrdHackers = new Thread[numberOfHacker];                        // Threadlerin adreslerini tutan diziler
        Thread [] thrdSerfs   = new Thread[numberOfSerfs];
        
        Semaphors smphrs = new Semaphors();                                        // Semaforları tutan sınıftan bir nesne yaratılır. bu sınıf içerisinde kullanılacak semaforlar bulunmaktadır.

        for (int i = 0; i < hackers.length ; i++) {                                //hacker ve serf lere bulunduğu dizi indisine göre isimler verilir
            thrdHackers[i] = new Thread( new Hacker( ("hacker_" + i), smphrs) );   //ve thread özellikli olarak yaratılırlar.
        }

        for (int i = 0; i < serfs.length ; i++) {
            thrdSerfs[i] = new Thread( new Serf( ("serf___" + i), smphrs) );
        }

        for (int i = 0; i < Math.max(serfs.length, hackers.length); i++) {          // thread ler başlatılır.
            if(i < hackers.length)
                thrdHackers[i].start();

            if(i < serfs.length)
                thrdSerfs[i].start();
        }

        for (int i = 0; i < Math.max(serfs.length, hackers.length); i++) {          // tüm thread lerin çalışması beklenir 
            if(i < hackers.length)
                thrdHackers[i].join();

            if(i < serfs.length)
                thrdSerfs[i].join();
        }

        System.out.println("Tüm Yolcular Tekneyle ayrıldı!!!\n\n"); 
        
                    
    }
}
