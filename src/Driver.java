package src;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

import src.Models.Ladder;
import src.Models.Player;
import src.Models.Snake;
import src.Service.SnakeandLaddersrvice;

public class Driver {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int Noofsnakes = sc.nextInt();

        List<Snake> snakes = new ArrayList<>();
        for(int i = 0 ; i < Noofsnakes; i++){
            snakes.add(new Snake(sc.nextInt(), sc.nextInt()));
        }

        int Noofladders = sc.nextInt();
        List<Ladder>ladders = new ArrayList<>();
        for(int i = 0; i < Noofladders; i++ ){
            ladders.add(new Ladder(sc.nextInt(), sc.nextInt()));
        }

                int noOfPlayers = sc.nextInt();

        List<Player> players = new ArrayList<Player>();
        for (int i = 0; i < noOfPlayers; i++)
            players.add(new Player(sc.next()));

        SnakeandLaddersrvice snakeAndLadderService = new SnakeandLaddersrvice();
        snakeAndLadderService.setLadders(ladders);
        snakeAndLadderService.setSnakes(snakes);
        snakeAndLadderService.setPlayers(players);
        snakeAndLadderService.startgame();
        sc.close();

    }
}
