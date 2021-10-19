package Corona;

import java.util.Random;

import java.util.ArrayList;
public class App {

    

    public static void main(String[] args) {

        final int insanSayisi = 1000;
        final int olaySayisi = 1000;
        final int virusSayisi = 100;

        Random random = new Random();
        
        ArrayList <Insan> insan = new ArrayList<Insan>();
     
        for (int i = 0; i < insanSayisi; i++) {
            String isim = "insan";
            isim = isim + Integer.toString(i);
            Insan obj = new Insan(isim);
            insan.add( obj );
            
        }

        for (int i = 0; i < insan.size(); i++) {
            System.out.println(insan.get(i));
        }

        
        ArrayList <Virus> virus = new ArrayList<Virus>();
     
        for (int i = 0; i < virusSayisi; i++) {
            String isim = "virus";
            isim = isim + Integer.toString(i);
            ////buraya dikkat//////////////////////////////////////////
            Virus obj = new Virus(isim, random.nextInt(100) + 1, random.nextInt(100)+1);
            virus.add( obj );
        }

        for (int i = 0; i < virus.size(); i++) {
            System.out.println(virus.get(i));
        }
        
        for (int i = 0; i < olaySayisi; i++) {
            insan.get(random.nextInt(insanSayisi)).hastalikBulastir(virus.get(random.nextInt(virusSayisi)));
        }
        
        for (int i = 0; i < insanSayisi; i++) {
            if( insan.get(i).iyiles() ){
                insan.get(i).setHastalikDurum(false);
            }
        }

        for (int i = 0; i < insan.size(); i++) {
            System.out.println(insan.get(i));
        }

        Insan [] insan1 = new Insan[insanSayisi];
        
        for (int i = 0; i < insan1.length; i++) {
            insan1[i] = insan.get(i);
        }

        Test test = new Test();
        test.hastaListesi(insan1);

    

    }
}

