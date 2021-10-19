package Generics;

class Box<T>{

    private T t;

    public void add(T t){
        this.t = t;
    }

    public T get(){
        return t;
    }

}

public class GenericClass {
    public static void main(String[] args) {
        int [] array = {1, 2, 3, 4, 5};

        Box<Integer> boxInteger = new Box<Integer>();
        Box<Double> boxDouble = new Box<Double>();
        Box< int [] > boxIntArray = new Box< int []>();

        boxInteger.add(2);
        boxDouble.add(2.2);
        boxIntArray.add(array);

        System.out.println(boxInteger.get());
        System.out.println(boxDouble.get());
        System.out.println(boxIntArray);

        for (int i : boxIntArray.get()) {
            System.out.println(i);
        }
        
    }    
}


