package src.Service;


public class Diceservice {

    public static int roll(){
       return (int)(Math.random()*6) +1; 
    }

    public static int roll(int side){
        return (int)((Math.random()*side) +1);
    }
}
