import java.util.Scanner;
import java.util.Random;
/**
 * Sisahga Phimmasone - 40210015
 * Cleopatr-Aliak Manoukian - 40211001
 * COMP 249
 * Assignment # 1
 * Due Date - Monday, February 7, 2022 @ 23:59
 * ---------------------------------------------------------------------------------------------------
 *Assignment 1
 *Question: Part I)
 *Written by: Cleopatr-Aliak Manoukian and Sisahga Phimmasone - 40211001 and 40210015 respectively.
*
 *---------------------------------------------------------------------------------------------------
 *@author Cleopatr-Aliak
 *@author Sisahga
*/
public class LadderAndSnake {
    private int numberOfPlayers;
    Scanner key = new Scanner(System.in);
    Random dice = new Random();

    /**
     *  Default Constructor.
     */
    public LadderAndSnake() 
    {}

    /**
     *  Contructor.
     *  @param numPlayers an integer value
     */
    public LadderAndSnake(int numPlayers) 
    {
        this.numberOfPlayers = numPlayers;
    }

    /** This constructor creates a new object of type LadderAndSnake and takes the same
      * the number of players of an existing Object of the same type
      * @param LadderAndSnake an object
    */
    public LadderAndSnake(LadderAndSnake LadderAndSnake) 
    {
        this.numberOfPlayers = LadderAndSnake.numberOfPlayers;
    }

    /** This method allows the user to choose the number of players
     * while making them choose an appropriate number: 2-4 inclusively
     * @param numPlayers an integer value
     */
    public void setNumberOfPlayers(int numPlayers) 
    {
        if (numPlayers < 2 || numPlayers > 4) 
        {
            this.numberOfPlayers = 0;
        } 
        else 
        {
            this.numberOfPlayers = numPlayers;
        }
    }

     
    /**
     * Accessor for the number of players.
      @return integer representing the number of players
     */
    public int getNumberOfPlayers() {
        return this.numberOfPlayers;
    }

    /* --- --- --- --- --- LADDER AND SNAKE BOARD --- --- --- --- --- */
    
    /**This method creates a board and sets the value of each square accordingly.
     * It also shows the user which square they are at when called.
     * @param Position an integer value
     * @param Name a String
     */

    public void Board(int Position,String Name) 
    {
        int[][] board = new int[10][10];
        int boardPos = 1;
        for (int row = 9; row >= 0; row--) 
        {
            for (int column = 0; column < board.length; column++) 
            {
                if (row % 2 == 0) 
                {
                    board[row][9 - column] = boardPos;
                } 
                else 
                {
                    if (boardPos < 10)
                        board[row][column] = boardPos;
                    else
                        board[row][column] = boardPos;
                }
                boardPos++;
            }
        }

        for (int i = 0; i < board.length; i++) 
        {
            for (int j = 0; j < board.length; j++) 
            {
                if (board[i][j] == (Position+1))
                {
                    if(Name.length() < 2)
                        System.out.print("    " + Name + "    ");
                    else if (Name.length()<4)
                        System.out.print("  " + Name + "  ");
                    else 
                    System.out.print(Name);
                }
                //if (i == 0 && j == 0)
                   //System.out.print("    " + board[i][j] + "   ");
                
                else
                    System.out.print("   " + board[i][j] + "    ");
            }
            System.out.print("\n\n\n\n");
        }
    }

    /**
     *  1ST METHOD: flipDice(). Returns a random value between 1 and 6 inclusively.
     *  @return an integer value between 1 and 6
    */

    public int flipDice() 
    {
 

    		return (int) (Math.random() * 6) + 1;

    // The dice will yield a random value from 1 to 6.
    }

    /**
     * --- --- --- --- 2ND METHOD: play(). Initiates the core engine of the game.
     * --- --- --- ---
     * 
     * -> Order of playing must be determined. Largest number on flip starts first.
     * If
     * there is a tie, the process is repeated for the players involved in the tie.
     * 
     * -> Players start playing the game by alternating dice flips. Each flip moves
     * a
     * player from a certain square to another. The player goes from his position
     * on the board to his position + the value flipped on the dice.
     * 
     * -> If a player lands on the bottom of a ladder, the player moves to the top
     * of
     * the ladder. If they land on the head of a snake, they move to the tail of
     * the snake.
     * 
     * -> The game ends when a player reaches exactly square 100. For example, if
     * the
     * player is at square 98, they have to roll 2 on the dice to win. If they roll
     * 3 they have to go to 100 and move back a square (98 -> 100 - 1 = 99).
     */

