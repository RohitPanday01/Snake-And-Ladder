package  src.Models;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;


public class Board {
    private int size ;
    private List<Snake>snakes;
    private List<Ladder>ladders;
    private List<Player> players;
    private HashMap<String , Integer> playerpeices;
    private HashMap<Integer , Integer> snakeandladderpeices;
   

    public Board(int size ){
        this.snakes = new ArrayList<Snake>();
        this.ladders = new ArrayList<Ladder>();
        this.players = new ArrayList<Player>();
        this.playerpeices = new HashMap<String ,Integer>();
        this.snakeandladderpeices = new HashMap<Integer ,Integer>();
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public void set_snakeandladderpeices(HashMap<Integer, Integer> ladderpeices) {
        this.snakeandladderpeices = ladderpeices;
    }

    public HashMap<Integer, Integer> get_snakeandladderpeices() {
        return snakeandladderpeices;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }


    public HashMap<String, Integer> getPlayerpeices() {
        return playerpeices;
    }

    public void setPlayerpeices(HashMap<String, Integer> playerpeices) {
        this.playerpeices = playerpeices;
    }
}
