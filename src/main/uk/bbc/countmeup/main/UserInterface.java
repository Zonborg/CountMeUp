package uk.bbc.countmeup.main;

import java.util.Scanner;

public class UserInterface {

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is your name?");
        User newUser = new User(scanner.next());
        boolean valid = false;
            while (!valid) {
                System.out.print("Would you like to create your own election?  yes or no");
                String answer = scanner.next().toLowerCase();
                if (answer.equals("no")) {
                    Election generalElection = new Election();
                    runElection(generalElection, newUser, valid);

                } else if (answer.equals("yes")) {
                    System.out.print("How many candidates would you like?");
                    int total = scanner.nextInt();
                    String[] candidates = new String[total];
                    for (int i = 0; i < total; i++) {
                        System.out.print("Please enter the name for candidate " + (i + 1));
                        String candidate = scanner.next();
                        candidates[i] = candidate;
                    }
                    Election generalElection = new Election(candidates);
                    runElection(generalElection, newUser, valid);
                } else {
                    System.out.print("Invalid entry supplied.  Please try again. \n");
                }
        }
    }

    private static boolean runElection(Election generalElection, User newUser, boolean valid) {
        boolean voteAgain = true;
        Scanner scanner = new Scanner(System.in);
        while(voteAgain) {
            valid = true;
            System.out.print("Which candidate would you like to vote for? \n");

            String[] displayNames = generalElection.getCanditateNames();
            for (int i = 0; i < displayNames.length; i++) {
                System.out.println(displayNames[i]);
            }

            String vote = scanner.next();
            generalElection.vote(vote);
            newUser.incrementVote();
            newUser.voteValid();
            System.out.println(generalElection.displayVoteCount());
            System.out.println(generalElection.getVotePercentage());
            System.out.print("Would you like to vote again?  yes or no");
            String anotherVote = scanner.next().toLowerCase();
            if (anotherVote.equals("no")) {
                voteAgain = false;
            }
        }
        return valid;
    }
}
