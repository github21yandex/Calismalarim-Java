

package A_IsletimSistemleri.RiverCrossingProblem;

public class Hacker extends Person implements Runnable {

    public Hacker(String ad, Semaphors smphrs) {
        super(ad, smphrs);
    }

    @Override
    public void run() {try {

        Thread.sleep( (int)(Math.random() * 10) );                   // her thread için rastgeleliği arttırır
        
        smphrs.mutex.acquire();                                      // aynı anda sadece bir threade izin verir

            smphrs.hackers++;                                        // hazırda bekleyen hacker sayısı

            if(smphrs.hackers == 4){                                 // hacker sayısı dört ise şart sağlanmıştır daha fazla girişe izin verilmez.
                                                                
                smphrs.hackerQueue.release(4);                       // dördüncü giren şart sağlandığı için bekleyen hackerları serbest bırakır.
                smphrs.hackers = 0;                                  // hazırda bekleyen hackerların hepsi kullanıldığından, hazırda bekleyen sayısı sıfırlanır.
                isCaptain = true;                                    // dördüncü olarak giren thread captan olarak işaretlenir.
            }

            else if(smphrs.hackers == 2 && smphrs.serfs >= 2){       // şart sağlanmıştır daha fazla girişe izin verilmez son giren yine kaptandır.
                smphrs.hackerQueue.release(2);                       // Dördüncü olarak giren kaptan hackerQueue kuyruğundan iki serfi serbest bırakır. 
                smphrs.serfQueue.release(2);                         // Dördüncü olarak giren kaptan serfQueue kuyruğundan iki serfi serbet bırakır
                smphrs.serfs -= 2;                                   // Hazırda bekleyen serf sayısı 2 azaltılır
                smphrs.hackers = 0;                                  // Hazırda bekleyen hackerların hepsi kullanıldığından hazırda bekleyen hacker sayısı 0 yapılır.
                isCaptain = true;                                    // Dördüncü olarak giren kaptan olarak işaretlenir.
            }
            else{
                smphrs.mutex.release();                              // Şart sağlanmadığında bir threadin daha girmesine izin verilir.
            }                                                        // ve hackerQueue kuyruğuna girilir.

        smphrs.hackerQueue.acquire();                                // Hazır hacker lar buradaki kuyrukta bekler son giren thread yukarıda if içersinde burayı serbest bırakabilir.                               

        System.out.println(ad + " Tekneye Bindi");                   

        Board();                                                     // Tüm thread ler Board fonksiyonuna başvurur.

        smphrs.barrier.acquire();                                    // Dört adet thread in geçmesine izin verir.

        if( this.isCaptain ){                                        // Gelen thread captansa rowBoat fonksiyonunu çağırır

            Thread.sleep(1000);                                      // Gerekli değildir. Threadlerin teknelerde doğru bir şekilde gruplandığını gözlemleyebilmek için son thread ten sonra 1 sn bekleniyor.
            rowBoat();                          
            smphrs.barrier.release(4);                               // sonraki dörtlü için barrier i boşaltır.
            smphrs.mutex.release();                                  // sonraki dörtlünün başlaya bilmesi için ilk threadin geçmesini sağlar ve son thread de sonlanır.
        }

    } catch (Exception e) {}
        
    }
   
    
}
