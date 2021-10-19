package Generics;

public class GenericMethod {

    public static <E> void printArray(E[] array) {
        for (E e : array) {
            System.out.println(e);
        }
    }

    
    
    public static void main(String[] args) {
        Integer [] integers = {1, 2, 3, 4, 5};
        Double [] doubles = {1.1, 1.2, 1.3, 1.4, 1.5};
        Character[] characters = {'a','b','c','d','e'};


        GenericMethod.printArray(integers);
        GenericMethod.printArray(doubles);
        GenericMethod.printArray(characters);
    }
}
