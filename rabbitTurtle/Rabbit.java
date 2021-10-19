package rabbitTurtle;

public class Rabbit{

    public int position;
    public String name;
    public int racerNumber;

    public Rabbit(int position, String name){
        this.position = position;
        this.name = name;
    }

    public String getName(){

        return name;
    }

    public void setRacerNumber(int racerNumber){
        this.racerNumber = racerNumber;
    }


    

}