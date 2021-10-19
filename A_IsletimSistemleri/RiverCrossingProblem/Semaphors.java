

package A_IsletimSistemleri.RiverCrossingProblem;

import java.util.concurrent.Semaphore;

public class Semaphors {

    public Semaphore mutex       = new Semaphore(1);       // kullanılacak semaforlar
    public Semaphore barrier     = new Semaphore(4);
    public Semaphore hackerQueue = new Semaphore(0);
    public Semaphore serfQueue   = new Semaphore(0);

    public int hackers = 0;                                // hazırda bekleyen hacker sayısı
    public int serfs   = 0;                                // hazırda bekleyen serf sayısı

}
