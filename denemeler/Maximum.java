package denemeler;

public class Maximum {
    
    public static int maxBul(int[] dizi){
        int max = dizi[0];
        for (int i = 0; i < dizi.length; i++) {
            if(dizi[i]>max)
                max = dizi[i];
            
        }
        return max;
    }
}