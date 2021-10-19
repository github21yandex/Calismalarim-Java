package otopark;

public class App {
    
    public static void main(String[] args) {
        Arac aracObj1 = new Arac("onur","20oş11");
        Arac aracObj2 = new Arac("ayse","20oş12");
        Arac aracObj3 = new Arac("kazım","20oş13");
        Arac aracObj4 = new Arac("selim", "20oş14");
        Arac aracObj5 = new Arac("elif", "20oş15");
        Arac aracObj6 = new Arac("hayta", "20oş16");
        
        Otopark otoparkObj1 = new Otopark(5, 0.0, 10.0);

        otoparkObj1.parkEt(aracObj3);
        otoparkObj1.parkEt(aracObj5);
        otoparkObj1.parkEt(aracObj2);
        otoparkObj1.parkEt(aracObj1);
        otoparkObj1.parkEt(aracObj4);

        otoparkObj1.aracListele();

        otoparkObj1.parkEt(aracObj6);

        otoparkObj1.aracCikar(aracObj6);

        otoparkObj1.aracListele();

        
    }
}