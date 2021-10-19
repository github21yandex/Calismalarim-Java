package otopark;

public class Arac{

    private String sahipAdi;
    private String plaka;

    public Arac(String sahipAdi, String plaka){
        this.sahipAdi = sahipAdi;
        this.plaka = plaka;
    }

    public String getSahipAdi() {
        return sahipAdi;
    }

    public void setSahipAdi(String sahipAdi) {
        this.sahipAdi = sahipAdi;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    @Override
    public String toString() {
        return "Arac [plaka=" + plaka + ", sahipAdi=" + sahipAdi + "]";
    }
    

}