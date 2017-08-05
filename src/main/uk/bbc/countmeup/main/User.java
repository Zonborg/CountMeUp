package uk.bbc.countmeup.main;

public class User {
    private String name;
    private int votes;

    public User(String name){
        this.name = name;
        this.votes = 0;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setVotes(int votes){
        this.votes = votes;
    }

    public String getName(){
        return name;
    }

    public int getVotes(){
        return votes;
    }

    public void incrementVote(){
        this.votes += 1;
    }

}
