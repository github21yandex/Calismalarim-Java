package A_VeriYapilari.LabH8;

import java.util.LinkedList;

public class SeperatedChainHash {
    public LinkedList<Integer>[] dizi;

    @SuppressWarnings("unchecked")
    public SeperatedChainHash() {
        //içerği değiştirmeyin
        dizi=new LinkedList[23];
    }

    @SuppressWarnings("unchecked")
    public SeperatedChainHash(int boyut) {
        //içerği değiştirmeyin
        dizi=new LinkedList[boyut];
    }
    public int hash(int deger){
        //içerği değiştirmeyin
        return deger%dizi.length;
    }
    public void ekle(int deger){
        
        int konum = hash(deger);
            
        if(dizi[konum] == null){
            dizi[konum] = new LinkedList<Integer>();
            dizi[konum].add(deger);
        }
        else{
            dizi[konum].add(deger);
        }
    
        
        
    }
    public boolean sil(int deger){
        
        int konum = hash(deger);
        
        int index = dizi[konum].indexOf(deger);

        if(index == -1){
            return false;
        }
            
        dizi[konum].remove(index);

        return true;    
    }


    public void yenidenOzetle() {
        int yeniBoyut = dizi.length * 2;
        

        for (int i = yeniBoyut; ; i++) {
            boolean flag = true;
            for (int j = 2; j < yeniBoyut; j++) {
                if(i % j == 0){
                    flag = false;
                    break;
                }
            }
            if (flag == true){
                yeniBoyut = i;
                break;
            }  
        }

        SeperatedChainHash sch = new SeperatedChainHash(yeniBoyut);

        for (LinkedList<Integer> linkedList : dizi) {
            if (linkedList == null)
                continue;
            for (Integer deger : linkedList) {
                sch.ekle(deger);
            }
        }

        this.dizi = sch.dizi;
        
    }


    
}


class App{
    public static void main(String[] args) {

        SeperatedChainHash sch = new SeperatedChainHash();

        sch.dizi[3] = new LinkedList<Integer>();
        sch.dizi[3].add(55);
        for (int i = 0; i < sch.dizi.length; i++) {
            System.out.println(sch.dizi[i]);
        }
        System.out.println(sch.dizi[3].indexOf(55));


        sch.yenidenOzetle();

        
    }
}
