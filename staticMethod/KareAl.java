package staticMethod;

public class KareAl{

    //Bu method kullanılmadan önce de mutlaka KareAl sınıfından bir nesne oluşturulmalıdır.
    //KareAl karesi = new KareAl;
    //int K = KareAl.kareAlNesneMethod(5)

    

    public int kareAlNesneMethod(int Y){

        return Y*Y;
    }



    //yukarıdan bağımsız olarak,
    //nesne oluşturmadan kare alma işlemi yapan static method aşağıdadır
    //kullanmak için sadece " KareAl.kareAlStaticMethod(5) " yazmak yeterlidir
    //bu kullanım 25 sonucunu döndürecektir.

    public static int kareAlStaticMethod(int X){
        return X*X;
    }

    
}