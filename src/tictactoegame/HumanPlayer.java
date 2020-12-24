/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer() {
    }

    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }
   
    @Override
    public void move(TicTacToe board) {
        
        boolean successfulMove = false;
        Scanner keyboard = new Scanner(System.in);
        
        while(!successfulMove){
            System.out.println("Please choose a valid space");  
            String choice = keyboard.next();
            int score = Integer.parseInt(choice);
            successfulMove = board.move(score, getSymbol());
        }
    
    }
}

