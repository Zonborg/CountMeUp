package uk.bbc.countmeup.main;

import java.util.stream.IntStream;

public class Election {
    String[] canditates = {"Red", "Blue", "Yellow", "Green", "Purple"};
    int[] votes = {0, 0, 0, 0, 0};


    public void vote(String canditateName){
        boolean success = false;
        for(int i = 0; i< canditates.length; i++){
            if(canditateName.equals(canditates[i]))
            {
                votes[i] += 1;
                success = true;
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
            buildOutput.append("    ");
            buildOutput.append(votes[i]);
            buildOutput.append("\n");
        }
        return buildOutput.toString();
    }

    public String displayVotePercentage(){
        StringBuilder buildOutput = new StringBuilder();
        buildOutput.append("candidate   percentage\n");
        for (int i =0; i < canditates.length; i++)
        {
            int totalVotes = IntStream.of(votes).sum();
            int canditatePercentage = votes[i]/totalVotes*100;
            buildOutput.append(canditates[i]);
            buildOutput.append("    ");
            buildOutput.append(canditatePercentage);
            buildOutput.append("\n");

        }
        return buildOutput.toString();
    }

    public void displayCanditateNames(){
        StringBuilder buildOutput = new StringBuilder();
        buildOutput.append("candidate   count");
        for (int i =0; i < canditates.length; i++)
        {
           System.out.println(canditates[i]);
        }
    }

    public String[] getCanditates(){
        return canditates;
    }

    public int[] getVotes(){
        return votes;
    }
}
