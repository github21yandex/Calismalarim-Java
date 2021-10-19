

package EDS;

import java.io.Serializable;


public class Ogrenci implements Serializable{


    private static final long serialVersionUID = 1L;
    
    public String ogrenciNo;
    public String ogrenciAd;
    public String ogrenciSoyad;
    public String ogrenciBolum;

    public Ogrenci(String ogrenciNo, String ogrenciAd, String ogrenciSoyad, String ogrenciBolum) {
        this.ogrenciNo = ogrenciNo;
        this.ogrenciAd = ogrenciAd;
        this.ogrenciSoyad = ogrenciSoyad;
        this.ogrenciBolum = ogrenciBolum;
    }

    public Ogrenci(Ogrenci obj){
        this.ogrenciNo = obj.getOgrenciNo();
        this.ogrenciAd = obj.getOgrenciAd();
        this.ogrenciSoyad = obj.getOgrenciSoyad();
        this.ogrenciBolum = obj.getOgrenciBolum();
    }

    public Ogrenci(){

    }

    public String getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(String ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    public String getOgrenciAd() {
        return ogrenciAd;
    }

    public void setOgrenciAd(String ogrenciAd) {
        this.ogrenciAd = ogrenciAd;
    }

    public String getOgrenciSoyad() {
        return ogrenciSoyad;
    }

    public void setOgrenciSoyad(String ogrenciSoyad) {
        this.ogrenciSoyad = ogrenciSoyad;
    }

    public String getOgrenciBolum() {
        return ogrenciBolum;
    }

    public void setOgrenciBolum(String ogrenciBolum) {
        this.ogrenciBolum = ogrenciBolum;
    }

    @Override
    public String toString() {
        return "[ogrenciAd=" + ogrenciAd + ", ogrenciSoyad=" + ogrenciSoyad + ", ogrenciBolum=" + ogrenciBolum + ", ogrenciNo=" + ogrenciNo + "]";
    }



    
    

    
}