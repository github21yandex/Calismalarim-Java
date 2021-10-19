package denemeler;

public class Arry{
    public static void main(String[] args){

        int [] dizi1 = new int [5];
        dizi1[0] = 0;

        int [] dizi2;
        dizi2 = new int [7];


        final int length = 5;
        int length2 = 6;

        int [] dizi3 = new int [length];
        dizi3[0] = 0;

        int [] dizi4 = new int [length2];
        
        dizi2[0] = 11;

        for (int i = 0; i < dizi4.length; i++) {
            dizi4[i] = i;
            System.out.println(dizi4[i]);          
        }
        System.out.println();

        modifyElement(dizi4);
        for (int i = 0; i < dizi4.length; i++) {
            System.out.println(dizi4[i]);          
        }
        System.out.println();

        modifyElement(dizi4[1]);

        for (int i = 0; i < dizi4.length; i++) {

            System.out.println(dizi4[i]);          
        }
        System.out.println();
        System.out.println("-----------------------");  

        
    }

    private static void modifyElement(int [] array){
        
        //verilen listede değişiklik olmasını istemiyorsam:
        int [] temp = new int [array.length];

        // temp = array; 
        // temp[3] = 3333;

        //yukarıdaki işe yaramaz array[3] elemanının değeri de 3333 olur
        //aşağıdaki işe yarar:

        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        
        temp[3] = 555;


    }

    private static void modifyElement(int element){
        element = 111;
    }
    



}