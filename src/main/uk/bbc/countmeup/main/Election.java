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


    public void vote(String canditateName){
        boolean success = false;
        for(int i = 0; i< canditates.length; i++){
            if(canditateName.toLowerCase().equals(canditates[i].toLowerCase()))
            {
                votes[i] += 1;
                success = true;
                System.out.println("Vote Successful");
            }
        }

        if(success == false) {
            System.out.println("Candidate not found.");
        }
    }

    public String displayVoteCount(){
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
            int totalVotes = IntStream.of(votes).sum();
            int canditatePercentage = votes[i]/totalVotes*100;
            buildOutput.append(canditates[i]);
            buildOutput.append("        ");
            buildOutput.append(canditatePercentage);
            buildOutput.append("\n");

        }
        return buildOutput.toString();
    }

    public String[] getCanditateNames(){
        return canditates;
    }

    public String[] getCanditates(){
        return canditates;
    }

    public int[] getVotes(){
        return votes;
    }
}
