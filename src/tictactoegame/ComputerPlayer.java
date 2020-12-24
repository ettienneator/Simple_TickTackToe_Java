package tictactoegame;

public class ComputerPlayer extends Player {

    public ComputerPlayer() {
        System.out.println("1");
    }
    
    public ComputerPlayer(String name, char symbol) {
        super(name, symbol);
    }
    
    public void move(TicTacToe board) {

        System.out.println("Computer move: ");
        boolean successfulMove = false;
        
        while (!successfulMove) {
            int move = (int) (Math.random() * 9 + 1);
            successfulMove = board.move(move, getSymbol());
        }
    }
    
    public String toString() {
        return "I am " + getName() + " and I am awesome";
    }
    
    public void compute() {
        System.out.println("Does not compute!");
    }
    
}