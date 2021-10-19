package A_IsletimSistemleri.OgrenciP1P2;

import java.io.Serializable;

/**
 * H2P2Ogrenci
 */
public class H2P2Ogrenci implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    public String ogrenciNo;
    public String ogrenciAd;
    public String ogrenciSoyad;
    public String ogrenciBolum;

    public H2P2Ogrenci(String ogrenciNo, String ogrenciAd, String ogrenciSoyad, String ogrenciBolum) {
        this.ogrenciNo = ogrenciNo;
        this.ogrenciAd = ogrenciAd;
        this.ogrenciSoyad = ogrenciSoyad;
        this.ogrenciBolum = ogrenciBolum;
    }

    public H2P2Ogrenci(H2P2Ogrenci obj){
        this.ogrenciNo = obj.getOgrenciNo();
        this.ogrenciAd = obj.getOgrenciAd();
        this.ogrenciSoyad = obj.getOgrenciSoyad();
        this.ogrenciBolum = obj.getOgrenciBolum();
    }

    public H2P2Ogrenci(){

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