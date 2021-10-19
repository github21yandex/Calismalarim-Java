package otopark;

public class Otopark{

    private final int kapasite;
    private double toplamKazanc;
    private Arac [] araclar;
    private double ucret;

    public Otopark(int kapasite, double toplamKazanc, double ucret) {
        this.kapasite = kapasite;
        this.toplamKazanc = toplamKazanc;
        this.ucret = ucret;
        araclar = new Arac[kapasite];
    }

    public Otopark(Otopark otoparkOBJ){
        this.kapasite = otoparkOBJ.kapasite;
        this.toplamKazanc = otoparkOBJ.toplamKazanc;
        this.ucret = otoparkOBJ.ucret;
        //this.araclar = otoparkOBJ.araclar;
        //this.araclar[0] = null
        for (int i = 0; i < otoparkOBJ.kapasite; i++) {
            araclar[i] = new Arac(otoparkOBJ.araclar[i].getSahipAdi(), otoparkOBJ.araclar[i].getSahipAdi());
        }
    }

   

    public int getKapasite() {
        return kapasite;
    }

    public double getToplamKazanc() {
        return toplamKazanc;
    }

    public void setToplamKazanc(double toplamKazanc) {
        this.toplamKazanc = toplamKazanc;
    }

    public Arac[] getAraclar() {
        return araclar;
    }

    public void setAraclar(Arac[] araclar) {
        this.araclar = araclar;
    }

    public double getUcret() {
        return ucret;
    }

    public void setUcret(double ucret) {
        this.ucret = ucret;
    }

    public void parkEt(Arac aracObj){

        boolean park = false;

        for (int i = 0; i < kapasite; i++) {

            if(araclar[i] == null){
                araclar[i] = aracObj;
                park = true;
                System.out.println(aracObj.getPlaka() + " plakalı aracınız "+i+" nolu alana park etmiştir");
                break;
            }
        }

        if(park == false){
            System.out.println("otopark dolu");
        }


    }

    public void aracCikar(Arac aracObj){

        int i;

        for (i = 0; i < kapasite; i++) {

            if(araclar[i] != null && araclar[i].getPlaka() == aracObj.getPlaka()){

                System.out.println(aracObj+"park yerinden cıkarılmıstir");
                araclar[i] = null;
                this.toplamKazanc+=this.ucret;

                break;
            }
            
        }
        if(i == kapasite){
            System.out.println("Aracınız otaporkta değildir");
        }
    }

    public void aracListele(){
        for (int i = 0; i < kapasite; i++) {
            if(araclar[i] != null){
                System.out.println(i + "- " + araclar[i]);
            }
        }
    }
}