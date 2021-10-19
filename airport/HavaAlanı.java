package airport;

public class HavaAlanı {

    private String ad;
    private String sehir;
    private int apronSayisi;
    private int kontuarSayisi;
    public static int count;


    public HavaAlanı(String ad, String sehir, int apronSayisi, int kontuarSayisi) {
        this.ad = ad;
        this.sehir = sehir;
        this.apronSayisi = apronSayisi;
        this.kontuarSayisi = kontuarSayisi;
        count++;
    }

    public HavaAlanı(String ad, String sehir) {
        this.ad = ad;
        this.sehir = sehir;
    }

    public HavaAlanı(HavaAlanı object){
        this.setAd(object.getAd());
        this.setSehir(object.getSehir());

        
    }



    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public int getApronSayisi() {
        return apronSayisi;
    }

    public void setApronSayisi(int apronSayisi) {
        this.apronSayisi = apronSayisi;
    }

    public int getKontuarSayisi() {
        return kontuarSayisi;
    }

    public void setKontuarSayisi(int kontuarSayisi) {
        this.kontuarSayisi = kontuarSayisi;
    }


    public String toString(){
        return "havalalanı:"+getAd()+"\nsehir:"+getSehir()+"\napron sayisi:"+getApronSayisi()+"\nkontuar sayisi:"+getKontuarSayisi();
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        HavaAlanı.count = count;
    }



}