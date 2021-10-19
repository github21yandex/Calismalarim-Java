package denemeler;

public class Throw {
    public static void main(String[] args) throws IllegalAccessException {
        int a = 5;
        if (a == 5){
            throw new IllegalAccessException("illegal arguman");
        }
    }
}