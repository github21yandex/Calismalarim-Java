package notHistogram;

//package Java.notHistogram;

import java.util.Arrays;

public class Not{
    public static void main(String[] args){

        int [] frq = new int [10];
        int maxFrq;

        int [] notlar = {1,0,4,5,11,13,16,17,23,25,31,35,46,47,48,54,67,73,77,88,99};

        for (int i = 0; i < notlar.length; i++  ){
            frq[notlar[i]/10]++;
        }

        maxFrq = Arrays.stream(frq).max().getAsInt();

        System.out.printf("max = %d\n\n", maxFrq);
        
        for (int i = maxFrq; i >= 0 ; i--){

            for(int j = 0; j < 10; j++){

                if (frq[j] >= i){
                    if(i == 0){
                        System.out.printf("%2d ", 10*j);
                    }
                    else{
                        System.out.print(" * ");
                    }
                                        
                }                    
                else{
                    System.out.print("   ");
                }
            }
            System.out.print("\n");
        }

        for (int i = 0; i < notlar.length; i++) {
            
        }

    }
}