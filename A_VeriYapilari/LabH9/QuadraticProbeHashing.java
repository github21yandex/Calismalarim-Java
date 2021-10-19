package A_VeriYapilari.LabH9;

public class QuadraticProbeHashing<T> {
    public HashEntry<T>[] dizi;
    public int elemanSayisi;


    @SuppressWarnings("unchecked")
    public QuadraticProbeHashing() {
        dizi=new HashEntry[23];
    }

    @SuppressWarnings("unchecked")
    public QuadraticProbeHashing(int boyut){
        dizi=new HashEntry[boyut];
    }
    public int hash(T deger) {
        return deger.hashCode()%dizi.length;
    }

    public void ekle(T eleman){
        
        
        int konum = hash(eleman);
        int i = 1;
        
        while(true){
            if(dizi[konum] == null){
                dizi[konum] = new HashEntry<T>(eleman);
                break;
            }
            else{

                if(dizi[konum].isActive == true){
                    konum = (konum - (i-1)*(i-1) + i*i ) % dizi.length;
                    i++;
                    continue;
                }

                dizi[konum].value = eleman;
                dizi[konum].isActive = true;
                break;

            }
        }
        
        
        
    }

    public boolean sil(T eleman){

        int konum = hash(eleman);

        for (int i = 1; i < dizi.length; i++) {
            
            if(dizi[konum] == null){
                 return false;
            }
            else{
                if(dizi[konum].value.equals(eleman) && dizi[konum].isActive == true){//generic bir deger primitive olsa bile asla == ile karşılaştırılmamalı equals kullanılmalı.
                    dizi[konum].isActive = false;
                    return true;
                }
                else{
                    konum = (konum - (i-1)*(i-1) + i*i ) % dizi.length;
                    continue;
                }
            }
        }

        return false;



    }

}
