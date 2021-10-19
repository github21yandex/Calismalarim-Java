package insan;

public class Insan{

    private String userName;
    private int dogumYili;
    private int yas;

    public void setName(String userName){

        this.userName = userName;
        
    }
    public String getName(){
        return userName;
    }

    public void setDogumYili(int dogumYili){

        this.dogumYili = dogumYili;
    }

    public void setYas(int yil){

        this.yas = yil - dogumYili;
    }

    public int getYas(){
        return yas;
    }

    public int getMaxAtis(){
        return 220 - yas;
    }

    public int getIdealAtis(){
       return getMaxAtis()/2;
    }



}