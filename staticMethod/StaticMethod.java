package staticMethod;

public class StaticMethod{

    public static void main(String[] args){
        int M = 7;
        
        //nesne oluşturmadan static metod ile
        System.out.println("M 'nin karesi = " + KareAl.kareAlStaticMethod(M));


        //nesne oluşturarak static olmayan method ile

        KareAl karesi = new KareAl(); //KareAl sınıfından karesi nesnesi oluşturuldu

        System.out.println("M 'nin karesi = " + karesi.kareAlNesneMethod(M));
    }


}