package org.scaler;

import org.scaler.controllers.GameController;
import org.scaler.exceptions.InvalidMoveException;
import org.scaler.models.*;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        Scanner sc = new Scanner(System.in);
        GameController gameController = new GameController();
        System.out.println("Enter the size of board : ");
        int dimension = sc.nextInt();

        List<Player> players = List.of(
                new Player("Messi",new Symbol('X'), PlayerType.HUMAN),
                new Bot("Computer",new Symbol('O'),PlayerType.BOT, BotDifficultyLevel.EASY)
        );

        Game game = gameController.startGame(dimension,players);

        gameController.printBoard(game);

        while(game.getGameState().equals(GameState.IN_PROGRESS )){

            gameController.makeMove(game);

            gameController.printBoard(game);
        }
        if(!gameController.checkState(game).equals(GameState.ENDED)){
            game.setGameState(GameState.DRAW);
            System.out.println("Game drawn");
        }
        else{
            System.out.println(gameController.getwinner(game).getName()+" is the winner ");
        }
    }

}