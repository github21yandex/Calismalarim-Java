package rabbitTurtle;

public class Animal{

    public int position;
    public String name;
    public int racerNumber;
    public char type;

    public Animal(int position, String name){
        this.position = position;
        this.name = name;
    }
    public void setType(char type){
        this.type = type;
    }

    public char getType(){
        return type;
    }

    public String getName(){

        return name;
    }

    public void setPosition(int newPositon){
        ;
    }

    public int getPosition(){
        return position;
    }

    public void setRacerNumber(int racerNumber){
        this.racerNumber = racerNumber;
    }

    public int getRacerNumber(){
        return racerNumber;

    }

    public void action( int i ){
        move( moveType(i) );
    }

    public String moveType(int i){
        
            
            if ( i <= 5 && i >= 1 && this.type == 'T'){
                return "fastPlod";
            }
            else if ( i <= 7 && i >= 6 && this.type == 'T'){
                return "slip";
            }
            else if ( i <= 10 && i >= 8 && this.type == 'T'){
                return "slowPlod";
            }
            else if ( i <= 2  && i >= 1 && this.type == 'R'){
                return "sleep";
            }
            else if ( i <= 4 && i >= 3 && this.type == 'R'){
                return "bigHop";
            }
            else if ( i == 5 && this.type == 'R'){
                return "bigSlip";
            }
            else if ( i <= 8 && i >= 6 && this.type == 'R'){
                return "smallHop";
            }
            else if ( i <= 10 && i >= 9 && this.type == 'R'){
                return "smallSlip";
            }
            else{
                return "bos";
            }    

    }

    public void move(String moving){

        if (  moving.equals("fastPlod")  ){
            position += 3;
        }

        else if ( moving.equals("slip") ){
            if(position > 6){
                position -= 6;
            }
            else{
                position = 1;
            }
        }

        else if ( moving.equals("slowPlod") ){
            position += 1;
        }

        else if ( moving.equals("sleep") ){
            ;
        }

        else if ( moving.equals("bigHop") ){
            position += 9;
        }

        else if( moving.equals("bigSlip") ){
            if ( position > 12){
                position -= 12;
            }
            else{
                position = 1;
            }
        }

        else if ( moving.equals("smallHop") ){
            position += 1;
        }

        else if ( moving.equals("smallslip") ){
            if (position > 2){
                position -= 2;
            }
            else{
                position = 1;
            }
        }

        else{
            ;
        }

    }

    

}