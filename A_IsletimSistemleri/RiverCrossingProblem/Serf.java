

package A_IsletimSistemleri.RiverCrossingProblem;

public class Serf extends Person implements Runnable{

    public Serf(String ad, Semaphors smphrs) {
        super(ad, smphrs);
    }
    

    @Override
    public void run() { try {

        Thread.sleep( (int)(Math.random() * 10) );                  // her thread için rastgeleliği arttırır

        smphrs.mutex.acquire();                                     // aynı anda sadece bir threade izin verir

            smphrs.serfs++;                                         // hazırda bekleyen serf sayısı

            if(smphrs.serfs == 4){                                  // hacker sayısı dört ise şart sağlanmıştır daha fazla girişe izin verilmez.
                
                smphrs.serfQueue.release(4);                        // dördüncü giren şart sağlandığı için bekleyen serfleri serbest bırakır.
                smphrs.serfs = 0;                                   // hazırda bekleyen serflerin hepsi kullanıldığından, hazırda bekleyen sayısı sıfırlanır.
                isCaptain = true;                                   // dördüncü olarak giren thread captan olarak işaretlenir.
            }
            else if(smphrs.serfs == 2 && smphrs.hackers >= 2){      // şart sağlanmıştır daha fazla girişe izin verilmez son giren yine kaptandır.

                smphrs.serfQueue.release(2);                        // Dördüncü olarak giren kaptan serfQueue kuyruğundan iki serfi serbest bırakır.
                smphrs.hackerQueue.release(2);                      // Dördüncü olarak giren kaptan hackerQueue kuyruğundan iki serfi serbet bırakır
                smphrs.hackers -= 2;                                // Hazırda bekleyen hacker sayısı 2 azaltılır
                smphrs.serfs = 0;                                   // Hazırda bekleyen serflerin hepsi kullanıldığından hazırda bekleyen serf sayısı sıfırlanır.
                isCaptain = true;                                   // Dördüncü olarak giren kaptan olarak işaretlenir.
            }
            else{
                smphrs.mutex.release();                             // Şart sağlanmadığında bir threadin daha girmesine izin verilir.
            }                                                       // ve serfQueue kuyruğuna girilir.
        
        smphrs.serfQueue.acquire();                                 // Hazır hacker lar buradaki kuyrukta bekler son giren thread yukarıda if içersinde burayı serbest bırakabilir.
        
        System.out.println(ad + " Tekneye Bindi");
        Board();                                                    // Tüm thread ler Board fonksiyonuna başvurur.

        smphrs.barrier.acquire();                                   // Dört adet thread in geçmesine izin verir.

        if(this.isCaptain){                                         // Gelen thread captansa rowBoat fonksiyonunu çağırır

            Thread.sleep(1000);                                     // Gerekli değildir. Threadlerin teknelerde doğru bir şekilde gruplandığını gözlemleyebilmek için son thread ten sonra 1 sn bekleniyor.
            rowBoat();
            smphrs.barrier.release(4);                              // sonraki dörtlü için barrier i boşaltır.
            smphrs.mutex.release();                                 // sonraki dörtlünün başlaya bilmesi için ilk threadin geçmesini sağlar
        }                                                           // ve son thread de sonlanır.

    } catch (Exception e) {}

    }

    
    

}
