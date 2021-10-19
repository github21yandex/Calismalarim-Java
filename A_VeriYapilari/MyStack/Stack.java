package A_VeriYapilari.MyStack;

class MyStack <T>{
    private T[] dizi ;
    private int  es;

    @SuppressWarnings("unchecked")
    public MyStack(){
        
        dizi   = (T[]) new Object[10];
        es = 0;        
    }

    @SuppressWarnings("unchecked")
    public MyStack(int length){
        dizi = (T[]) new Object[length];
    }

    public void push(T eleman){
        if(dizi.length == es){
            System.out.println("stackoverflow");
        }
        else{
            dizi[es++] = eleman;
            //es++;
        }
    }

    public T pop(){
        if(es == 0){
           throw new RuntimeException("stack underflow");
        }
        return dizi[--es];
    }

    public void print(){
        for (int i = 0; i < es; i++) {
            System.out.println(dizi[i]);
        }
    }

    public T peak(){
        if(es == 0){
            throw new RuntimeException("stack underflow");
        }

        return dizi[es-1];
    }


    

    
}

public class Stack{
    public static void main(String[] args) {
        MyStack<Double> myStack = new MyStack<Double>(10);

        myStack.push(2.2);
        myStack.push(3.3);
        myStack.push(4.4);
        myStack.push(5.5);
        myStack.print();

        myStack.pop();
        myStack.print();

        myStack.peak();

    }
}
