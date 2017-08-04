package uk.bbc.countmeup.main.test;

import org.junit.Before;
import org.junit.Test;
import uk.bbc.countmeup.main.Election;

import static org.junit.Assert.assertEquals;

public class ElectionTest {

    Election sut;

    @Before
    public void setUp() {
        sut = new Election();
    }

    @Test
    public void whenGetVotesIsCalledVotesAreReturnedCorrectly(){
        int[] votes = sut.getVotes();
        assertEquals(votes.length, 5);
    }

    @Test
    public void whenGetCandidatesIsCalledCandidatesAreReturnedCorrectly(){
        String[] candidates = sut.getCanditates();
        assertEquals(candidates.length, 5);
    }

    @Test
    public void whenAVoteIsPlacedAgainistACanditateTheirVoteIncreasesByOne(){
        sut.vote("Red");
        int[] votes = sut.getVotes();
        assertEquals(votes[0], 1);
    }

}
