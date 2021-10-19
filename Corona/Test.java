package Corona;
import java.util.ArrayList;


public class Test {
    
       public ArrayList <Virus> hastaListesi(Insan [] dizi){
        
        for (Insan insan : dizi) {
            
            System.out.println(insan.toString());
        }

        ArrayList <Virus> hastaListesi = new ArrayList<Virus>();
    
        
        for (int i = 0; i < dizi.length; i++) {
            
            if(dizi[i].getHastalikDurum() == true){
                
                if( hastaListesi.contains( dizi[i].getkVirus() ) ){
                    continue;
                }
                
                hastaListesi.add(  dizi[i].getkVirus()  );
            }
            
        }
        
        
        return hastaListesi;
    }
    
    
    public double virusOrtalamaIyilesmeOrani(Insan []dizi, Virus v){

        double toplamHasta = 0;
        double toplamIyilesmeOrani = 0;
    
        
        for (Insan insan : dizi) {
            
            if(insan.getkVirus() != null){
                
                if(insan.getkVirus().equals(v)){
                    
                    toplamIyilesmeOrani += insan.getIyilesmeOrani();
                    
                    toplamHasta++;
                }
            }
        }
        
        
        return toplamIyilesmeOrani / toplamHasta;
        
    }
    
    public double virusBulasmaOrani(Insan[] dizi, Virus v){

        double toplam = 0;

        for (Insan insan : dizi) {
            
            if(insan.getkVirus() != null){
                
                if(insan.getkVirus().getVirusAd().equals(v.getVirusAd())){
                    
                    toplam++;
                }
            }
        }

        return toplam / dizi.length;
    }
        
    }
            