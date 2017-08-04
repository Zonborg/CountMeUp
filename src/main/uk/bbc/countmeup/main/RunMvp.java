package uk.bbc.countmeup.main;

import java.util.Scanner;

public class RunMvp {

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is your name?");
        User newUser = new User(scanner.next());
        Election generalElection = new Election();

        System.out.print("Which candidate would you like to vote for? ");
        generalElection.displayCanditateNames();

        String vote = scanner.next();
        generalElection.vote(vote);
        newUser.incrementVote();
        newUser.voteValid();
        System.out.println(generalElection.displayVoteCount());
        System.out.println(generalElection.displayVotePercentage());
    }
}
