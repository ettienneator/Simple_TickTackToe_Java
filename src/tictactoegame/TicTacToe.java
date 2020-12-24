package tictactoegame;

import java.util.Scanner;

// Author Ettienne Martinez

public class TicTacToe {
    
    private char[][] board;
    
    public TicTacToe() {
        
        //Creating a 3x3 TicTacToe Board.
        board = new char[3][3];
        int count = 1;
        
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                String s = "" + count++;
                board[i][j] = s.charAt(0);
            }
        }
    }
    
    public boolean move(int row, int col, char symbol) {
        
        //If theres already an X or an O, return false.
        if (row < 0 || row > 2 || col < 0 || col > 2 || 
                (symbol != 'X' && symbol != 'O')) {
            return false;
        }
        
        if (Character.isDigit(board[row][col])) { // if this isn't an X or O... Return true.
            board[row][col] = symbol;
            return true;
        }
        
        return false;
    }
    
    public boolean move(int square, char symbol) {
        //Calculating position.
        int row = (square - 1) / 3;
        int col = (square - 1) % 3;
        
        //Return move coordinates and symbol.
        return move(row, col, symbol);
    }
    
    public boolean isGameOver() {
        
        int countX = 0;
        int countO = 0;
        
        //Checking X Horizontal
        if(board[0][0]=='X' && board[0][1]=='X' && board[0][2]=='X'){
            countX += 1;
        }
        else if(board[1][0]=='X' && board[1][1]=='X'&& board[1][2]=='X'){
            countX += 1;
        }
        else if(board[2][0]=='X' && board[2][1]=='X' && board[2][2]=='X'){
            countX += 1;
        }
        //***********
           
        //Checking O Horizontal Check.
        else if(board[0][0]=='O' && board[0][1]=='O' && board[0][2]=='O'){
            countO += 1;
        }
         else if(board[1][0]=='O' && board[1][1]=='O' && board[1][2]=='O'){
            countO += 1;
        }
        else if(board[2][0]=='O' && board[2][1]=='O' && board[2][2]=='O'){
            countO += 1;
        }
        //***********

        //Checking X Vertical.
        else if(board[0][0]=='X' && board[1][0]=='X' && board[2][0]=='X'){
            countX += 1;
        }
        else if(board[0][1]=='X' && board[1][1]=='X' && board[2][1]=='X'){
            countX += 1;
        }
        else if(board[0][2]=='X' && board[1][2]=='X' && board[2][2]=='X'){
            countX += 1;
        }
        //***********

        //Checking O Vertical Check.
        else if(board[0][0]=='O' && board[1][0]=='O' && board[2][0]=='O'){
            countO += 1;
        }
        else if(board[0][1]=='O' && board[1][1]=='O' && board[2][1]=='O'){
            countO += 1;
        }
        else if(board[0][2]=='O' && board[1][2]=='O' && board[2][2]=='O'){
            countO += 1;
        }
        //***********
        
        //Checking X Diagonal
        else if(board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='X'){
            countX += 1;
        }
        else if(board[2][0]=='X' && board[1][1]=='X' && board[0][2]=='X'){
            countX += 1;
        }
        //***********
        
        //Checking O Diagonal
        else if(board[0][0]=='O' && board[1][1]=='O' && board[2][2]=='O'){
            countO += 1;
        }
        else if(board[2][0]=='O' && board[1][1]=='O' && board[0][2]=='O'){
            countO += 1;
        } 
        //***********
        
        //If X had 3 in a row, print X won.
        if(countX == 1){
            System.out.println("X has won");
            return true;
        }
        
        //If O had 3 in a row, print O won.
        else if(countO == 1){
            System.out.println("O has won");
            return true;
        }
        
        //Else, return false.
        else{
            return false;
        }
        
    }
    public boolean isTie(){
        
        //Checks if every pace on the board is take up or not, checks if all spaces are numbers or not.
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if(Character.isDigit(board[i][j])){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public void display() {
        
        //Displays the progress of the game board at that moment.
        for(int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void Symbol(Player cpu,Player user ) {
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Which symbol would you like to play as: (1)X or (2)O");
        
        //If user chooses 1, player is X and cpu is O. Else vice versa.
        if(keyboard.nextInt()==1){
            user.setSymbol('X');
            cpu.setSymbol('O');
        }
        else{
            user.setSymbol('O');
            cpu.setSymbol('X');
        }
    }
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        
        //Declaring a game object.
        TicTacToe game = new TicTacToe();
        
        //Declaring the CPU.
        Player cpu = new ComputerPlayer("Computer", 'Z');
        
        //Setting up Player name and Declaring HumanPlayer.
        System.out.print("Enter your name: ");
        String playerName = keyboard.nextLine();
        Player user = new HumanPlayer(playerName,'A');
        
        System.out.println("Hello " + user.getName());
        
        game.Symbol(cpu,user);
        System.out.println("");
        game.display();
        System.out.println("");
        
        boolean isGameOverBoolean = game.isGameOver();
        
        //If the game is over
        while(isGameOverBoolean == false && game.isTie() == false){
            
            cpu.move(game);
            game.display();
            
            //Goes through isGameOver method and checks if someone won. If not, then user move.
            isGameOverBoolean = game.isGameOver();
            if(isGameOverBoolean == false && game.isTie() == false){
                user.move(game);
            }
            
            //If noone won and board is full, then print out its a tie.
            if(isGameOverBoolean == false && game.isTie() == true){
                System.out.println("The game resulted in a tie");
            }
        
        }
        
        game.display();

    }
}
