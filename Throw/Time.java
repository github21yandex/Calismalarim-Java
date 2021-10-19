package Throw;

public class Time {
    private int hour;
    
    public void setTime(int hour){
        if(hour <0 || hour >24){
            throw new IllegalArgumentException("yanlış saat");

        }
        this.hour = hour;
    }
    
    public int getHour() {
        return hour;
    }
}