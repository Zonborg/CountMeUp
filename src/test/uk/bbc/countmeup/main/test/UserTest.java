package uk.bbc.countmeup.main.test;

import org.junit.Before;
import org.junit.Test;
import uk.bbc.countmeup.main.User;

import static org.junit.Assert.assertEquals;

public class UserTest {

    User sut;

    @Before
    public void setUp() {
        sut = new User("John Smith");
    }

    @Test
    public void whenGetNameIsCalledReturnsNameCorrectly(){
        assertEquals("John Smith", sut.getName());
    }

    @Test
    public void whenGetVotesIsCalledReturnsVotesCorrectly(){
        assertEquals(0, sut.getVotes());
    }

    @Test
    public void whenIncrementVotesIsCalledVotesIsIncreasedByOne(){
        sut.incrementVote();
        assertEquals(1, sut.getVotes());
    }



}
