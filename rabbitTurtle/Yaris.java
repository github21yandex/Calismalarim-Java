
package rabbitTurtle;

import java.util.Scanner;
import java.util.Random;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Yaris{

    public static void clearScreen() {          //for clear screen
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void main(String[] args) {    // main func.

        

        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        char selection;
        String userName = "";
        int racerNumber = 0;
        int queue;
        int length = 80;                                    // length of racetrack

        ArrayList <String>  racerList = new ArrayList <>(); // include name of the racers

        Animal racer[] = new Animal[10];                    // 10 pieces objects was created


        while (true){                                       // loop for get user's name 
            clearScreen();

            for (int i = 1; i <= racerNumber ; i++) {       // prints all users
                System.out.printf("racer-%d:%s-%c\n", i, racer[i].getName(), racer[i].getType());
            }

            System.out.print("\n");

            System.out.println("Enter \"S\" to start the RACE! ");

            System.out.printf("Enter racer-%d name:", racerNumber+1);

            userName = input.nextLine();
            
            if( userName.equals("S") || userName.equals("s") ){             //breaks the loop and stars the race
                
                if (racerNumber < 2){
                    System.out.println("Enter At least two racer!\n\n");
                    continue;
                }

                break;
            }
            
            if (userName.length() < 3){                                     
                System.out.println("Invalid User Name!\n\n");
                continue;
            }
            
            racerList.add(userName);                                        // adds the userNames into the racerList to prevent repeat
            
            System.out.print("Enter \"R\" for RABBIT or \"T\" for TURTLE:");            
             
            selection = input.next().charAt(0);                             // rabbit or turtle
            
            selection = Character.toUpperCase(selection);

            if(  (selection == 'R') || (selection == 'T')  ){               // construct a object

                racerNumber++;
                System.out.printf("Rabbit name:%s%n", userName);
                
                racer[racerNumber] = new Animal(1, userName);

                racer[racerNumber].setRacerNumber(racerNumber);

                racer[racerNumber].setType(selection);
               

            }
            else{
                System.out.println("IVALID SELECTION");
            }

            System.out.print("\n\n");

            input.nextLine();                               //c deki gets() fonksiyonu gibi kendisinden sonra bos bir input fonsiyonu kullanılmazsa bir sonraki input fonksiyonu calışmamaktadır.
            
        }
    
        input.close();

        char[][] positions = new char[racerNumber+1][length+1];     // creats 2x2 matrix to construct the racetrack

        for (int i = 1; i <= racerNumber; i++) {                    // marks the positions of the racer 

            positions[i][racer[i].getPosition()] = 'X';
        }

        queue = rand.nextInt(racerNumber)+1;                        // determine the first racer with random func.                        
        
        while (true){                                               // loop for the race

            clearScreen();                                                              

            for (int i = 1; i <= racerNumber ; i++) {                 // prints the all racers
                System.out.printf("racer-%d:%s-%c\n", i, racer[i].getName(), racer[i].getType());
            }

            System.out.print("\n");

            System.out.print("       ");

            for (int i = 0; i <= length; i++) {                      //begins from here to print on the screen the racetrack
                if( i%5 != 0 ){
                    System.out.print(" ");
                }
                else{
                    System.out.printf("%d",i/10);
                }
            }

            System.out.print("\n");

            System.out.print("       ");

            for (int j = 0; j <= length; j++) {
                if( (j)%5 != 0 ){
                    System.out.print(" ");
                }
                else{
                    System.out.printf( "%d",j%10 );
                }
            }

            System.out.print("\n");
            for (int i = 0; i < length+8; i++) {
                System.out.print("-");
            }
            System.out.print("\n");                                 //ends here pringting of the racetrack

            if( queue < racerNumber){                               //all racers queue up in order
                queue++;
            }
            else{
                queue = 1;
            }
        
            System.out.print("\n");

            for (int i = 1; i <= racerNumber; i++) {                //prints the racetrack according to current positions
                System.out.printf("%5s-%c|", racer[i].getName(), racer[i].getType());
                for (int j = 1; j <= length; j++) {

                    if( positions[i][j] == 'X' ){
                        
                        System.out.print("X");
                    }
                    else{
                        System.out.print(" ");
                    }
                   
                }
                System.out.print("\n");
            }

            try {                                                   //waits 100 millseconds 
                TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				continue;
				
            }

            positions[queue][racer[queue].getPosition()] = '\0';    //erases the old position to mark the new position 

            racer[queue].action(rand.nextInt(10)+1) ;               //sends to the racer[queue] object the random number for movement

            if ( racer[queue].getPosition() >= length ){            //determines whether end of the race after execute of the above line
                System.out.printf("\n\nracer-%d:%s KAZANDI!\n\n",queue,racer[queue].getName());
                break;
            }

            positions[queue][racer[queue].getPosition()] = 'X';     //marks the new position of the racer[queue]
            
            
        } // ends race loop

    } // end main
} // end class Yaris