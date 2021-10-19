package A_IsletimSistemleri.Driver;

class MutableInteger {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class Smmation implements Runnable {

    private int upper;
    private MutableInteger sumValue;

    public Smmation(int upper, MutableInteger sumValue) {
        this.upper = upper;
        this.sumValue = sumValue;
    }

    @Override
    public void run() {
        int sum = 0;

        for (int i = 0; i <= upper; i++) {
            try {
                Thread.sleep(1);;
                } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum += i;
            sumValue.setValue(sum);
        }
        //sumValue.setValue(sum);
    }
    
}

public class Driver{
    public static void main(String[] args) throws InterruptedException {
        if(args.length > 0){
            if(Integer.parseInt(args[0]) < 0){
                System.err.println(args[0] + " must be >= 0");
            }
            else{
                MutableInteger sum = new MutableInteger();
                int upper = Integer.parseInt(args[0]);
                Thread thrd = new Thread(new Smmation(upper, sum));
                thrd.start();

                while (thrd.isAlive()) {
                    Thread.sleep(500);
                    System.out.println("sum is :" + sum.getValue());
                }

                try{
                    thrd.join();
                    System.out.println("The sum of "+upper+" is "+sum.getValue());
                }
                catch(InterruptedException ie){
                    System.out.println(ie);
                }
            }
        }
        else{
            System.out.println("Usage: summation <integer value>");
        }
    }
}