package uk.bbc.countmeup.main;

import java.util.stream.IntStream;

public class Election {
    String[] canditates;
    int[] votes;

    public Election() {
        canditates = new String[]{"Red", "Blue", "Yellow", "Green", "Purple"};
        votes = new int[]{0, 0, 0, 0, 0};
    }

    public Election(String[] userCandidates) {
        canditates = userCandidates;
        votes = new int[canditates.length];
    }


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

    private boolean voteValid(User user){
        if(user.getVotes() < 3){
            return true;
        } else {
            return false;
        }
    }

    public String[] getCanditates(){
        return canditates;
    }

    public int[] getVotes(){
        return votes;
    }
}
