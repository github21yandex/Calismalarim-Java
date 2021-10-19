package insan;

import java.util.Scanner;

import java.util.Calendar;

public class InsanTest {

    public static void main(String[] args) {

        int yil = Calendar.getInstance().get(Calendar.YEAR);
        

        Scanner input = new Scanner(System.in);

        System.out.print("Kullanıcı ismini giriniz:");

        String userName = input.nextLine();

        System.out.print("Doğum Yılınızı giriniz  :");

        int dogumYili = input.nextInt();

        

        Insan user1 = new Insan();

        user1.setName(userName);
        user1.setYas(yil);
        user1.setDogumYili(dogumYili);
        System.out.printf("yil           : %s\n", yil);

        System.out.printf("kullanıcı     :%s\n",user1.getName());
        System.out.printf("yas           :%s\n",user1.getYas());
        System.out.printf("Max Kalp Atış :%s\n",user1.getMaxAtis());
        System.out.printf("idal Kalp Hızı:%s\n",user1.getIdealAtis());



        input.close();



    }
}