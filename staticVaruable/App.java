package staticVaruable;

class Mercedes{
    private String isim;
    static int standartLastikBasinci = 100;

    public Mercedes(String isim) {
        this.isim = isim;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public static int getStandartLastikBasinci() {
        return standartLastikBasinci;
    }

    public static void setStandartLastikBasinci(int standartLastikBasinci) {
        Mercedes.standartLastikBasinci = standartLastikBasinci;
    }

    @Override
    public String toString() {
        return "Mercedes [isim=" + isim + "    standartLastikBasinci="+ standartLastikBasinci+ "]";
    }

    

    

    
}



@SuppressWarnings("all")
public class App{
    
    public static void main(String[] args){
        Mercedes m1;
        Mercedes m2;

        

        m1 = new Mercedes("alinin");
        m2 = new Mercedes("velinin");

        System.out.println(m1);
        System.out.println(m2);
        System.out.println("");

        Mercedes.standartLastikBasinci = 200;

        System.out.println(m1);
        System.out.println(m2);
        System.out.println("");
        
        m1.setStandartLastikBasinci(300);  // Bu uyarıyı almamak için setStandartLastikBasinci() metodunun static tanımlamasını kaldırmak lazım
                                           // Ancak bu yapılmasada program çalışacaktır
        
        
        System.out.println(m1);
        System.out.println(m2);
        System.out.println("");

    }
}