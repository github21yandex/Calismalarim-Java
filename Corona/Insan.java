package Corona;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;

public class Insan{
    
    private String ad;
    private Virus kVirus;
    private double iyilesmeOrani;
    private boolean hastalikDurum;
    
    
    public String getAd() {
        return ad;
    }

    public Virus getkVirus() {
        return kVirus;
    }

    public boolean getHastalikDurum() {
        return hastalikDurum;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public void setkVirus(Virus kVirus) {
        this.kVirus = kVirus;
    }

    public void setHastalikDurum(boolean hastalikDurum) {
        this.hastalikDurum = hastalikDurum;
    }
    
    public double getIyilesmeOrani() {
        return iyilesmeOrani;
    }
        
    public void setIyilesmeOrani(double iyilesmeOrani) {
        this.iyilesmeOrani = iyilesmeOrani;
    }
    
    public Insan (String ad){
        this.ad = ad;
    }
    
    public Virus hastalikKap(Virus [] dizi){
        
        Random random = new Random();
        //bu noktadan itibaren viruslerin bulaşma oranına göre insanlara bulaşması
        //için Virus [] dizi nin tüm bulaşma oranları toplanır. random sayi
        //üretme işlemi 0 ile toplamBulasOran arasinda bir skalada sayi üretilir.
        //bu üretilen sayi skalada denk geldiği nokta bulunur. Bu noktaya denk 
        //gelen virüs seçilen virüstür.
        
        double toplamBulasmaOrani = 0;
        double toplam1 = 0;
        double toplam2 = 0;
        int secim = 0;

        for (int i = 0; i < dizi.length; i++) {
            
            toplamBulasmaOrani += dizi[i].getBulasOran();
        }

        double rastgeleSayi = random.nextDouble()*toplamBulasmaOrani;

        for (int i = 0; i < dizi.length; i++) {
            
            toplam1 += dizi[i].getBulasOran();
            
            if(i+1 != dizi.length){
                
                 toplam2 = toplam1 + dizi[i + 1].getBulasOran();
            }
        
            if (rastgeleSayi <= toplam1){
                
                secim = i;
                
                break;
                
            }else if (rastgeleSayi > toplam1 && rastgeleSayi < toplam2){
                
                secim = i+1;
                
            }else{
                continue;
            }
            
        }

        return dizi[secim];
    }
    
    
    public boolean hastalikBulastir(Virus obj)
    {
        if(this.hastalikDurum == false){
            
            this.hastalikDurum = true;
            
            this.kVirus = obj;
            
            return true;
        }
    
        return false;
    } 
    
    public boolean iyiles(){
        
        Random random = new Random();
        
        double hesaplananOran =  random.nextInt(101);
        
        if(this.hastalikDurum == true){
            
            if ( hesaplananOran > this.kVirus.getIyilesmeOran() ){
            
            return true;
            }        
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        return "Insan [ad=" + ad + ", hastalikDurum=" + hastalikDurum + ", iyilesmeOrani=" + iyilesmeOrani + ", kVirus="
                + kVirus + "]";
    }
    
   
    
}
