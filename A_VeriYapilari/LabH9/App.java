package A_VeriYapilari.LabH9;

import java.util.Stack;

public class App {
    public static void main(String[] args) {
        QuadraticProbeHashing<Integer> q = new QuadraticProbeHashing<Integer>();
        int [] dizi = {155, 23, 102, 151, 43, 245, 179, 181, 47, 106, 23};
        for (int i : dizi) {
            q.ekle(i);
        }

        for (HashEntry<Integer> i : q.dizi) {
            if(i == null)
                System.out.printf("null ");
            else
                System.out.printf("%4d ",i.value);
        }
        System.out.println("");

        for (HashEntry<Integer> i : q.dizi) {
            if(i == null)
                System.out.printf("null ");
            else{
                if(i.isActive == true)
                    System.out.printf(" tru ");
                if(i.isActive == false)
                    System.out.printf(" fls ");
            }
        }
        System.out.println("\n");

         //for (int i : dizi) {
            // q.sil(i);
         //}

        q.sil(151);

        for (HashEntry<Integer> i : q.dizi) {
            if(i == null)
                System.out.printf("null ");
            else
                System.out.printf("%4d ",i.value);
        }
        System.out.println("");

        for (HashEntry<Integer> i : q.dizi) {
            if(i == null)
                System.out.printf("null ");
            else{
                if(i.isActive == true)
                    System.out.printf(" tru ");
                if(i.isActive == false)
                    System.out.printf(" fls ");
            }
        }
        System.out.println("\n\n");


        int konum = q.hash(151);

        Stack<Integer> indx = new Stack<Integer>();
        //indx.add(konum);
        for (int i = 0; i < q.dizi.length*10; i++) {
            //System.out.printf("%4d ",konum);
            if(indx.indexOf(konum) == -1){
                indx.add(konum);
            }
            konum = (konum - (i-1)*(i-1) + i*i ) % q.dizi.length;
        }

        System.out.println("\n\n");

        for (Integer integer : indx) {
            System.out.printf("%4d ", integer);
        }

        System.out.println("\n\n");



    }
}
