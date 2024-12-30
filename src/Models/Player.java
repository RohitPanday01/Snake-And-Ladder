package src.Models;

public class Player {
    private String playername;

    public Player(String playername){
        this.playername = playername;
    }

    public String getplayername(){
        return playername;
    }

    public void setPlayername(String playername){
        this.playername = playername;
    }

}

//public class Player {
//     private final String name;
//     private int health;
//     private final int strength;
//     private final int attack;

//     public Player(String name, int health, int strength, int attack) {
//         if (health <= 0 || strength <= 0 || attack <= 0) {
//             throw new IllegalArgumentException("Player attributes must be positive integers.");
//         }
//         this.name = name;
//         this.health = health;
//         this.strength = strength;
//         this.attack = attack;
//     }
// }
