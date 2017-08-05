package uk.bbc.countmeup.main;

public class SimulatedElection {

    public static void main (String[] args){
        Election simulatedElection = new Election();
        User[] users = new User[1000000];
        for(int i = 0; i < users.length; i++){
            User user = new User("user" + i);
            if(i%2 == 0) {
                simulatedElection.vote("Red", user);
            } else {
                simulatedElection.vote("Blue", user);
            }
        }
        System.out.println(simulatedElection.getVotePercentage());
        System.out.println(simulatedElection.getVoteCount());
    }
}
