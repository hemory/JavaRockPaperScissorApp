import java.sql.SQLOutput;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean keepGoing = true;
        int playerOnePoint = 0;
        int playerTwoPoint = 0;
        int computerPoint = 0;
        String playerTwoChoice;
        Dictionary computerPlaysDict = new Hashtable();
        computerPlaysDict.put(1, "Rock");
        computerPlaysDict.put(2, "Paper");
        computerPlaysDict.put(3, "Scissors");

        Random rand = new Random();
        var randComputerNum = rand.nextInt(3);
        if (randComputerNum == 0) {
            randComputerNum = 1;
        }

        System.out.println("Welcome to the RPS!!");
        System.out.println("Will you be playing alone or with a friend? Choose (1) for solo or (2) for multi-player.");

        int numberOfPlayers = input.nextInt();

        //SINGLE PLAYER FLOW
        if (numberOfPlayers == 1) {
            while (keepGoing) {


                String computerChoice = (String) computerPlaysDict.get(randComputerNum);

                System.out.println("The computer has made a choice!");
                System.out.println("PLAYER ONE select Rock, Paper, or Scissors");
                 playerTwoChoice = input.next();

                if (playerTwoChoice.equalsIgnoreCase("paper")) {
                    if (computerChoice.equalsIgnoreCase("scissors")) {
                        System.out.println("The Computer chose " + computerChoice);
                        System.out.println("The Computer Wins!");
                        computerPoint++;
                    } else if (computerChoice.equalsIgnoreCase("rock")) {
                        System.out.println("The Computer chose " + computerChoice);
                        System.out.println("Player One Wins!");
                        playerOnePoint++;
                    } else if (computerChoice.equalsIgnoreCase(playerTwoChoice)) {
                        System.out.println("Its a Tie");
                    }
                } else if (playerTwoChoice.equalsIgnoreCase("rock")) {
                    if (computerChoice.equalsIgnoreCase("scissors")) {
                        System.out.println("The Computer chose " + computerChoice);
                        System.out.println("Player One Wins!");
                        playerOnePoint++;
                    } else if (computerChoice.equalsIgnoreCase("paper")) {
                        System.out.println("The Computer chose " + computerChoice);
                        System.out.println("The Computer Wins!");
                        computerPoint++;
                    } else if (computerChoice.equalsIgnoreCase(playerTwoChoice)) {
                        System.out.println("Its a Tie");
                    }
                } else if (playerTwoChoice.equalsIgnoreCase("scissors")) {
                    if (computerChoice.equalsIgnoreCase("rock")) {
                        System.out.println("The Computer chose " + computerChoice);
                        System.out.println("The Computer Wins!");
                        computerPoint++;
                    } else if (computerChoice.equalsIgnoreCase("paper")) {
                        System.out.println("The Computer chose " + computerChoice);
                        System.out.println("Player One Wins!");
                        playerOnePoint++;
                    } else if (computerChoice.equalsIgnoreCase(playerTwoChoice)) {
                        System.out.println("Its a Tie");
                    }
                }
                System.out.print("The point total is currently: ");
                System.out.print("Player One " + playerOnePoint);
                System.out.println(" Computer " + computerPoint);
                System.out.println("Would you like to play again? y or n");

                String playAgain = input.next();

                if (playAgain.equalsIgnoreCase("y")) {
                    continue;
                } else {

                    DetermineMultiWinner(playerOnePoint, playerTwoPoint);
                    System.out.println("Thanks for playing. GoodBye!");
                    break;
                }
            }


        }


        //MULTIPLAYER FLOW
        if (numberOfPlayers == 2) {

            while (keepGoing) {


                System.out.println("Player One select Rock, Paper, or Scissors");
                String playerOneChoice = input.next();


                System.out.println("Player Two select Rock, Paper, or Scissors");
                playerTwoChoice = input.next();

                if (playerOneChoice.equalsIgnoreCase("paper")) {
                    if (playerTwoChoice.equalsIgnoreCase("scissors")) {
                        System.out.println("Player Two Wins!");
                        playerTwoPoint++;
                    } else if (playerTwoChoice.equalsIgnoreCase("rock")) {
                        System.out.println("Player One Wins!");
                        playerOnePoint++;
                    } else if (playerTwoChoice.equalsIgnoreCase(playerOneChoice)) {
                        System.out.println("Its a Tie");
                    }
                } else if (playerOneChoice.equalsIgnoreCase("rock")) {
                    if (playerTwoChoice.equalsIgnoreCase("scissors")) {
                        System.out.println("Player One Wins!");
                        playerOnePoint++;
                    } else if (playerTwoChoice.equalsIgnoreCase("paper")) {
                        System.out.println("Player Two Wins!");
                        playerTwoPoint++;
                    } else if (playerTwoChoice.equalsIgnoreCase(playerOneChoice)) {
                        System.out.println("Its a Tie");
                    }
                } else if (playerOneChoice.equalsIgnoreCase("scissors")) {
                    if (playerTwoChoice.equalsIgnoreCase("rock")) {
                        System.out.println("Player Two Wins!");
                        playerTwoPoint++;
                    } else if (playerTwoChoice.equalsIgnoreCase("paper")) {
                        System.out.println("Player One Wins!");
                        playerOnePoint++;
                    } else if (playerTwoChoice.equalsIgnoreCase(playerOneChoice)) {
                        System.out.println("Its a Tie");
                    }


                }
                System.out.print("The point total is currently:");
                System.out.print("Player One " + playerOnePoint);
                System.out.println(" Player Two " + playerTwoPoint);
                System.out.println("Would you like to play again? y or n");

                String playAgain = input.next();

                if (playAgain.equalsIgnoreCase("y")) {
                    continue;
                } else {

                    DetermineSingleWinner(playerOnePoint, playerTwoPoint);
                    System.out.println("Thanks for playing. GoodBye!");
                    break;
                }
            }



        }


    }

    //METHODS
    private static void DetermineSingleWinner ( int playerOnePoint, int playerTwoPoint){
        System.out.println("The final score is PLAYER ONE: " + playerOnePoint + " and PLAYER TWO: " + playerTwoPoint);

        if (playerOnePoint > playerTwoPoint) {
            System.out.println("The winner of this match is PLAYER ONE!");
        } else {
            System.out.println("The winner of this match is PLAYER TWO!");
        }
    }

    private static void DetermineMultiWinner ( int playerOnePoint, int computerPoint){
        System.out.println("The final score is PLAYER ONE: " + playerOnePoint + " and COMPUTER: " + computerPoint);

        if (playerOnePoint > computerPoint) {
            System.out.println("The winner of this match is PLAYER ONE!");
        } else {
            System.out.println("The winner of this match is the COMPUTER!");
        }
    }



}
