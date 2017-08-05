package uk.bbc.countmeup.main;

/**
 * A class detailing a User of this application.  Has a name and a number of votes associated.
 */
public class User {
    private String name;
    private int votes;

    /**
     * Constructor for this class.  Takes a name, which in the case of this application is user input
     * @param name
     */
    public User(String name){
        this.name = name;
        this.votes = 0;
    }

    /**
     * A setter method for name.  Unused at present but could be used in the future.
     * @param name Sets the name of the User
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * A method to return the name of the user.
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * A method to retrieve the number of votes a user has.
     * @return
     */
    public int getVotes(){
        return votes;
    }

    /**
     * Increments the number of votes a user has made by one.
     */
    public void incrementVote(){
        this.votes += 1;
    }

}
