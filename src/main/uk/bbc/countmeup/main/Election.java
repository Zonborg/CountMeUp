package uk.bbc.countmeup.main;

import java.util.stream.IntStream;

/**
 * A class which represents an election.  In future other classes could extend this so as to represent the different
 * types of elections in this country.
 */
public class Election {
    String[] canditates;
    int[] votes;

    /**
     * The default election which will be created when no parameters are passed.  Five candidates are represented with
     * their associated votes.
     */
    public Election() {
        canditates = new String[]{"Red", "Blue", "Yellow", "Green", "Purple"};
        votes = new int[]{0, 0, 0, 0, 0};
    }

    /**
     * A constructor which takes a String array which, in the case of this application, contains the user input.
     * @param userCandidates
     */
    public Election(String[] userCandidates) {
        canditates = userCandidates;
        votes = new int[canditates.length];
    }


    /**
     * This is the method which is called when a user wants to vote for a specific candidate.  This method will also
     * check if that specific user is eligible to vote.
     * @param candidateName The name of the candidate to vote for
     * @param user The user who is doing the voting
     * @return whether the user has successfully voted or not
     */
    public boolean vote(String candidateName, User user) {
        boolean isSuccessful = false;
        if (!voteValid(user)) {
            System.out.println("Vote Invalid.  You have already voted the maximum amount of times for this election.");
            return isSuccessful;
        }
        for (int i = 0; i < canditates.length; i++) {
            if (candidateName.toLowerCase().equals(canditates[i].toLowerCase())) {
                votes[i] += 1;
                isSuccessful = true;
                user.incrementVote();
                System.out.println("Vote Successful");
                return isSuccessful;
            }
        }
        return isSuccessful;
    }


    /**
     * Gets the total number of votes for each candidate
     * @return a String detailing the election voting in raw numbers
     */
    public String getVoteCount(){
        StringBuilder buildOutput = new StringBuilder();
        buildOutput.append("candidate   count\n");
        for (int i =0; i < canditates.length; i++)
        {
            buildOutput.append(canditates[i]);
            buildOutput.append("        ");
            buildOutput.append(votes[i]);
            buildOutput.append("\n");
        }
        return buildOutput.toString();
    }

    /**
     * Gets the vote percentage of each candidate.
     * @Return a String detailing the election voting in percentages
     */
    public String getVotePercentage(){
        StringBuilder buildOutput = new StringBuilder();
        buildOutput.append("candidate   percentage\n");
        for (int i =0; i < canditates.length; i++)
        {
            double totalVotes = IntStream.of(votes).sum();
            double candidatePercentage = (votes[i]/totalVotes)*100;
            buildOutput.append(canditates[i]);
            buildOutput.append("        ");
            buildOutput.append(candidatePercentage);
            buildOutput.append("\n");

        }
        return buildOutput.toString();
    }

    public String[] getCanditateNames(){
        return canditates;
    }

    /**
     * Private method which checks if the user is eligible to vote or not.  Called in the vote method.
     * @param user
     * @return
     */
    private boolean voteValid(User user){
        if(user.getVotes() < 3){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the candidates standing for election.
     * @return
     */
    public String[] getCanditates(){
        return canditates;
    }

    /**
     * Returns the number of votes for each candidate.
     * @return
     */
    public int[] getVotes(){
        return votes;
    }
}
