package src.Service;

import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import src.Models.Board;
import src.Models.Ladder;
import src.Models.Player;
import src.Models.Snake;

public class SnakeandLaddersrvice {

    private Board snakeladderboard;
    private Queue<Player>players;
    private int totalplayers;
    HashMap<Integer , Integer>snake_ladder_pos = new HashMap<>();
    private int size ;
    
    // Diceservice Dice;
    private static int DEFAULTBOARDSIZE = 100;

    public SnakeandLaddersrvice(int size){
        this.snakeladderboard = new Board(size);
        this.players = new LinkedList<Player>();
        this.size = size ;
        snakeladderboard.setSize(size); 
    }

    public SnakeandLaddersrvice(){
        this(DEFAULTBOARDSIZE);
        snakeladderboard.setSize(DEFAULTBOARDSIZE);
    }

    public void setPlayers(List<Player> players){
        this.totalplayers = players.size();
        HashMap<String , Integer>  playerpos = new HashMap<>();

        for(Player p : players){
            this.players.offer(p);
            playerpos.put(p.getplayername() ,0 );
        }

        this.snakeladderboard.setPlayerpeices(playerpos);
    }

    public void setSnakes(List<Snake>snakes){
         for(Snake snake : snakes){
            snake_ladder_pos.put(snake.getStart(), snake.getEnd());
         }
        this.snakeladderboard.setSnakes(snakes);
        this.snakeladderboard.set_snakeandladderpeices(snake_ladder_pos);
    }

    public void setLadders(List<Ladder>ladders){
        for(Ladder ladder : ladders){
            snake_ladder_pos.put(ladder.getEnd() , ladder.getStart());
        }
        this.snakeladderboard.setLadders(ladders);
        this.snakeladderboard.set_snakeandladderpeices(snake_ladder_pos);
    }

    public void startgame(){
       while(!isGameFinished()){
          int dicevalue = Diceservice.roll();
          Player player = players.poll();
          movepositions(player, dicevalue);
          if(playerwon(player)){
            System.out.println("Player name " + player.getplayername() + "won");
            this.snakeladderboard.getPlayerpeices().remove(player.getplayername());
          }else{
            players.offer(player);
          }
       }
    }
    boolean isGameFinished(){
        return this.players.size() == 0;
    }

    public int rolldice(){
        return Diceservice.roll(6);
    }

    public void movepositions( Player player, int dicevalue){
        int currposition = this.snakeladderboard.getPlayerpeices().get(player.getplayername());
        int nextposition = currposition + dicevalue ;

        if(nextposition > size){
            nextposition = currposition;
        }else{
            nextposition = getpositionwithsnakeandladder(nextposition);
        }
    }

    public int getpositionwithsnakeandladder(int nextposition){
        
        return snake_ladder_pos.getOrDefault(nextposition , nextposition);
       
    }

    public boolean playerwon(Player player){    
        return this.snakeladderboard.getPlayerpeices().get(player.getplayername()) == size;
    }


}