    public void play() {

        /* ----- Determining the Order of Play ----- */

        int[][] playerArray = new int[2][this.numberOfPlayers]; // First dimension holds the results of the dice flip.
                                                                // Second dimension represents the players.

        System.out.println("\nGame is being played by " + this.numberOfPlayers + " players.");
        String[] playerNames = new String[this.numberOfPlayers];

            System.out.println();
            int playerNum = 1;
            for (int n = 0; n < this.numberOfPlayers; n++) 
            {
                System.out.print("Enter a name for Player " + playerNum + ": ");
                playerNames[n] = key.next();
                playerNum++;
            }
            for (int w = 0; w < playerArray.length; w++) 
            {
                playerArray[1][w] = w; // Player number (player 1, player 2, player 3, player 4) in order.!!!!
            }

            System.out.println(
                    "\nLet's determine the order of play. Each player will roll the dice; player who rolls highest number goes first, player who rolls the lowest number goes last.\n");
            for (int f = 0; f < this.numberOfPlayers; f++) 
            {
                System.out.print("\t" + playerNames[f] + ", press <enter> to roll: ");
                if (f == 0)
                    key.nextLine();
                key.nextLine();
            //FIRST FLIP OF THE GAME.
                playerArray[0][f] = flipDice();
                System.out.println("\t--> You got a dice value of " + playerArray[0][f] + ".");
            }

            int counter1 = 0, counter2 = 0, counter3 = 0, counter4 = 0, counter5 = 0, counter6 = 0;
        //Counts how many times a dice value has been rolled.

        //Sorts the array in correct order even with ties.
            for (int i = 0; i < this.numberOfPlayers; i++)
            {
                for (int j = i + 1; j < this.numberOfPlayers; j++)
                {
                    if (playerArray[0][j] > playerArray[0][i])
                    {
                        int tampon = playerArray[0][i];
                        playerArray[0][i] =playerArray[0][j];
                        playerArray[0][j] = tampon;
                        int temp = playerArray[1][i];
                        playerArray[1][i] = playerArray[1][j];
                        playerArray[1][j] = temp;
                        String nameTemp = playerNames[i];
                        playerNames[i] = playerNames[j];
                        playerNames[j] = nameTemp;
                    }
                }
            }

            int numTies = 0;
            boolean counter1tie = false, counter2tie = false, counter3tie = false, counter4tie = false, counter5tie = false, counter6tie = false;

            for (int i = 0; i < this.numberOfPlayers; i++)
            {
                if (playerArray[0][i] == 1)
                {
                    counter1++;
                    if (counter1 == 2)
                    {
                        numTies++;
                        counter1tie = true;
                    }
                }
                if (playerArray[0][i] == 2)
                {
                    counter2++;
                    if (counter2 == 2)
                    {
                        numTies++;
                        counter2tie = true;
                    }
                }
                if (playerArray[0][i] == 3)
                {
                    counter3++;
                    if (counter3 == 2)
                    {
                        numTies++;
                        counter3tie = true;
                    }
                }
                if (playerArray[0][i] == 4)
                {
                    counter4++;
                    if (counter4 == 2)
                    {
                        numTies++;
                        counter4tie = true;
                    }
                }
                if (playerArray[0][i] == 5)
                {
                    counter5++;
                    if (counter5 == 2)
                    {
                        numTies++;
                        counter5tie = true;
                    }
                }
                if (playerArray[0][i] == 6)
                {
                    counter6++;
                    if (counter6 == 1)
                    {
                        numTies++;
                        counter6tie = true;
                    }
                }
            }

            if (counter1 > 1 || counter2 > 1 || counter3 > 1 || counter4 > 1 || counter5 > 1 || counter6 > 1) //We have a tie
            {
                //Checking 4 players tie
                while (counter1 == 4 || counter2 == 4 || counter3 == 4 || counter4 == 4 || counter5 == 4 || counter6 == 4)
                {
                    counter1 = 0; counter2 = 0; counter3 = 0; counter4 = 0; counter5 = 0; counter6 = 0;

                    System.out.println(playerNames[0] + ", " + playerNames[1] + ", " + playerNames[2] + ", and " + playerNames[3] + ", you are in a tie. Roll again.");

                    for (int i = 0; i < this.numberOfPlayers; i++)
                    {
                        System.out.print(playerNames[i] + ", press <enter> to roll the dice: ");
                        key.nextLine();
                        playerArray[0][i] = flipDice();
                        System.out.println("You rolled a " + playerArray[0][i] + ".");
                    }
                    for (int i = 0; i < this.numberOfPlayers; i++)
                    {
                        if (playerArray[0][i] == 1)
                            counter1++;
                        if (playerArray[0][i] == 2)
                            counter2++;
                        if (playerArray[0][i] == 3)
                            counter3++;
                        if (playerArray[0][i] == 4)
                            counter4++;
                        if (playerArray[0][i] == 5)
                            counter5++;
                        if (playerArray[0][i] == 6)
                            counter6++;
                    }
                //Sorting the new array of values from the reflip.
                    for (int i = 0; i < this.numberOfPlayers; i++)
                    {
                        for (int j = i + 1; j < this.numberOfPlayers; j++)
                        {
                            if (playerArray[0][j] > playerArray[0][i])
                            {
                                int tampon = playerArray[0][i];
                                playerArray[0][i] =playerArray[0][j];
                                playerArray[0][j] = tampon;
                                int temp = playerArray[1][i];
                                playerArray[1][i] = playerArray[1][j];
                                playerArray[1][j] = temp;
                                String nameTemp = playerNames[i];
                                playerNames[i] = playerNames[j];
                                playerNames[j] = nameTemp;
                            }
                        }
                    }
                }//End of 4 player ties.

            //Checking 3 player ties.
                while (counter1 == 3 || counter2 == 3 || counter3 == 3 || counter4 == 3 || counter5 == 3 || counter6 == 3)
                {   
                    int numTiesTimed = 0;
                
                //3 player tie, 3 players playing.
                    if (this.numberOfPlayers == 3)
                    {
                        numTiesTimed++;

                        if (numTiesTimed < 2)
                            System.out.println(playerNames[0] + ", " + playerNames[1] + ", and " + playerNames[2] + ", you are in a tie. Roll again.");
                        else
                            System.out.println(playerNames[0] + ", " + playerNames[1] + ", and " + playerNames[2] + ", you are still in a tie. Roll again.");

                        counter1 = 0; counter2 = 0; counter3 = 0; counter4 = 0; counter5 = 0; counter6 = 0;

                        for (int i = 0; i < this.numberOfPlayers; i++)
                        {
                            System.out.print(playerNames[i] + ", press <enter> to roll: ");
                            key.nextLine();
                            playerArray[0][i] = flipDice(); //Reflipping
                            System.out.println("\tYou rolled a " + playerArray[0][i]);

                            if (playerArray[0][i] == 1)
                                counter1++;
                            if (playerArray[0][i] == 2)
                                counter2++;
                            if (playerArray[0][i] == 3)
                                counter3++;
                            if (playerArray[0][i] == 4)
                                counter4++;
                            if (playerArray[0][i] == 5)
                                counter5++;
                            if (playerArray[0][i] == 6)
                                counter6++;
                        }

                        for (int i = 0; i < this.numberOfPlayers; i++)
                        {
                            for (int j = i + 1; j < this.numberOfPlayers; j++)
                            {
                                if (playerArray[0][j] > playerArray[0][i])
                                {
                                    int temp = playerArray[0][i];
                                    playerArray[0][i] = playerArray[0][j];
                                    playerArray[0][j] = temp;
                                    int tampon = playerArray[1][i];
                                    playerArray[1][i] = playerArray[1][j];
                                    playerArray[1][j] = tampon;
                                    String tempname = playerNames[i];
                                    playerNames[i] = playerNames[j];
                                    playerNames[j] = tempname;
                                }
                            }
                        }

                    }//End of 3 player ties if there are 3 players playing,

                //3 player tie, 4 players playing.
                    else
                    {
                        int timesTied = 0;
                        int threeTiedPlayerArray[][] = new int[2][3];
                        String threeTiedPlayersNames[] = new String[3];

                        boolean single1 = (counter1 == 1), single2 = (counter2 == 1), single3 = (counter3 == 1), single4 = (counter4 == 1), single5 = (counter5 == 1), single6 = (counter6 == 1);
                        boolean was3 = false, was4 = false, was5 = false, was6 = false;

                    //Players are tied on 1.
                        while (counter1 == 3)
                        {
                            timesTied++;
                            counter1 = 0; counter2 = 0; counter3 = 0; counter4 = 0; counter5 = 0; counter6 = 0;
                            for (int i = 1; i < this.numberOfPlayers; i++) //i starts at 1 since it is smaller than all other dice values which means that the 4th player rolled a higher value than those 3 players and is placed in the first position.
                            {
                                if (playerArray[0][i] == 1)
                                {
                                    threeTiedPlayerArray[1][i-1] = playerArray[1][i]; //Takes the position of every player that rolled 1.
                                    threeTiedPlayersNames[i-1] = playerNames[i];
                                }
                            }

                            System.out.println();
                            if (timesTied < 2)
                                System.out.println(threeTiedPlayersNames[0] + ", " + threeTiedPlayersNames[1] + ", and " + threeTiedPlayersNames[2] + ", you are in a tie. Roll again.");
                            else    
                                System.out.println(threeTiedPlayersNames[0] + ", " + threeTiedPlayersNames[1] + ", and " + threeTiedPlayersNames[2] + ", you are still in a tie. Roll again.");

                            for (int i = 0; i < 3; i++)
                            {
                                System.out.print(threeTiedPlayersNames[i] + ", press <enter> to roll: ");
                                key.nextLine();
                                threeTiedPlayerArray[0][i] = flipDice(); //Reflipping
                                System.out.println("\tYou rolled a " + threeTiedPlayerArray[0][i]);

                                if (threeTiedPlayerArray[0][i] == 1)
                                    counter1++;
                                if (threeTiedPlayerArray[0][i] == 2)
                                    counter2++;
                                if (threeTiedPlayerArray[0][i] == 3)
                                    counter3++;
                                if (threeTiedPlayerArray[0][i] == 4)
                                    counter4++;
                                if (threeTiedPlayerArray[0][i] == 5)
                                    counter5++;
                                if (threeTiedPlayerArray[0][i] == 6)
                                    counter6++;
                            }  
                                          
                        }//3 players are no longer tied on dice = 1.

                        while (counter2 == 3)
                        {
                            timesTied++;
                            counter1 = 0; counter2 = 0; counter3 = 0; counter4 = 0; counter5 = 0; counter6 = 0;
                            if (!single1) //The player who is not tied did not roll a 1.
                            {    
                                for (int i = 1; i < this.numberOfPlayers; i++)
                                {
                                    if (playerArray[0][i] == 2)
                                    {
                                        threeTiedPlayerArray[1][i-1] = playerArray[1][i]; //Takes the position of every player that rolled 2.
                                        threeTiedPlayersNames[i-1] = playerNames[i];
                                    }
                                }
                            }
                            else //2 is the highest dice number rolled, three players will be starting from position 0 in the array
                            {
                                for (int i = 0; i < this.numberOfPlayers; i++) //CHECK if i < this.numberOfPlayers bugs.
                                {
                                    if (playerArray[0][i] == 2)
                                    {
                                        threeTiedPlayerArray[1][i] = playerArray[1][i]; //Takes the position of every player that rolled 2.
                                        threeTiedPlayersNames[i] = playerNames[i];
                                    }
                                }
                            }
                            System.out.println();
                            if (timesTied < 2)
                                System.out.println(threeTiedPlayersNames[0] + ", " + threeTiedPlayersNames[1] + ", and " + threeTiedPlayersNames[2] + ", you are in a tie. Roll again.");
                            else    
                                System.out.println(threeTiedPlayersNames[0] + ", " + threeTiedPlayersNames[1] + ", and " + threeTiedPlayersNames[2] + ", you are still in a tie. Roll again.");

                            for (int i = 0; i < 3; i++)
                            {
                                System.out.print(threeTiedPlayersNames[i] + ", press <enter> to roll: ");
                                key.nextLine();
                                threeTiedPlayerArray[0][0] = flipDice(); //Reflipping
                                System.out.println("\tYou rolled a " + threeTiedPlayerArray[0][i]);

                                if (threeTiedPlayerArray[0][i] == 1)
                                    counter1++;
                                if (threeTiedPlayerArray[0][i] == 2)
                                    counter2++;
                                if (threeTiedPlayerArray[0][i] == 3)
                                    counter3++;
                                if (threeTiedPlayerArray[0][i] == 4)
                                    counter4++;
                                if (threeTiedPlayerArray[0][i] == 5)
                                    counter5++;
                                if (threeTiedPlayerArray[0][i] == 6)
                                    counter6++;
                            }

                        }//3 players are no longer tied on 2.
                        while (counter3 == 3)
                        {
                            timesTied++;
                            was3 = true;
                            counter1 = 0; counter2 = 0; counter3 = 0; counter4 = 0; counter5 = 0; counter6 = 0;
                            if (!single1 && !single2) //The player who is not tied did not roll a 1 nor a 2.
                            {    
                                for (int i = 1; i < this.numberOfPlayers; i++)
                                {
                                    if (playerArray[0][i] == 3)
                                    {
                                        threeTiedPlayerArray[1][i-1] = playerArray[1][i]; //Takes the position of every player that rolled 3.
                                        threeTiedPlayersNames[i-1] = playerNames[i];
                                    }
                                }
                            }
                            else //3 is the highest dice number rolled, three players will be starting from position 0 in the array
                            {
                                for (int i = 0; i < this.numberOfPlayers; i++) //CHECK if i < this.numberOfPlayers bugs.
                                {
                                    if (playerArray[0][i] == 3)
                                    {
                                        threeTiedPlayerArray[1][i] = playerArray[1][i]; //Takes the position of every player that rolled 3.
                                        threeTiedPlayersNames[i] = playerNames[i];
                                    }
                                }
                            }
                            System.out.println();
                            if (timesTied < 2)
                                System.out.println(threeTiedPlayersNames[0] + ", " + threeTiedPlayersNames[1] + ", and " + threeTiedPlayersNames[2] + ", you are in a tie. Roll again.");
                            else    
                                System.out.println(threeTiedPlayersNames[0] + ", " + threeTiedPlayersNames[1] + ", and " + threeTiedPlayersNames[2] + ", you are still in a tie. Roll again.");

                            for (int i = 0; i < 3; i++)
                            {
                                System.out.print(threeTiedPlayersNames[i] + ", press <enter> to roll: ");
                                key.nextLine();
                                threeTiedPlayerArray[0][i] = flipDice(); //Reflipping
                                System.out.println("\tYou rolled a " + threeTiedPlayerArray[0][i]);

                                if (threeTiedPlayerArray[0][i] == 1)
                                    counter1++;
                                if (threeTiedPlayerArray[0][i] == 2)
                                    counter2++;
                                if (threeTiedPlayerArray[0][i] == 3)
                                    counter3++;
                                if (threeTiedPlayerArray[0][i] == 4)
                                    counter4++;
                                if (threeTiedPlayerArray[0][i] == 5)
                                    counter5++;
                                if (threeTiedPlayerArray[0][i] == 6)
                                    counter6++;
                            }
                        }
                        while (counter4 == 3)
                        {
                            timesTied++;
                            was4 = true;
                            counter1 = 0; counter2 = 0; counter3 = 0; counter4 = 0; counter5 = 0; counter6 = 0;
                            if (!single1 && !single2 && !single3) //The player who is not tied did not roll a 1, 2, nor 3.
                            {    
                                for (int i = 1; i < this.numberOfPlayers; i++)
                                {
                                    if (playerArray[0][i] == 4)
                                    {
                                        threeTiedPlayerArray[1][i-1] = playerArray[1][i]; //Takes the position of every player that rolled 4.
                                        threeTiedPlayersNames[i-1] = playerNames[i];
                                    }
                                }
                            }
                            else //4 is the highest dice number rolled, three players will be starting from position 0 in the array
                            {
                                for (int i = 0; i < this.numberOfPlayers; i++) //CHECK if i < this.numberOfPlayers bugs.
                                {
                                    if (playerArray[0][i] == 4)
                                    {
                                        threeTiedPlayerArray[1][i] = playerArray[1][i]; //Takes the position of every player that rolled 4.
                                        threeTiedPlayersNames[i] = playerNames[i];
                                    }
                                }
                            }
                            System.out.println();
                            if (timesTied < 2)
                                System.out.println(threeTiedPlayersNames[0] + ", " + threeTiedPlayersNames[1] + ", and " + threeTiedPlayersNames[2] + ", you are in a tie. Roll again.");
                            else    
                                System.out.println(threeTiedPlayersNames[0] + ", " + threeTiedPlayersNames[1] + ", and " + threeTiedPlayersNames[2] + ", you are still in a tie. Roll again.");

                            for (int i = 0; i < 3; i++)
                            {
                                System.out.print(threeTiedPlayersNames[i] + ", press <enter> to roll: ");
                                key.nextLine();
                                threeTiedPlayerArray[0][i] = flipDice(); //Reflipping
                                System.out.println("\tYou rolled a " + threeTiedPlayerArray[0][i]);

                                if (threeTiedPlayerArray[0][i] == 1)
                                    counter1++;
                                if (threeTiedPlayerArray[0][i] == 2)
                                    counter2++;
                                if (threeTiedPlayerArray[0][i] == 3)
                                    counter3++;
                                if (threeTiedPlayerArray[0][i] == 4)
                                    counter4++;
                                if (threeTiedPlayerArray[0][i] == 5)
                                    counter5++;
                                if (threeTiedPlayerArray[0][i] == 6)
                                    counter6++;
                            }
                        }
                        while (counter5 == 3)
                        {
                            counter1 = 0; counter2 = 0; counter3 = 0; counter4 = 0; counter5 = 0; counter6 = 0;
                            timesTied++;
                            was5 = true;
                            if (!single1 && !single2 && !single3 && !single4) //The player who is not tied did not roll a 1, 2, 3, nor 4.
                            {    
                                for (int i = 1; i < this.numberOfPlayers; i++)
                                {
                                    if (playerArray[0][i] == 5)
                                    {
                                        threeTiedPlayerArray[1][i-1] = playerArray[1][i]; //Takes the position of every player that rolled 5.
                                        threeTiedPlayersNames[i-1] = playerNames[i];
                                    }
                                }
                            }
                            else //5 is the highest dice number rolled, three players will be starting from position 0 in the array
                            {
                                for (int i = 0; i < this.numberOfPlayers; i++) //CHECK if i < this.numberOfPlayers bugs.
                                {
                                    if (playerArray[0][i] == 5)
                                    {
                                        threeTiedPlayerArray[1][i] = playerArray[1][i]; //Takes the position of every player that rolled 5.
                                        threeTiedPlayersNames[i] = playerNames[i];
                                    }
                                }
                            }
                            System.out.println();
                            if (timesTied < 2)
                                System.out.println(threeTiedPlayersNames[0] + ", " + threeTiedPlayersNames[1] + ", and " + threeTiedPlayersNames[2] + ", you are in a tie. Roll again.");
                            else    
                                System.out.println(threeTiedPlayersNames[0] + ", " + threeTiedPlayersNames[1] + ", and " + threeTiedPlayersNames[2] + ", you are still in a tie. Roll again.");

                            for (int i = 0; i < 3; i++)
                            {
                                System.out.print(threeTiedPlayersNames[i] + ", press <enter> to roll: ");
                                key.nextLine();
                                threeTiedPlayerArray[0][i] = flipDice(); //Reflipping
                                System.out.println("\tYou rolled a " + threeTiedPlayerArray[0][i]);

                                if (threeTiedPlayerArray[0][i] == 1)
                                    counter1++;
                                if (threeTiedPlayerArray[0][i] == 2)
                                    counter2++;
                                if (threeTiedPlayerArray[0][i] == 3)
                                    counter3++;
                                if (threeTiedPlayerArray[0][i] == 4)
                                    counter4++;
                                if (threeTiedPlayerArray[0][i] == 5)
                                    counter5++;
                                if (threeTiedPlayerArray[0][i] == 6)
                                    counter6++;
                            }
                        }
                        if (counter6 == 3)
                        {
                            timesTied++;
                            was6 = true;
                            counter1 = 0; counter2 = 0; counter3 = 0; counter4 = 0; counter5 = 0; counter6 = 0;
                        
                        //6 is always the highest rolled dice number.
                            for (int i = 0; i < this.numberOfPlayers; i++) //CHECK if i < this.numberOfPlayers bugs.
                            {
                                if (playerArray[0][i] == 6)
                                {
                                    threeTiedPlayerArray[1][i] = playerArray[1][i]; //Takes the position of every player that rolled 6.
                                    threeTiedPlayersNames[i] = playerNames[i];
                                }
                            }
                            System.out.println();
                            if (timesTied < 2)
                                System.out.println(threeTiedPlayersNames[0] + ", " + threeTiedPlayersNames[1] + ", and " + threeTiedPlayersNames[2] + ", you are in a tie. Roll again.");
                            else    
                                System.out.println(threeTiedPlayersNames[0] + ", " + threeTiedPlayersNames[1] + ", and " + threeTiedPlayersNames[2] + ", you are still in a tie. Roll again.");

                            for (int i = 0; i < 3; i++)
                            {
                                System.out.print(threeTiedPlayersNames[i] + ", press <enter> to roll: ");
                                key.nextLine();
                                threeTiedPlayerArray[0][i] = flipDice(); //Reflipping
                                System.out.println("\tYou rolled a " + threeTiedPlayerArray[0][i]);

                                if (threeTiedPlayerArray[0][i] == 1)
                                    counter1++;
                                if (threeTiedPlayerArray[0][i] == 2)
                                    counter2++;
                                if (threeTiedPlayerArray[0][i] == 3)
                                    counter3++;
                                if (threeTiedPlayerArray[0][i] == 4)
                                    counter4++;
                                if (threeTiedPlayerArray[0][i] == 5)
                                    counter5++;
                                if (threeTiedPlayerArray[0][i] == 6)
                                    counter6++;
                            }
                        } 

                    //Sorting the array of the 3 players tied in order based on their new dice roll.
                        for (int i = 0; i < 3; i++)
                        {
                            for (int j = i + 1; j < 3; j++)
                            {
                                if (threeTiedPlayerArray[0][j] > threeTiedPlayerArray[0][i])
                                {
                                    int temp = threeTiedPlayerArray[0][i];
                                    threeTiedPlayerArray[0][i] = threeTiedPlayerArray[0][j];
                                    threeTiedPlayerArray[0][j] = temp;
                                    int tampon = threeTiedPlayerArray[1][i];
                                    threeTiedPlayerArray[1][i] = threeTiedPlayerArray[1][j];
                                    threeTiedPlayerArray[1][j] = tampon;
                                    String tempname = threeTiedPlayersNames[i];
                                    threeTiedPlayersNames[i] = threeTiedPlayersNames[j];
                                    threeTiedPlayersNames[j] = tempname;
                                }
                            }
                        }

                        if (counter1 == 3 || counter2 == 3 || counter3 == 3 || counter4 == 3 || counter5 == 3 || counter6 == 3)
                            continue;

                    //If 2 players still remain tied after the 3 players who were tied rolled again.
                        boolean entered = false;
                        for (int i = 0; i < 3; i++)
                        {
                            for (int j = i + 1; j < 3; j++)
                            {
                                while (threeTiedPlayerArray[0][i] == threeTiedPlayerArray[0][j])
                                {
                                    System.out.println(threeTiedPlayersNames[i] + " and " + threeTiedPlayersNames[j] + ", you are still in a tie. Roll again.");
                                    System.out.print(threeTiedPlayersNames[i] + ", press <enter> to roll: ");
                                    key.nextLine();
                                    threeTiedPlayerArray[0][i] = flipDice();
                                    System.out.println("\tYou rolled a " + threeTiedPlayerArray[0][i] + ".");
                                    
                                    System.out.print(threeTiedPlayersNames[j] + ", press <enter> to roll: ");
                                    key.nextLine();
                                    threeTiedPlayerArray[0][j] = flipDice();
                                    System.out.println("\tYou rolled a " + threeTiedPlayerArray[0][j] + ".");

                                //Sorting in order the 2 players who were tied after their re-roll.    
                                    if (threeTiedPlayerArray[0][j] > threeTiedPlayerArray[0][i])
                                    {
                                        entered = true;
                                        int temp = threeTiedPlayerArray[0][i];
                                        threeTiedPlayerArray[0][i] = threeTiedPlayerArray[0][j];
                                        threeTiedPlayerArray[0][j] = temp;
                                        int tampon = threeTiedPlayerArray[1][i];
                                        threeTiedPlayerArray[1][i] = threeTiedPlayerArray[1][j];
                                        threeTiedPlayerArray[1][j] = tampon;
                                        String tempname = threeTiedPlayersNames[i];
                                        threeTiedPlayersNames[i] = threeTiedPlayersNames[j];
                                        threeTiedPlayersNames[j] = tempname;
                                    }
                                }
                                if (entered)
                                    break;
                            }
                            if (entered)
                                break;
                        }

                //At this point, there are no more ties between any of those 3 players who were initially tied.

                    //Putting the threeTiedPlayersArray back into the playerArray and threeTiedPlayersNames back into playerNames.

                        if (single6) //6 is always highest number rolled, so 3 players tied will go after it in the array
                        {
                            for (int i = 1; i < this.numberOfPlayers; i++)
                            {
                                playerArray[0][i] = threeTiedPlayerArray[0][i-1];
                                playerArray[1][i] = threeTiedPlayerArray[1][i-1];
                                playerNames[i] = threeTiedPlayersNames[i-1];
                            }
                        }
                        else if (single5 && !was6)
                        {
                            for (int i = 1; i < this.numberOfPlayers; i++)
                            {
                                playerArray[0][i] = threeTiedPlayerArray[0][i-1];
                                playerArray[1][i] = threeTiedPlayerArray[1][i-1];
                                playerNames[i] = threeTiedPlayersNames[i-1];
                            }
                        }
                        else if (single4 && !was5 && !was6)
                        {
                            for (int i = 1; i < this.numberOfPlayers; i++)
                            {
                                playerArray[0][i] = threeTiedPlayerArray[0][i-1];
                                playerArray[1][i] = threeTiedPlayerArray[1][i-1];
                                playerNames[i] = threeTiedPlayersNames[i-1];
                            }
                        }
                        else if (single3 && !was4 && !was5 && !was6)
                        {
                            for (int i = 1; i < this.numberOfPlayers; i++)
                            {
                                playerArray[0][i] = threeTiedPlayerArray[0][i-1];
                                playerArray[1][i] = threeTiedPlayerArray[1][i-1];
                                playerNames[i] = threeTiedPlayersNames[i-1];
                            }
                        }
                        else if (single2 && !was3 && !was4 && !was5 && !was6) //triple 1 and one 2.
                        {
                            for (int i = 1; i < this.numberOfPlayers; i++)
                            {
                                playerArray[0][i] = threeTiedPlayerArray[0][i-1];
                                playerArray[1][i] = threeTiedPlayerArray[1][i-1];
                                playerNames[i] = threeTiedPlayersNames[i-1];
                            }
                        }
                        else
                        {
                            for (int i = 0; i < 3; i++)
                            {
                                playerArray[0][i] = threeTiedPlayerArray[0][i];
                                playerArray[1][i] = threeTiedPlayerArray[1][i];
                                playerNames[i] = threeTiedPlayersNames[i];
                            }
                        }

                        counter1 = 0; counter2 = 0; counter3 = 0; counter4 = 0; counter5 = 0; counter6 = 0;

                    }//End of 3 player ties for 4 players.                   

                }//End of 3 player ties.
            }

        //Checking for 2 player ties.
            while (counter1 == 2 || counter2 == 2 || counter3 == 2 || counter4 == 2 || counter5 == 2 || counter6 == 2)
            {
                //Original 2 player tie. Only 2 players are tied out of all players.
                if (numTies < 2)
                {
                    int timesTied = 0;
                    boolean entered = false;
                    for (int i = 0; i < this.numberOfPlayers; i++)
                    {
                        for (int j = i + 1; j < this.numberOfPlayers; j++)
                        {
                            if (playerArray[0][i] ==  playerArray[0][j])
                            {   
                                while (playerArray[0][i] == playerArray[0][j])
                                {
                                    entered = true;
                                    timesTied++;
                                    if (timesTied > 1)
                                        System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are still in a tie. Roll again.");
                                    else
                                        System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are in a tie.");

                                    System.out.print("\n" + playerNames[i] + ", press <enter> to roll the dice: ");
                                    key.nextLine();
                                    playerArray[0][i] = flipDice();
                                    System.out.println("\tYou rolled a " + playerArray[0][i] + ".");

                                    System.out.print("\n" + playerNames[j] + ", press <enter> to roll the dice: ");
                                    key.nextLine();
                                    playerArray[0][j] = flipDice();
                                    System.out.println("\tYou rolled a " + playerArray[0][j] + ".");
                                    if (playerArray[0][j] > playerArray[0][i])
                                    {
                                        int temp = playerArray[0][i];
                                        playerArray[0][i] = playerArray[0][j];
                                        playerArray[0][j] = temp;
                                        int tampon = playerArray[1][i];
                                        playerArray[1][i] = playerArray[1][j];
                                        playerArray[1][j] = tampon;
                                        String tempname = playerNames[i];
                                        playerNames[i] = playerNames[j];
                                        playerNames[j] = tempname;
                                    }
                                }
                                if (entered)
                                    break;
                            }
                            if (entered)
                                break;
                        }
                        if (entered)
                            break;
                    }
                    counter1=0;counter2=0;counter3=0;counter4=0;counter5=0;counter6=0;
                }

            //If there are 2 SETS of 2 player ties.
                if (numTies > 1)
                {   
                    if (counter1tie)
                    {
                        int timesTied = 0;
                        for (int i = 2; i < 4; i++)
                        {
                            for (int j = i + 1; j < 4; j++)
                            {
                                while (playerArray[0][i] == playerArray[0][j])
                                {
                                    timesTied++;
                                    if (timesTied > 1)
                                        System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are still in a tie. Roll again.");
                                    else
                                        System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are in a tie.");

                                    System.out.print("\n" + playerNames[i] + ", press <enter> to roll the dice: ");
                                    key.nextLine();
                                    playerArray[0][i] = flipDice();
                                    System.out.println("\tYou rolled a " + playerArray[0][i] + ".");

                                    System.out.print("\n" + playerNames[j] + ", press <enter> to roll the dice: ");
                                    key.nextLine();
                                    playerArray[0][j] = flipDice();
                                    System.out.println("\tYou rolled a " + playerArray[0][j] + ".");
                                }
                                if (playerArray[0][j] > playerArray[0][i])
                                {
                                    int temp = playerArray[0][i];
                                    playerArray[0][i] = playerArray[0][j];
                                    playerArray[0][j] = temp;
                                    int tampon = playerArray[1][i];
                                    playerArray[1][i] = playerArray[1][j];
                                    playerArray[1][j] = tampon;
                                    String tempname = playerNames[i];
                                    playerNames[i] = playerNames[j];
                                    playerNames[j] = tempname;
                                }
                            }
                        }
                        counter1 = 0;
                    }
                    if (counter2tie)
                    {
                        int i;
                        int j;
                        int timesTied = 0;
                        if (!counter1tie)
                        {
                            for (i = 2; i < 4; i++)
                            {
                                for (j = i + 1; j < 4; j++)
                                {
                                    while (playerArray[0][i] == playerArray[0][j])
                                    {
                                        timesTied++;
                                        if (timesTied > 1)
                                            System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are still in a tie. Roll again.");
                                        else
                                            System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are in a tie.");

                                        System.out.print("\n" + playerNames[i] + ", press <enter> to roll the dice: ");
                                        key.nextLine();
                                        playerArray[0][i] = flipDice();
                                        System.out.println("\tYou rolled a " + playerArray[0][i] + ".");

                                        System.out.print("\n" + playerNames[j] + ", press <enter> to roll the dice: ");
                                        key.nextLine();
                                        playerArray[0][j] = flipDice();
                                        System.out.println("\tYou rolled a " + playerArray[0][j] + ".");
                                    }
                                    if (playerArray[0][j] > playerArray[0][i])
                                    {
                                        int temp = playerArray[0][i];
                                        playerArray[0][i] = playerArray[0][j];
                                        playerArray[0][j] = temp;
                                        int tampon = playerArray[1][i];
                                        playerArray[1][i] = playerArray[1][j];
                                        playerArray[1][j] = tampon;
                                        String tempname = playerNames[i];
                                        playerNames[i] = playerNames[j];
                                        playerNames[j] = tempname;
                                    }
                                }
                            }
                        }
                        else
                        {
                            for (i = 0; i < 2; i++)
                            {   
                                for (j = i + 1; j < 2; j++)
                                { 
                                    while (playerArray[0][i] == playerArray[0][j])
                                    {
                                        timesTied++;
                                        if (timesTied > 1)
                                            System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are still in a tie. Roll again.");
                                        else
                                            System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are in a tie.");

                                        System.out.print("\n" + playerNames[i] + ", press <enter> to roll the dice: ");
                                        key.nextLine();
                                        playerArray[0][i] = flipDice();
                                        System.out.println("\tYou rolled a " + playerArray[0][i] + ".");

                                        System.out.print("\n" + playerNames[j] + ", press <enter> to roll the dice: ");
                                        key.nextLine();
                                        playerArray[0][j] = flipDice();
                                        System.out.println("\tYou rolled a " + playerArray[0][j] + ".");
                                    }
                                    if (playerArray[0][j] > playerArray[0][i])
                                    {
                                        int temp = playerArray[0][i];
                                        playerArray[0][i] = playerArray[0][j];
                                        playerArray[0][j] = temp;
                                        int tampon = playerArray[1][i];
                                        playerArray[1][i] = playerArray[1][j];
                                        playerArray[1][j] = tampon;
                                        String tempname = playerNames[i];
                                        playerNames[i] = playerNames[j];
                                        playerNames[j] = tempname;
                                    }
                                }
                            }
                        }
                        counter2 = 0;
                    }
                    if (counter3tie)
                    {
                        int i;
                        int j;
                        int timesTied = 0;
                        if (!counter1tie && !counter2tie)
                        {    
                            for (i = 2; i < 4; i++)
                            {
                                for (j = i + 1; j < 4; j++)
                                {
                                    while (playerArray[0][i] == playerArray[0][j])
                                    {
                                        timesTied++;
                                        if (timesTied > 1)
                                            System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are still in a tie. Roll again.");
                                        else
                                            System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are in a tie.");

                                        System.out.print("\n" + playerNames[i] + ", press <enter> to roll the dice: ");
                                        key.nextLine();
                                        playerArray[0][i] = flipDice();
                                        System.out.println("\tYou rolled a " + playerArray[0][i] + ".");

                                        System.out.print("\n" + playerNames[j] + ", press <enter> to roll the dice: ");
                                        key.nextLine();
                                        playerArray[0][j] = flipDice();
                                        System.out.println("\tYou rolled a " + playerArray[0][j] + ".");
                                    }
                                    if (playerArray[0][j] > playerArray[0][i])
                                    {
                                        int temp = playerArray[0][i];
                                        playerArray[0][i] = playerArray[0][j];
                                        playerArray[0][j] = temp;
                                        int tampon = playerArray[1][i];
                                        playerArray[1][i] = playerArray[1][j];
                                        playerArray[1][j] = tampon;
                                        String tempname = playerNames[i];
                                        playerNames[i] = playerNames[j];
                                        playerNames[j] = tempname;
                                    }
                                }
                            }
                            counter3 = 0;
                        }
                        else
                        {
                            for (i = 0; i < 2; i++)
                            {   
                                for (j = i + 1; j < 2; j++)
                                { 
                                    while (playerArray[0][i] == playerArray[0][j])
                                    {
                                        timesTied++;
                                        if (timesTied > 1)
                                            System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are still in a tie. Roll again.");
                                        else
                                            System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are in a tie.");

                                        System.out.print("\n" + playerNames[i] + ", press <enter> to roll the dice: ");
                                        key.nextLine();
                                        playerArray[0][i] = flipDice();
                                        System.out.println("\tYou rolled a " + playerArray[0][i] + ".");

                                        System.out.print("\n" + playerNames[j] + ", press <enter> to roll the dice: ");
                                        key.nextLine();
                                        playerArray[0][j] = flipDice();
                                        System.out.println("\tYou rolled a " + playerArray[0][j] + ".");
                                    }
                                    if (playerArray[0][j] > playerArray[0][i])
                                    {
                                        int temp = playerArray[0][i];
                                        playerArray[0][i] = playerArray[0][j];
                                        playerArray[0][j] = temp;
                                        int tampon = playerArray[1][i];
                                        playerArray[1][i] = playerArray[1][j];
                                        playerArray[1][j] = tampon;
                                        String tempname = playerNames[i];
                                        playerNames[i] = playerNames[j];
                                        playerNames[j] = tempname;
                                    }
                                }
                            }
                        }    
                        counter3 = 0;
                    }
                    if (counter4tie)
                    {
                        int i;
                        int j;
                        int timesTied = 0;
                        if (!counter1tie && !counter2tie && !counter3tie)
                        {    
                            for (i = 2; i < 4; i++)
                            {
                                for (j = i + 1; j < 4; j++)
                                {
                                    while (playerArray[0][i] == playerArray[0][j])
                                    {
                                        timesTied++;
                                        if (timesTied > 1)
                                            System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are still in a tie. Roll again.");
                                        else
                                            System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are in a tie.");

                                        System.out.print("\n" + playerNames[i] + ", press <enter> to roll the dice: ");
                                        key.nextLine();
                                        playerArray[0][i] = flipDice();
                                        System.out.println("\tYou rolled a " + playerArray[0][i] + ".");

                                        System.out.print("\n" + playerNames[j] + ", press <enter> to roll the dice: ");
                                        key.nextLine();
                                        playerArray[0][j] = flipDice();
                                        System.out.println("\tYou rolled a " + playerArray[0][j] + ".");
                                    }
                                    if (playerArray[0][j] > playerArray[0][i])
                                    {
                                        int temp = playerArray[0][i];
                                        playerArray[0][i] = playerArray[0][j];
                                        playerArray[0][j] = temp;
                                        int tampon = playerArray[1][i];
                                        playerArray[1][i] = playerArray[1][j];
                                        playerArray[1][j] = tampon;
                                        String tempname = playerNames[i];
                                        playerNames[i] = playerNames[j];
                                        playerNames[j] = tempname;
                                    }
                                }
                            }
                        }
                        else
                        {
                            for (i = 0; i < 2; i++)
                            {   
                                for (j = i + 1; j < 2; j++)
                                { 
                                    while (playerArray[0][i] == playerArray[0][j])
                                    {
                                        timesTied++;
                                        if (timesTied > 1)
                                            System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are still in a tie. Roll again.");
                                        else
                                            System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are in a tie.");

                                        System.out.print("\n" + playerNames[i] + ", press <enter> to roll the dice: ");
                                        key.nextLine();
                                        playerArray[0][i] = flipDice();
                                        System.out.println("\tYou rolled a " + playerArray[0][i] + ".");

                                        System.out.print("\n" + playerNames[j] + ", press <enter> to roll the dice: ");
                                        key.nextLine();
                                        playerArray[0][j] = flipDice();
                                        System.out.println("\tYou rolled a " + playerArray[0][j] + ".");
                                    }
                                    if (playerArray[0][j] > playerArray[0][i])
                                    {
                                        int temp = playerArray[0][i];
                                        playerArray[0][i] = playerArray[0][j];
                                        playerArray[0][j] = temp;
                                        int tampon = playerArray[1][i];
                                        playerArray[1][i] = playerArray[1][j];
                                        playerArray[1][j] = tampon;
                                        String tempname = playerNames[i];
                                        playerNames[i] = playerNames[j];
                                        playerNames[j] = tempname;
                                    }
                                }
                            }
                        }
                        counter4 = 0;
                    }
                    if (counter5tie)
                    {
                        int i;
                        int j;
                        int timesTied = 0;
                        if (!counter1tie && !counter2tie && !counter3tie && !counter4tie)
                        {    
                            for (i = 2; i < 4; i++)
                            {
                                for (j = i + 1; j < 4; j++)
                                {
                                    while (playerArray[0][i] == playerArray[0][j])
                                    {
                                        timesTied++;
                                        if (timesTied > 1)
                                            System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are still in a tie. Roll again.");
                                        else
                                            System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are in a tie.");

                                        System.out.print("\n" + playerNames[i] + ", press <enter> to roll the dice: ");
                                        key.nextLine();
                                        playerArray[0][i] = flipDice();
                                        System.out.println("\tYou rolled a " + playerArray[0][i] + ".");

                                        System.out.print("\n" + playerNames[j] + ", press <enter> to roll the dice: ");
                                        key.nextLine();
                                        playerArray[0][j] = flipDice();
                                        System.out.println("\tYou rolled a " + playerArray[0][j] + ".");
                                    }
                                    if (playerArray[0][j] > playerArray[0][i])
                                    {
                                        int temp = playerArray[0][i];
                                        playerArray[0][i] = playerArray[0][j];
                                        playerArray[0][j] = temp;
                                        int tampon = playerArray[1][i];
                                        playerArray[1][i] = playerArray[1][j];
                                        playerArray[1][j] = tampon;
                                        String tempname = playerNames[i];
                                        playerNames[i] = playerNames[j];
                                        playerNames[j] = tempname;
                                    }
                                }
                            }
                        }
                        else
                        {
                            for (i = 0; i < 2; i++)
                            {   
                                for (j = i + 1; j < 2; j++)
                                { 
                                    while (playerArray[0][i] == playerArray[0][j])
                                    {
                                        timesTied++;
                                        if (timesTied > 1)
                                            System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are still in a tie. Roll again.");
                                        else
                                            System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are in a tie.");

                                        System.out.print("\n" + playerNames[i] + ", press <enter> to roll the dice: ");
                                        key.nextLine();
                                        playerArray[0][i] = flipDice();
                                        System.out.println("\tYou rolled a " + playerArray[0][i] + ".");

                                        System.out.print("\n" + playerNames[j] + ", press <enter> to roll the dice: ");
                                        key.nextLine();
                                        playerArray[0][j] = flipDice();
                                        System.out.println("\tYou rolled a " + playerArray[0][j] + ".");
                                    }
                                    if (playerArray[0][j] > playerArray[0][i])
                                    {
                                        int temp = playerArray[0][i];
                                        playerArray[0][i] = playerArray[0][j];
                                        playerArray[0][j] = temp;
                                        int tampon = playerArray[1][i];
                                        playerArray[1][i] = playerArray[1][j];
                                        playerArray[1][j] = tampon;
                                        String tempname = playerNames[i];
                                        playerNames[i] = playerNames[j];
                                        playerNames[j] = tempname;
                                    }
                                }
                            }
                        }
                        counter5 = 0;
                    }
                    if (counter6tie)
                    {
                        int timesTied = 0;
                        for (int i = 0; i < 2; i++)
                        {   
                            for (int j = i + 1; j < 2; j++)
                            { 
                                while (playerArray[0][i] == playerArray[0][j])
                                {
                                    timesTied++;
                                    if (timesTied > 1)
                                        System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are still in a tie. Roll again.");
                                    else
                                        System.out.println(playerNames[i] + " and " + playerNames[j] + ", you are also in a tie.");

                                    System.out.print("\n" + playerNames[i] + ", press <enter> to roll the dice: ");
                                    key.nextLine();
                                    playerArray[0][i] = flipDice();
                                    System.out.println("\tYou rolled a " + playerArray[0][i] + ".");

                                    System.out.print("\n" + playerNames[j] + ", press <enter> to roll the dice: ");
                                    key.nextLine();
                                    playerArray[0][j] = flipDice();
                                    System.out.println("\tYou rolled a " + playerArray[0][j] + ".");
                                }
                                if (playerArray[0][j] > playerArray[0][i])
                                {
                                    int temp = playerArray[0][i];
                                    playerArray[0][i] = playerArray[0][j];
                                    playerArray[0][j] = temp;
                                    int tampon = playerArray[1][i];
                                    playerArray[1][i] = playerArray[1][j];
                                    playerArray[1][j] = tampon;
                                    String tempname = playerNames[i];
                                    playerNames[i] = playerNames[j];
                                    playerNames[j] = tempname;
                                }
                            }
                        }
                        counter6 = 0;
                    }

                }//End of 2 sets of 2 players tied.

            }//End of 2 player ties.

            System.out.println("Here is the order of play: ");
            int orderCounter = 1;
            for (int i = 0; i < this.numberOfPlayers; i++)
            {
                System.out.println("\t" + orderCounter + ". " + playerNames[i]);
                orderCounter++;
            }   

            System.out.println("\n\nGAME STARTS NOW!");

        // Initializing the start position of each player. The players start outside of
        // the board. -1 is its equivalent. Board starts at 1, but the position is 0 in
        // java.
        int[] pos = new int[this.numberOfPlayers];
        for (int e = 0; e < this.numberOfPlayers; e++) {
            pos[e] = -1;
        }

        boolean gameOver = false;

            while (gameOver == false) 
            {

                for (int i = 0; i < this.numberOfPlayers; i++) 
                {
                    System.out.print("\n" + playerNames[i] + ", it's your turn now. Press <enter> to roll the dice: ");
                    key.nextLine();
                    playerArray[0][i] = flipDice();
                    System.out.print("\tYou got a dice value of " + playerArray[0][i]);
    
                    pos[i] += playerArray[0][i];
    
                    // Deals with cases where the player rolls a number that exceeds the playing
                    // board.
                    if (pos[i] > 99) {
                        int diceRoll = playerArray[0][i];
                        int excess = pos[i] - 99;
                        int movesTo100 = diceRoll - excess;
                        pos[i] = pos[i] - diceRoll;
                        pos[i] += movesTo100;
                        pos[i] -= excess;
                    }
    
                    System.out.println("\n\tYou have moved to box " + (pos[i] + 1));
    
                    switch (pos[i]) {
                        // Cases for ladders.
    
                        case 0:
                            pos[i] = 37;
                            System.out.println(
                                    "|-| You have reached the bottom of a ladder! Climb to box 38.\n\tYou are now at box 38.");
                            break;
                        case 3:
                            pos[i] = 13;
                            System.out.println(
                                    "|-|You have reached the bottom of a ladder! Climb to box 14.\n\tYou are now at box 14.");
                            break;
                        case 8:
                            pos[i] = 30;
                            System.out.println(
                                    "|-| You have reached the bottom of a ladder! Climb to box 31.\n\tYou are now at box 31.");
                            break;
                        case 20:
                            pos[i] = 41;
                            System.out.println(
                                    "|-| You have reached the bottom of a ladder! Climb to box 42.\n\tYou are now at box 42.");
                            break;
                        case 27:
                            pos[i] = 83;
                            System.out.println(
                                    "|-| You have reached the bottom of a ladder! Climb to box 84.\n\tYou are now at box 84.");
                            break;
                        case 35:
                            pos[i] = 43;
                            System.out.println(
                                    "|-| You have reached the bottom of a ladder! Climb to box 44.\n\tYou are now at box 44.");
                            break;
                        case 50:
                            pos[i] = 66;
                            System.out.println(
                                    "|-| You have reached the bottom of a ladder! Climb to box 67.\n\tYou are now at box 67.");
                            break;
                        case 70:
                            pos[i] = 90;
                            System.out.println(
                                    "|-| You have reached the bottom of a ladder! Climb to box 91.\n\tYou are now at box 91.");
                            break;
                        case 80:
                            pos[i] = 99;
                            System.out.println(
                                    "|-| You have reached the bottom of a ladder! Climb to box 100.\n\tYou are now at box 100.");
                            break;
                        default:
                            break;
                    }
    
                    switch (pos[i]) {
                        // Cases for snakes.
                        case 15:
                            pos[i] = 5;
                            System.out.println(
                                    "---< You have reached the head of a snake :( - Wiggle down to box 6.\n\tYou are now at box 6.");
                            break;
                        case 47:
                            pos[i] = 29;
                            System.out.println(
                                    "---< You have reached the head of a snake :( - Wiggle down to box 30.\n\tYou are now at box 30.");
                            break;
                        case 63:
                            pos[i] = 59;
                            System.out.println(
                                    "---< You have reached the head of a snake :( - Wiggle down to box 60.\n\tYou are now at box 60.");
                            break;
                        case 78:
                            pos[i] = 18;
                            System.out.println(
                                    "---< You have reached the head of a snake :( - Wiggle down to box 19.\n\tYou are now at box 19.");
                            break;
                        case 92:
                            pos[i] = 67;
                            System.out.println(
                                    "---< You have reached the head of a snake :( - Wiggle down to box 68.\n\tYou are now at box 68.");
                            break;
                        case 94:
                            pos[i] = 23;
                            System.out.println(
                                    "---< You have reached the head of a snake :( - Wiggle down to box 24.\n\tYou are now at box 24.");
                            break;
                        case 96:
                            pos[i] = 75;
                            System.out.println(
                                    "---< You have reached the head of a snake :( - Wiggle down to box 76.\n\tYou are now at box 76.");
                            break;
                        case 97:
                            pos[i] = 77;
                            System.out.println(
                                    "---< You have reached the head of a snake :( - Wiggle down to box 78.\n\tYou are now at box 78.");
                            break;
                        default:
                            break;
                    }
                    
                    boolean entered = false;

                    for (int c = 0; c < this.numberOfPlayers; c++) 
                    {
                        if (pos[c] == 99) 
                        {
                            entered = true;
                            gameOver = true;
                            Board(pos[i],playerNames[i]);
                            System.out.println("\n" + playerNames[c] + " WINS.");
                            System.out.println("\n\n|------------------------- GAME OVER -------------------------|\n\n");
                        }
                        if (entered)
                        {
                           c = 4;
                           break;
                        }
                    }
                if (entered)
                {
                    break;
                }
                else
                    Board(pos[i],playerNames[i]);
            }
        }
    }
}
