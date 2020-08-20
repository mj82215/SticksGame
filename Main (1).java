import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner reader = new Scanner(System.in);
	    int sticks = (int)(Math.random()*10) + 21; 
	    /* Math.random gives a random double from 0 to 1*/
	    /*Math.random()*10 gives random double from 0 to 10*/
	    //(int)Math.random()*10 gives a random INTEGER from 0 to 9 inclusive//
	    /* we want the starting number of sticks to be a random integer 21-30*/
	    System.out.println("There are " + sticks + " sticks.");
	    // need + sign to go from "" to no quotes and back //
	    System.out.println("Select 1 to go first, select 2 to go second.");
	    boolean turn; //true means player's turn, false means computer's turn//
	    /*if a variable boolean type, two possible values : true or false*/
	    if(reader.nextInt() == 1) //reads value from user//
	        turn = true;
	    else 
	        turn = false;
	   
	   //game stops when we get to 0 sticks
	   //game will continue to run as long as # of sticks is > 0//
	   while(sticks > 0){
	       //while runs until condition fulfilled and if  runs once after a condition is fulfilled//
	       if (turn)
	            sticks = playerMove(sticks, reader);
	       else 
	            sticks = computerMove(sticks);
	       System.out.println("There are " + sticks + " sticks left.");
	        if(sticks == 0 && turn) //&& means "and"//
	            System.out.println("Player wins!");
	        if (sticks == 0 && !turn) //! means false//
	            System.out.println("Computer wins.");
	        turn = !turn;
	   }
	} //end of main//
	
    //this method must return an integer value.
    //this method has two input parameters: sticks and reader
    public static int playerMove (int sticks, Scanner reader){
        System.out.println("Select how may sticks to take.");
        int take = reader.nextInt();
        //take = number of sticks left//
        if(take < 1)
            take = 1;
        if(take > 3)
            take = 3;
        else if(take > sticks)
            take = sticks; 
        System.out.println("You took " + take + " sticks.");
        return sticks - take; 
    } 
    
    public static int computerMove(int sticks){
        int take;
        if(sticks % 4 != 0) //if number of sticks is not a multiple of 4
        //this means "mod" e.g. 21 % 7 is 0 because no remainder//
        //if remainder after dividing by 4 is not 0//
            take = sticks % 4;
        else //number of sticks is a multiple of 4
        //if remainder after dividing by 4 is 0//
            take = (int)(Math.random()*3) + 1;
        System.out.println("The computer took " + take + " sticks.");
        return sticks - take;
    }
    
}

    

